package pl.understandable.understandable_app.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import pl.understandable.understandable_app.R;
import pl.understandable.understandable_app.database.repository.CustomWordsSetsRepository;
import pl.understandable.understandable_app.database.repository.IrregularVerbEntityRepository;
import pl.understandable.understandable_app.database.repository.PhraseEntityRepository;
import pl.understandable.understandable_app.database.repository.WordEntityRepository;
import pl.understandable.understandable_app.user.UserManager;
import pl.understandable.understandable_app.utils.RateAppUtil;

/**
 * Created by Marcin Zielonka on 2017-11-07.
 */

public class StartActivity extends AppCompatActivity {

    private static final long TIME_WAITING_IN_MILLIS = 3000;

    private ImageView icon;

    @Override
    public void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            Toast.makeText(getApplicationContext(), "Signed in silently as " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
            Log.d("USER", "Token ID: " + account.getIdToken());
            UserManager.getUser().setTokenId(account.getIdToken());
            UserManager.setUserStatus(UserManager.UserStatus.SIGNED_IN);
        } else {
            Toast.makeText(getApplicationContext(), "No account", Toast.LENGTH_SHORT).show();
            UserManager.setUserStatus(UserManager.UserStatus.NO_ACCOUNT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_activity_start_screen);

        icon = (ImageView) findViewById(R.id.f_content_start_screen_icon);
        setAnimation();

        new RateAppUtil(getApplicationContext()).updateAmountOfAppOpenings();
        new LoadDataTask().execute();
    }

    private void setAnimation() {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.start);
        icon.startAnimation(anim);
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        private long timeStart;

        public LoadDataTask() {
            timeStart = System.currentTimeMillis();
        }

        @Override
        protected Void doInBackground(Void... params) {
            WordEntityRepository.init(getApplicationContext());
            IrregularVerbEntityRepository.init(getApplicationContext());
            CustomWordsSetsRepository.init(getApplicationContext());
            PhraseEntityRepository.init(getApplicationContext());

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            long timeFinish = System.currentTimeMillis();
            long time = timeFinish - timeStart;
            long delay = TIME_WAITING_IN_MILLIS - time;
            if(delay <= 10) {
                delay = 10;
            }

            android.os.Handler handler = new android.os.Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    StartActivity.this.startActivity(intent);
                    StartActivity.this.finish();
                }
            }, delay);

            //Toast.makeText(getApplicationContext(), "Time loading: " + String.valueOf(time) + "ms", Toast.LENGTH_LONG).show();
        }

    }

}
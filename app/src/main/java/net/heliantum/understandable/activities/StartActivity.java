package net.heliantum.understandable.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import net.heliantum.understandable.R;

public class StartActivity extends AppCompatActivity {

    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_activity_start_screen);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(Color.BLACK);

        icon = (ImageView) findViewById(R.id.f_content_start_screen_icon);
        setAnimation();

        ActivityStarter starter = new ActivityStarter();
        starter.start();
    }

    private void setAnimation() {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pulse);
        icon.startAnimation(anim);
    }

    private class ActivityStarter extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(StartActivity.this, NavigationActivity.class);
            StartActivity.this.startActivity(intent);
            StartActivity.this.finish();
        }
    }

}
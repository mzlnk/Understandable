package pl.understandable.understandable_app.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import pl.understandable.understandable_app.R;
import pl.understandable.understandable_app.data.enums.themes.ThemeType;
import pl.understandable.understandable_app.fragments.start.StartFragment;
import pl.understandable.understandable_app.listeners.BackButtonListener;
import pl.understandable.understandable_app.listeners.NavigationListener;
import pl.understandable.understandable_app.utils.ThemeUtil;
import pl.understandable.understandable_app.utils.font.Font;

import static pl.understandable.understandable_app.utils.FragmentUtil.APP_EXIT;
import static pl.understandable.understandable_app.utils.FragmentUtil.redirectTo;

/**
 * Created by Marcin Zielonka on 2017-11-07.
 */

public class NavigationActivity extends AppCompatActivity {

    public static NavigationActivity activity;

    public DrawerLayout drawer;
    private NavigationView navigationView;
    private TextView navigationTitle;

    private int currentThemeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_navigation);

        loadViewsFromXml();
        setDefaultTheme();
        setFonts();
        addListeners();
        prepareNavigationView();
        showStartFragment();
        showWindowMetrics();
    }

    @Override
    public void onBackPressed() {
        new BackButtonListener(this).onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void loadViewsFromXml() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationTitle = (TextView) navigationView.getHeaderView(0).findViewById(R.id.navigation_title);
    }

    private void setFonts() {
        navigationTitle.setTypeface(Font.TYPEFACE_MONTSERRAT);
    }

    private void addListeners() {
        navigationView.setNavigationItemSelectedListener(new NavigationListener(this));
    }

    private void showStartFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragments, new StartFragment(), redirectTo(APP_EXIT)).commit();
    }

    private void setDefaultTheme() {
        String sharedPrefFileName = getString(R.string.sp_preferences_file_key);
        String sharedPrefThemeKey = getString(R.string.sp_theme_key);
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefFileName, Context.MODE_PRIVATE);
        currentThemeId = sharedPreferences.getInt(sharedPrefThemeKey, ThemeType.THEME_DAY.getThemeId());
        setTheme(currentThemeId);
    }

    private void prepareNavigationView() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);

        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationView.getLayoutParams();
        params.width = (int)(dm.widthPixels * 0.8F);
        navigationView.setLayoutParams(params);

        if(ThemeUtil.isDefaultTheme(currentThemeId)) {
            navigationView.setBackgroundResource(R.drawable.field_half_rounded_white);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
            navigationTitle.setTextColor(Color.BLACK);
        } else {
            navigationView.setBackgroundResource(R.drawable.field_half_rounded_dark_dark_gray);
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
            navigationTitle.setTextColor(Color.WHITE);
        }
    }

    private void showWindowMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        int width = Math.round(dm.widthPixels / dm.density);
        int height = Math.round(dm.heightPixels / dm.density);

        Toast.makeText(getApplicationContext(), "width: " + width + "dp\nheight: " + height + "dp", Toast.LENGTH_SHORT).show();
    }

}

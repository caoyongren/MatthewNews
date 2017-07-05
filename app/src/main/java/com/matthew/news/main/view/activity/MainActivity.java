package com.matthew.news.main.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.matthew.news.R;
import com.matthew.news.about.AboutFragment;
import com.matthew.news.images.view.fragment.ImageFragment;
import com.matthew.news.main.presenter.MainPresenter;
import com.matthew.news.main.presenter.MainPresenterImpl;
import com.matthew.news.main.view.MainView;
import com.matthew.news.news.view.fragment.NewsFragment;
import com.matthew.news.weather.view.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity implements MainView {
    /*测试git，，，liu*/
    /*branch*/

    /*
    * AppCompatActivity 和 Activity的区别：
    * 1. AppCompatActivity是默认带标题的。
    * 2. AppCompatActivity和repquestWindowFeature(Window.FEATURE_NO_TITLE);有冲突。
    * 3. 当活动继承AppCompatActivity是在设置取消标题则程序直接挂掉。
    * */
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
        mMainPresenter = new MainPresenterImpl(this);
        switchTwoNews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void switchTwoNews() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        mToolbar.setTitle(R.string.navigation_news);
    }

    @Override
    public void switchTwoImages() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImageFragment()).commit();
        mToolbar.setTitle(R.string.navigation_images);
    }

    @Override
    public void switchTwoWeather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
        mToolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switchTwoAbout() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }
}

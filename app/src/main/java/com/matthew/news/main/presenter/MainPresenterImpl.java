package com.matthew.news.main.presenter;

import com.matthew.news.R;
import com.matthew.news.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mMainView.switchTwoNews();
                break;
            case R.id.navigation_item_images:
                mMainView.switchTwoImages();
                break;
            case R.id.navigation_item_weather:
                mMainView.switchTwoWeather();
                break;
            case R.id.navigation_item_about:
                mMainView.switchTwoAbout();
                break;
            default:
                mMainView.switchTwoNews();
                break;
        }
    }
}

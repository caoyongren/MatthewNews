package com.matthew.news.news.view;


import com.matthew.news.beans.NewsBean;

import java.util.List;

public interface NewsView {

    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}

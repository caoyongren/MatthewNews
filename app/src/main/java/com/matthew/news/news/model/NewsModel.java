package com.matthew.news.news.model;


public interface NewsModel {

    void loadNews(String url, int type, OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, com.matthew.news.news.model.OnLoadNewsDetailListener listener);

}

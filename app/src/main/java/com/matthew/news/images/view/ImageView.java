package com.matthew.news.images.view;

import com.matthew.news.beans.ImageBean;

import java.util.List;

/**
 * Description :
 * Author : Matthew
 */
public interface ImageView {
    void addImages(List<ImageBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}

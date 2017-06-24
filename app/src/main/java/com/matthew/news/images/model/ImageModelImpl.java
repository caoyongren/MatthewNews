package com.matthew.news.images.model;

import com.matthew.news.beans.ImageBean;
import com.matthew.news.constants.Urls;
import com.matthew.news.images.utils.ImageJsonUtils;
import com.matthew.news.utils.OkHttpUtils;

import java.util.List;

public class ImageModelImpl implements ImageModel {

    /**
     * 获取图片列表
     * @param listener
     */
    @Override
    public void loadImageList(final OnLoadImageListListener listener) {
        String url = Urls.IMAGES_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<ImageBean> iamgeBeanList = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(iamgeBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load image list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    /**
     * 图片加载的监听;
     * 1. 图片加载成功;
     * 2. 图片加载失败;
     * */
    public interface OnLoadImageListListener {
        void onSuccess(List<ImageBean> list);
        void onFailure(String msg, Exception e);
    }
}

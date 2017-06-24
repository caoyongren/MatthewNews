package com.matthew.news.images.model;

/**
 * Description :
 * Author : Matthew
 */
public interface ImageModel {
    /**
     * 监听式接口回掉:
     * 应用 -- > 数据的加载 success or failure.{@ImageModelImpl.java}
     * */
    void loadImageList(ImageModelImpl.OnLoadImageListListener listener);
}

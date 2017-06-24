package com.matthew.news.images.presenter;


import com.matthew.news.beans.ImageBean;
import com.matthew.news.images.model.ImageModel;
import com.matthew.news.images.model.ImageModelImpl;
import com.matthew.news.images.view.ImageView;

import java.util.List;

/**
 * Description :
 * Author : Matthew
 */
public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private ImageModel mImageModel;
    private ImageView mImageView;

    public ImagePresenterImpl(ImageView imageView) {
        this.mImageModel = new ImageModelImpl();
        this.mImageView = imageView;
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModel.loadImageList(this);
    }

    /**
     * @param list 是数据源
     * {@ImageModelImpl}中通过implements {@ImageModel}
     * 通过简单的接口回调方法中, 使用OkHttp获取数据.
     * {@ImagePresenterImpl}通过暴露的接口拿到数据然后给View.
     * */
    @Override
    public void onSuccess(List<ImageBean> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }
}

package com.lauren.matthewnews.news.model;

import com.lauren.matthewnews.beans.NewsDetailBean;

/**
 * Description : 新闻详情加载回调
 * Author :
 * Github  :
 * Date   :
 */
public interface OnLoadNewsDetailListener {

    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg, Exception e);
}

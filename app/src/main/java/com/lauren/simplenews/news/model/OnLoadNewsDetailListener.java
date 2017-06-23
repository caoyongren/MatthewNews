package com.lauren.simplenews.news.model;

import com.lauren.simplenews.beans.NewsDetailBean;

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

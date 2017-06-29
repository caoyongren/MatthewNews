package com.matthew.news.images.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matthew.news.R;
import com.matthew.news.beans.ImageBean;
import com.matthew.news.images.view.fragment.ImageFragment;
import com.matthew.news.utils.ImageLoaderUtils;
import com.matthew.news.utils.ToolsUtil;
import com.matthew.news.widget.view.CircleImageView;

import java.util.List;
  /**
   * Description:
   * Author: Matthew
   * 1. 适配器参数
   *  @param {ImageAdapter.ItemViewHolder}
   * */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder> {
    private final static String TAG = "ImageAdapter";
    private List<ImageBean> mListImageData; //数据源
    private Context mContext;//上下文
    private int mMaxWidth;
    private int mMaxHeight;

    private OnItemClickListener mOnItemClickListener;

    public ImageAdapter(Context context) {
        this.mContext = context;
        mMaxWidth = ToolsUtil.getWidthInPx(mContext) - 20;
        mMaxHeight = ToolsUtil.getHeightInPx(mContext) - ToolsUtil.getStatusHeight(mContext) -
                ToolsUtil.dip2px(mContext, 96);
    }

    public void setData(List<ImageBean> data) {
        this.mListImageData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public ImageAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        ItemViewHolder vh = new ItemViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ItemViewHolder holder, int position) {
        ImageBean imageBean = mListImageData.get(position);
        if(imageBean == null) {
            return;
        }
        holder.mTitle.setText(imageBean.getTitle());
        float scale = (float)imageBean.getWidth() / (float) mMaxWidth;
        int height = (int)(imageBean.getHeight() / scale);
        if(height > mMaxHeight) {
            height = mMaxHeight;
        }
        holder.mImage.setLayoutParams(new LinearLayout.LayoutParams(mMaxWidth, height));
//        Bitmap bitmap = ImageLoaderUtils.convertViewToBitmap(holder.mImage);
//        holder.mImage.setImage(bitmap);
        ImageLoaderUtils.display(mContext, holder.mImage, imageBean.getThumburl());
    }

    @Override
    public int getItemCount() {
        if(mListImageData == null) {
            return 0;
        }
        return mListImageData.size();
    }

    public ImageBean getItem(int position) {
        return mListImageData == null ? null : mListImageData.get(position);
    }

    /**
     * 給RecyclerView 增加監聽器的一般方式:
     * {@link ImageFragment}
     * 初始化后, 增加监听器的处理时间;
     * */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public CircleImageView mImage;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mImage = (CircleImageView) v.findViewById(R.id.ivImage);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}

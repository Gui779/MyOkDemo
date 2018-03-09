package com.example.earl.myok0308.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.earl.myok0308.R;
import com.example.earl.myok0308.entity.ResultBeans;

import java.util.ArrayList;

/**
 * Created by Earl on 2018/3/9.
 */

public class MyRsvAdapter extends RecyclerView.Adapter<MyRsvAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<ResultBeans.ResultBean.DataBean> list;

    public MyRsvAdapter(Context context, ArrayList<ResultBeans.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.rsv_item,null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder.titleImg);
        holder.titleTv.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView titleImg;
        private TextView titleTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.titleImg = itemView.findViewById(R.id.title_img);
            this.titleTv = itemView.findViewById(R.id.title_tv);
        }

        public ImageView getTitleImg() {
            return titleImg;
        }

        public void setTitleImg(ImageView titleImg) {
            this.titleImg = titleImg;
        }

        public TextView getTitleTv() {
            return titleTv;
        }

        public void setTitleTv(TextView titleTv) {
            this.titleTv = titleTv;
        }
    }
}

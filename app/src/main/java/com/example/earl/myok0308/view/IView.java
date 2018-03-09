package com.example.earl.myok0308.view;

import android.content.Context;

import com.example.earl.myok0308.entity.ResultBeans;

import java.util.ArrayList;

/**
 * Created by Earl on 2018/3/9.
 */

public interface IView {
    void getDataSuccess(Context context, ArrayList<ResultBeans.ResultBean.DataBean> list);
    void getDataError(String json);
}

package com.example.earl.myok0308.model;

import com.example.earl.myok0308.entity.ResultBeans;

import java.util.ArrayList;

/**
 * Created by Earl on 2018/3/9.
 */

public interface GeListenter {
    void getSuccess(ArrayList<ResultBeans.ResultBean.DataBean> list);
    void getError(String error);
}

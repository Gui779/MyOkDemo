package com.example.earl.myok0308.presenter;

import android.content.Context;

import com.example.earl.myok0308.entity.ResultBeans;
import com.example.earl.myok0308.model.GeListenter;
import com.example.earl.myok0308.model.IModel;
import com.example.earl.myok0308.view.IView;

import java.util.ArrayList;

/**
 * Created by Earl on 2018/3/9.
 */

public class PresenterIml implements IPresenter{
    @Override
    public void showData(final Context context, IModel iModel, final IView iView) {
        iModel.setData(context, new GeListenter() {
            @Override
            public void getSuccess(ArrayList<ResultBeans.ResultBean.DataBean> list) {
                iView.getDataSuccess(context,list);
            }

            @Override
            public void getError(String error) {

            }
        });
    }
}

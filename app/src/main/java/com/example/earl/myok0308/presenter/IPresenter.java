package com.example.earl.myok0308.presenter;

import android.content.Context;

import com.example.earl.myok0308.model.IModel;
import com.example.earl.myok0308.view.IView;

/**
 * Created by Earl on 2018/3/9.
 */

public interface IPresenter {
    void showData(Context context, IModel iModel, IView iView);
}

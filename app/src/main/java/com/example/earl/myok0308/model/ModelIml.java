package com.example.earl.myok0308.model;

import android.content.Context;
import android.util.Log;

import com.example.earl.myok0308.common.Constants;
import com.example.earl.myok0308.entity.ResultBeans;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Earl on 2018/3/9.
 */
public class ModelIml implements IModel {
    ArrayList<ResultBeans.ResultBean.DataBean> list = list = new ArrayList<>();

    @Override
    public void setData(Context context, final GeListenter geListenter) {

        getData();

        //网络请求耗时操作,请求成功之后才给list赋值
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    geListenter.getSuccess(list);
                    for (int i = 0; i < list.size(); i++) {
                        Log.d("TAG", "-----------------" + list.get(i).getTitle().toString());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private void getData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(Constants.URL).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                Gson gson = new Gson();
                ResultBeans resultBeans = gson.fromJson(string, ResultBeans.class);
                List<ResultBeans.ResultBean.DataBean> data = resultBeans.getResult().getData();
                list.addAll(data);

            }
        });
    }
}

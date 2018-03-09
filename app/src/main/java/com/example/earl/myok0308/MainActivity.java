package com.example.earl.myok0308;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.earl.myok0308.entity.ResultBeans;
import com.example.earl.myok0308.model.ModelIml;
import com.example.earl.myok0308.model.adapter.MyRsvAdapter;
import com.example.earl.myok0308.presenter.PresenterIml;
import com.example.earl.myok0308.view.IView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private RecyclerView rsv;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getBtn=findViewById(R.id.getBtn);
        rsv = findViewById(R.id.rsv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rsv.setLayoutManager(linearLayoutManager);
        getBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        PresenterIml presenterIml = new PresenterIml();
        presenterIml.showData(MainActivity.this,new ModelIml(),this);
        Toast.makeText(MainActivity.this,"加载....",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataSuccess(Context context, final ArrayList<ResultBeans.ResultBean.DataBean> list) {
        for (int i = 0; i < list.size(); i++) {
            Log.d("TAG2","-----------------"+list.get(i).getTitle().toString());
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyRsvAdapter myRsvAdapter = new MyRsvAdapter(MainActivity.this, list);
                rsv.setAdapter(myRsvAdapter);
            }
        });

    }

    @Override
    public void getDataError(String json) {

    }
    //切换布局管理者
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.item,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.one:
//                //ListView
//                rsv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                break;
//            case R.id.two:
//                //GridView
//                rsv.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
//                break;
//            case R.id.three:
//                //瀑布流
//                rsv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}

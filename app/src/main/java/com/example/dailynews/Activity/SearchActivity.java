package com.example.dailynews.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailynews.R;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SearchActivity extends AppCompatActivity {
    // 1. 初始化搜索框变量
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. 绑定视图
        setContentView(R.layout.activity_search);

        // 3. 绑定组件
        searchView = (SearchView) findViewById(R.id.search_view);

        // 4. 设置点击键盘上的搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                Intent intent= new Intent(SearchActivity.this,SearchResultActivity.class);
                intent.putExtra("keyWord",string);

                System.out.println("我收到了" + string);
                startActivity(intent);
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }
}

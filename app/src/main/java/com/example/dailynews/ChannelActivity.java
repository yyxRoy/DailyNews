package com.example.dailynews;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends AppCompatActivity {

    public RecyclerView myCategoryRecyView,leftCategoryRecyView;
    public TagListAdapter myAdapter,leftAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_manage);
        toolbar=findViewById(R.id.toolbar_category_manage);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        myCategoryRecyView = (RecyclerView) findViewById(R.id.myCategoryRecyView);
        myCategoryRecyView.setLayoutManager(new GridLayoutManager(this, 4));
        myAdapter = new TagListAdapter(this, TagManager.myCategoryList);
        myCategoryRecyView.setAdapter(myAdapter);
        //关联ItemTouchHelper
        ItemTouchHelper myTouchHelper = new ItemTouchHelper(new MyItemTouchCallBack(myAdapter));
        myTouchHelper.attachToRecyclerView(myCategoryRecyView);
        myAdapter.setItemClickListener(new TagListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemAddDel(true,position);
            }
        });

        leftCategoryRecyView=(RecyclerView) findViewById(R.id.leftCategoryRecyView);
        leftCategoryRecyView.setLayoutManager(new GridLayoutManager(this, 4));
        leftAdapter = new TagListAdapter(this, TagManager.leftCategoryList);
        leftCategoryRecyView.setAdapter(leftAdapter);
        //关联ItemTouchHelper

        ItemTouchHelper leftTouchHelper = new ItemTouchHelper(new MyItemTouchCallBack(leftAdapter));
        leftTouchHelper.attachToRecyclerView(leftCategoryRecyView);
        leftAdapter.setItemClickListener(new TagListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemAddDel(false,position);
            }
        });
    }
    private void itemAddDel(boolean isChosen,int position){
        if(isChosen){
            TagManager.leftCategoryList.add(TagManager.myCategoryList.get(position));
            TagManager.myCategoryList.remove(position);
        }else {
            TagManager.myCategoryList.add(TagManager.leftCategoryList.get(position));
            TagManager.leftCategoryList.remove(position);
        }
        myAdapter.notifyDataSetChanged();
        leftAdapter.notifyDataSetChanged();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                setResult(Activity.RESULT_OK);
                ChannelActivity.this.finish();
                break;
            default:
                break;
        }
        return true;
    }
}
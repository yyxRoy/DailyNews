package com.example.dailynews.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.example.dailynews.R;

public class WebActivity extends AppCompatActivity {

    private Toolbar toolbar,ltoolBar;
    private TextView newsBodyTitle,newsBodyTimeSource,newsBodyDetails;
    private ProgressBar newsBodyDetailLoading;
    private String title,source,time,content;
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //获取传递的路径
        toolbar = (Toolbar) findViewById(R.id.toolbar_webview);
        ltoolBar = (Toolbar) findViewById(R.id.toolbar_webcomment);
        newsBodyTitle = (TextView) findViewById(R.id.news_body_title);
        newsBodyTimeSource = (TextView) findViewById(R.id.news_body_ptime_source);
        newsBodyDetails= (TextView) findViewById(R.id.news_body_details);
        Intent intent=getIntent();
        title=intent.getStringExtra("title");
        source=intent.getStringExtra("source");
        time=intent.getStringExtra("time");
        content=intent.getStringExtra("content");

        findViewById(R.id.toolbar_webcomment).bringToFront();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //显示JavaScript页面
        newsBodyTitle.setText(title);
        newsBodyTimeSource.setText(source+" "+time);
        newsBodyDetails.setText(content);
        //System.out.println(data.getContent());
        //setSupportActionBar(ltoolBar);
        toolbar.setTitle("知疫");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("I'mhererrreertrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        getMenuInflater().inflate(R.menu.toolbar_webview,menu);
        if(!flag){
            ltoolBar.inflateMenu(R.menu.tool_webbootom);
            flag=true;
        }
        ltoolBar.setTitle("感谢观看");
        ltoolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.news_share:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_SUBJECT,title);
                        intent.setType("text/plain");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(intent,getTitle()));
                        break;
                    case R.id.news_collect:
                        //下一步实现点击收藏功能，以及用户查看收藏功能
                        break;
                }
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent returnIntent = new Intent();
                Toast.makeText(this,"返回",Toast.LENGTH_SHORT).show();
                WebActivity.this.finish();
                break;
            case R.id.news_setting:
                Toast.makeText(this,"夜间模式",Toast.LENGTH_SHORT).show();
                break;
            case R.id.news_feedback:
                break;
            default:
                break;
        }
        return true;
    }
}


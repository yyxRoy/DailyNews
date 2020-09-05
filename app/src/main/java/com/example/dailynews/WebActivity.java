package com.example.dailynews;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.example.dailynews.json.NewsDetail;
import com.google.gson.Gson;

public class WebActivity extends AppCompatActivity {

    private Toolbar toolbar,ltoolBar;
    private TextView newsBodyTitle,newsBodyTimeSource,newsBodyDetails;
    private ProgressBar newsBodyDetailLoading;
    private NewsDetail newsDetail;
    String url;
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
        newsBodyDetailLoading=(ProgressBar)findViewById(R.id.news_body_detail_loding);
        Intent intent=getIntent();
        String json=intent.getStringExtra("json");
        newsDetail = new Gson().fromJson(json,NewsDetail.class);
        findViewById(R.id.toolbar_webcomment).bringToFront();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //显示JavaScript页面





        NewsDetail.DataBean data = newsDetail.getData();
        newsBodyTitle.setText(data.getTitle());
        //System.out.println(data.getTitle());
        newsBodyTimeSource.setText(data.getSource()+" "+data.getTime());
        //System.out.println(data.getSource());
        //System.out.println(data.getTime());
        newsBodyDetails.setText(data.getContent());
        //System.out.println(data.getContent());
        setSupportActionBar(ltoolBar);
        toolbar.setTitle("DailyNews");
        setSupportActionBar(toolbar);
        ltoolBar.inflateMenu(R.menu.tool_webbootom);
        //ltoolBar.setTitle("感谢观看");
        ltoolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.news_share:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_SUBJECT,url);
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
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_webview,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.news_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(WebActivity.this,query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent returnIntent = new Intent();
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


package com.example.dailynews.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailynews.MyNewsAdapter;
import com.example.dailynews.NewsListAdapter;
import com.example.dailynews.R;
import com.example.dailynews.json.MyNewsBean;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    private ListView newsListView;
    //private List<Fruit> fruitList = ;  //创建集合保存水果信息
    private List<MyNewsBean.DataBean> list=new ArrayList<>();
    private String keyWord;
    private Toolbar toolbar;
    private NewsListAdapter adapter;
    private SmartRefreshLayout smartRefreshLayout;
    private int curPage=0;
    @SuppressLint("HandlerLeak")
    private Handler newsHandler = new Handler(){
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void handleMessage(Message msg) {
            ((MyNewsBean) msg.obj).getData().forEach(dataBean -> {
                if(dataBean.getTitle().contains(keyWord)){
                    list.add(dataBean);
                }
            });
            Parcelable onSave=newsListView.onSaveInstanceState();
            adapter = new NewsListAdapter(SearchResultActivity.this,list);
            newsListView.setAdapter((ListAdapter) adapter);
            adapter.notifyDataSetChanged();
            newsListView.onRestoreInstanceState(onSave);
            newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    MyNewsBean.DataBean dataBean=list.get(position);
                    new Thread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void run() {
                            MyNewsBean.DataBean dataBean=list.get(position);
                            if(MainActivity.newsRepository.getNewsByNewsID(dataBean.get_id())==null){
                                MainActivity.newsRepository.insertDataBean(dataBean);
                            }
                        }
                    }).start();
                    TextView tv_title = (TextView) view.findViewById(R.id.title);
                    TextView tv_source= (TextView)view.findViewById(R.id.source);
                    TextView tv_time= (TextView)view.findViewById(R.id.time);
                    tv_title.setTextColor(Color.GRAY);
                    tv_source.setTextColor(Color.GRAY);
                    tv_time.setTextColor(Color.GRAY);
                    String title = dataBean.getTitle();
                    String source = dataBean.getSource();
                    String time =dataBean.getTime();
                    String content = dataBean.getContent();
                    Intent intent = new Intent(SearchResultActivity.this, WebActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("source",source);
                    intent.putExtra("time",time);
                    intent.putExtra("content",content);
                    startActivity(intent);
                }  //点击每一行的点击事件

            });

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);
        smartRefreshLayout=(SmartRefreshLayout)findViewById(R.id.smartRefreshLayout_result);
        Intent intent=getIntent();
        keyWord=intent.getStringExtra("keyWord");
        toolbar=(Toolbar)findViewById(R.id.result_toolbar);
        toolbar.setTitle(keyWord+"的搜索结果");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left);
        }
        newsListView = (ListView) findViewById(R.id.result_news);   //获得子布局
        smartRefreshLayout.setEnableRefresh(false);//是否启用下拉刷新功能
        //下滑加载更多
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                curPage+=5;
                getData("news");
                //加载完之后结束加载
                smartRefreshLayout.finishLoadMore();
                //当数据全部加载完成之后不可以再继续加载数据
                if (curPage>500){
                    smartRefreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
        getData("news");
        System.out.println("dataGot"+list.size());
        //System.out.println();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_result_menu, menu);
        return true;
    }
    private void getData(final String data){
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getDataFromNet(data, curPage++);
                }
            }).start();
            //if(list.size()>20)break;
        }
        System.out.println("finisherddddddddddddddddddd");
    }
    private void getDataFromNet(final String data,int page){
        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                System.out.println("page:"+page);
                String path= "https://covid-dashboard.aminer.cn/api/events/list?type="+data+"&page="+page+"&size=100";
                URL url = null;
                try {
                    url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(10000);
                    connection.setConnectTimeout(10000);
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = connection.getInputStream();
                        String json = streamToString(inputStream,"utf-8");
                        System.out.println("hhhhhhhjson:"+json.length()+" "+json.substring(1,1000));
                        return json;
                    } else {
                        System.out.println(responseCode);
                        return "已达到今日访问次数上限";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
            }
            protected void onPostExecute(final String result){
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        MyNewsBean myNewsBean = new Gson().fromJson(result,MyNewsBean.class);
                        Message msg=newsHandler.obtainMessage();
                        msg.obj = myNewsBean;
                        newsHandler.sendMessage(msg);
                    }
                }).start();
            }
            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }
        };
        task.execute();
    }

    private String streamToString(InputStream inputStream, String charset){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charset);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = null;
            StringBuilder builder = new StringBuilder();
            while ((s = bufferedReader.readLine()) != null){
                builder.append(s);
            }
            bufferedReader.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent returnIntent = new Intent();
                Toast.makeText(this,"返回",Toast.LENGTH_SHORT).show();
                SearchResultActivity.this.finish();
                break;
            default:
                break;
        }
        return true;
    }
}

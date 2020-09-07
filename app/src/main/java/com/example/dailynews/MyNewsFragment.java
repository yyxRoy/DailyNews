package com.example.dailynews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dailynews.json.MyNewsBean;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class MyNewsFragment extends Fragment {
    private FloatingActionButton fab;
    private ListView listView;
    //private SwipeRefreshLayout swipeRefreshLayout;
    private SmartRefreshLayout smartRefreshLayout;
    private List<MyNewsBean.DataBean> list;
    private int curPage=1;
    private static final int UPNEWS_INSERT = 0;
    @SuppressLint("HandlerLeak")
    private Handler newsHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String uniquekey,title,date, category,author_name,url,thumbnail_pic_s,thumbnail_pic_s02,thumbnail_pic_s03;
            switch (msg.what){
                case UPNEWS_INSERT:
                    if(list==null){
                        list=((MyNewsBean) msg.obj).getData();
                    }else{
                        list.addAll(((MyNewsBean) msg.obj).getData());
                    }
                    Parcelable onSave=listView.onSaveInstanceState();
                    NewsListAdapter adapter = new NewsListAdapter(getActivity(),list);
                    listView.setAdapter((ListAdapter) adapter);
                    listView.onRestoreInstanceState(onSave);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smartRefreshLayout);
        return view;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onAttach(getActivity());
        //获取传递的值
        Bundle bundle = getArguments();
        final String data = bundle.getString("name","news");
        //置顶功能
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.smoothScrollToPosition(0);
            }
        });
        //下拉刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 下一步实现从数据库中读取数据刷新到listview适配器中
                        getDataFromNet(data,curPage);
                        smartRefreshLayout.finishRefresh();
                    }
                },1000);
            }
        });
        //下滑加载更多
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getDataFromNet(data,++curPage);
                //加载完之后结束加载
                smartRefreshLayout.finishLoadMore();
                //当数据全部加载完成之后不可以再继续加载数据
                if (curPage>100){
                    smartRefreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
        //异步加载数据
        getDataFromNet(data,curPage);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取点击条目的路径，传值显示webview页面
                String title = list.get(position).getTitle();
                String source = list.get(position).getSource();
                String time =list.get(position).getTime();
                String content = list.get(position).getContent();
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("source",source);
                intent.putExtra("time",time);
                intent.putExtra("content",content);
                startActivity(intent);

            }
        });
    }
    private void getDataFromNet(final String data,int page){
        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String path= "https://covid-dashboard.aminer.cn/api/events/list?type="+data+"&page="+page+"&size=7";
                URL url = null;
                try {
                    url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);

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

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
            }
            protected void onPostExecute(final String result){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MyNewsBean myNewsBean = new Gson().fromJson(result,MyNewsBean.class);
                        //MyNewsBean.DataBean dataBeanList[]=myNewsBean.getData().toArray(new MyNewsBean.DataBean[0]);
                        //System.out.println("here"+dataBeanList.length);
                        //System.out.println(myNewsBean.getData().get(0).get_id());
                        //MainActivity.newsRepository.insertDataBean(myNewsBean.getData().toArray(new MyNewsBean.DataBean[0]));
                        List<MyNewsBean.DataBean> dataBeanList=MainActivity.newsRepository.getAllDataBean();
                        System.out.println(dataBeanList.size());
                        for(int i=0;i<dataBeanList.size();i++){
                            System.out.println(dataBeanList.get(i).getContent());
                        }
                        //System.out.println(myNewsBean.getError_code());
                        //if ("10012".equals(""+myNewsBean.getError_code())){
                            //下一篇将要实现从数据库加载数据
                        //}
                        Message msg=newsHandler.obtainMessage();
                        msg.what=UPNEWS_INSERT;
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

}

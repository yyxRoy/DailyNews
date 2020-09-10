package com.example.dailynews;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dailynews.Activity.MainActivity;
import com.example.dailynews.json.MyNewsBean;

import java.util.List;

public class NewsListAdapter extends BaseAdapter {
    private List<MyNewsBean.DataBean> list;
    private Context context;

    public NewsListAdapter(Context context, List<MyNewsBean.DataBean> list){
        this.context = context;
        this.list = list;
        System.out.println("lsitsizzzee+"+list.size());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView =View.inflate(context, R.layout.news_list_item,null);
            holder =new ViewHolder();
            //查找控件
            holder.source = (TextView) convertView.findViewById(R.id.source);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //获取数据重新赋值
        MyNewsBean.DataBean dataBean=list.get(position);
        holder.title.setText(dataBean.getTitle());
        holder.source.setText(dataBean.getSource());
        holder.time.setText(dataBean.getTime());
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(MainActivity.newsRepository.getNewsByNewsID(dataBean.get_id())!=null){
                    holder.title.setTextColor(Color.GRAY);
                    holder.source.setTextColor(Color.GRAY);
                    holder.time.setTextColor(Color.GRAY);
                }else{
                    holder.title.setTextColor(Color.BLACK);
                    holder.source.setTextColor(Color.BLACK);
                    holder.time.setTextColor(Color.BLACK);
                }
            }
        }).start();

        return convertView;
    }

    public void notifyDataSetChanged() {
    }

    static  class  ViewHolder{
        TextView title,source,time;
    }
}

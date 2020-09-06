package com.example.dailynews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dailynews.json.MyNewsBean;

import java.util.List;

public class NewsListAdapter extends BaseAdapter {
    private List<MyNewsBean.DataBean> list;
    private Context context;

    public NewsListAdapter(Context context, List<MyNewsBean.DataBean> list){
        this.context = context;
        this.list = list;
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
            holder.title.setText(list.get(position).getTitle());
            holder.source.setText(list.get(position).getSource());
            holder.time.setText(list.get(position).getTime());
        return convertView;
    }

    public void notifyDataSetChanged() {
    }

    static  class  ViewHolder{
        TextView title,source,time;
    }
}

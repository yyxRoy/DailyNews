package com.example.dailynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dailynews.json.TagBean;

import java.util.Collections;
import java.util.List;

interface TouchInterface {

    void onMove(int currentPosition, int targetPosition);
}
public class TagListAdapter extends RecyclerView.Adapter<MyViewHolder> implements TouchInterface {

    private Context context;
    //是否显示delete
    public boolean isShow;
    public List<TagBean> getList() {
        return list;
    }
    public OnItemClickListener itemClickListener;
    public void setList(List<TagBean> list) {
        this.list = list;
    }

    private List<TagBean> list;
    public TagListAdapter(Context context, List<TagBean> list) {
        this.context = context;
        this.list = list;
    }
    //点击事件接口
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    //设置点击事件的方法
    public void setItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false));
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_des.setText(list.get(position).type);
        holder.tv_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener!=null){
                    itemClickListener.onItemClick(position);
                }
            }
        });

        holder.tv_des.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                isShow = true;
                notifyDataSetChanged();
                return true;
            }
        });

        if (isShow) {
            holder.iv_icon.setVisibility(View.VISIBLE);
        } else {
            holder.iv_icon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onMove(int currentPosition, int targetPosition) {

        Collections.swap(list, currentPosition, targetPosition);
        if (targetPosition < currentPosition) {
            List<TagBean> subList = list.subList(targetPosition + 1, currentPosition + 1);
            //向右移一位
            rightStepList(0, subList);
        } else {
            List<TagBean> subList = list.subList(currentPosition, targetPosition);
            //向左移一位
            leftStepList(0, subList);
        }
        notifyItemMoved(currentPosition, targetPosition);
    }
    public static void reverseList(int start,int end,List list){

        int count = (end+1-start)/2 ;
        for(int i = 0;i< count;i++){
            Object temp = list.get(start+i);
            list.set(start+i,list.get(end-i));
            list.set(end-i,temp);
        }
    }
    public static void leftStepList(int step,List list){

        int size = list.size() -1;
        //左移
        reverseList(0,step,list);
        reverseList(step+1,size,list);
        reverseList(0,size,list);

    }

    public static void rightStepList(int step,List list){

        int size = list.size() -1;
        //右移
        reverseList(size-step,size,list);
        reverseList(0,size-step-1,list);
        reverseList(0,size,list);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView iv_icon;
    public TextView tv_des;

    public MyViewHolder(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tv_des = (TextView) itemView.findViewById(R.id.tv_des);
    }
}





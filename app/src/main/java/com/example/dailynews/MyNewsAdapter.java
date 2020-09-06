package com.example.dailynews;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MyNewsAdapter extends FragmentStatePagerAdapter {
    private List<String>tags;
    private FragmentManager fragmentManager;
    private List<TagBean> list;

    public MyNewsAdapter( FragmentManager fm,List<TagBean>list) {
        super(fm);
        this.fragmentManager=fm;
        this.tags=new ArrayList<>();
        this.list=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        MyNewsFragment myNewsFragment = new MyNewsFragment();
        //判断所选的标题，进行传值显示
        Bundle bundle = new Bundle();
        if (list.get(position).type.equals("news")){
            bundle.putString("name","news");
        }else if (list.get(position).type.equals("paper")){
            bundle.putString("name","paper");
        }else if (list.get(position).type.equals("all")){
            bundle.putString("name","all");
        }else if (list.get(position).type.equals("points")){
            bundle.putString("name","points");
        }else if (list.get(position).type.equals("event")){
            bundle.putString("name","event");
        }
        myNewsFragment.setArguments(bundle);
        return myNewsFragment;
    }

    @Override
    public int getCount() {
        //notifyDataSetChanged();
        System.out.println("szzzz: "+list.size());
        return list.size();
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        MyNewsFragment myNewsFragment = (MyNewsFragment)  super.instantiateItem(container, position);
        return myNewsFragment;
    }
    @Override
    public int getItemPosition(@NonNull Object object) {
        return FragmentStatePagerAdapter.POSITION_NONE;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).type;
    }

    private String makeFragmentName(int viewId,long id){
        return "android:switcher:"+viewId+":"+id;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        tags.add(makeFragmentName(container.getId(),getItemId(position)));
        Fragment fragment=(Fragment) super.instantiateItem(container,position);
        this.fragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    private long getItemId(int position) {
        return position;
    }

    public void setNewFragments(){
        if(this.tags!=null){
            System.out.println("tags "+tags);
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            for(int i=0;i<tags.size();i++){
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(tags.get(i)));
            }
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
            tags.clear();
        }
        notifyDataSetChanged();
    }
}

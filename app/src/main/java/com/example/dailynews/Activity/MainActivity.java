package com.example.dailynews.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dailynews.BottomItem;
import com.example.dailynews.BottomMenuView;
import com.example.dailynews.MyNewsAdapter;
import com.example.dailynews.NewsDB;
import com.example.dailynews.NewsRepository;
import com.example.dailynews.R;
import com.example.dailynews.json.MyNewsBean;
import com.example.dailynews.json.TagBean;
import com.example.dailynews.TagManager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
//import scut.carson_ho.searchview.SearchView;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private MyNewsAdapter myNewsAdapter;
    private ViewPager viewPager;
    private BottomMenuView bottomMenuViewList;
    private ImageView iv_add;
    public static NewsRepository newsRepository;
    public static NewsDB newsDB;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        mDrawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_design);
        View v=navigationView.getHeaderView(0);
        CircleImageView circleImageView=v.findViewById(R.id.icon_image);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        iv_add=findViewById(R.id.iv_add);
        bottomMenuViewList=(BottomMenuView)findViewById(R.id.bmv_list);

        //设置bottom数据
        bottomMenuViewList.setBottomItem(getData());
        //监听点击事件
        bottomMenuViewList.setBottomItemOnClickListener(new BottomMenuView.BottomItemOnClickListener() {
            @Override
            public void bottomItemOnClick(View view, int i, BottomItem item) {
                Toast.makeText(getApplicationContext(),"点击了第"+i+"个",Toast.LENGTH_SHORT).show();
            }
        });
        //默认选择第几个
        bottomMenuViewList.setShowIndex(0);
        System.out.println("CREATING AGAIN!!!!!!!!!!!!!!!!!!!!!!!!");
        if(TagManager.myCategoryList.size()==0){
            TagBean bean1 = new TagBean("news", 0);
            TagBean bean2 = new TagBean("paper", 1);
            TagBean bean3 = new TagBean("all", 2);
            TagBean bean4 = new TagBean("points", 3);
            TagBean bean5 = new TagBean("event", 4);
            TagManager.myCategoryList.add(bean1);
            TagManager.myCategoryList.add(bean2);
            TagManager.myCategoryList.add(bean3);
            TagManager.myCategoryList.add(bean4);
            TagManager.myCategoryList.add(bean5);
        }
        newsDB=NewsDB.getAppDB(this,"localnews");
        newsRepository=new NewsRepository(newsDB);
    }
    /**
     * 创建bottom数据
     * @return
     */
    public List<BottomItem> getData(){
        List<BottomItem> items = new ArrayList<>();
        items.add(new BottomItem("新闻",R.mipmap.icon_function_tab));
        items.add(new BottomItem("数据",R.mipmap.icon_home_tab));
        items.add(new BottomItem("图谱",R.mipmap.icon_my_tab));
        items.add(new BottomItem("聚类",R.mipmap.icon_home_tab));
        items.add(new BottomItem("学者",R.mipmap.icon_my_tab));
        return items;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onStart(){
        super.onStart();
        toolbar.setTitle("知疫");
        setSupportActionBar(toolbar);

        /*new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                newsRepository.clearDataBeans();
            }
        }).start();*/
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        }
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ChannelActivity.class);
                startActivityForResult(intent,0);
            }
        });
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.nav_call:
                        break;
                    case R.id.nav_friends:
                        Toast.makeText(MainActivity.this, "你点击了好友", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_location:
                        Toast.makeText(MainActivity.this, "你点击了发布新闻，下步实现", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_favorite:
                        Toast.makeText(MainActivity.this, "你点击了个人收藏，下步实现", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity.this,"需要做出登出功能，可扩展夜间模式，离线模式等,检查更新",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_exit:

                        break;
                    default:
                }
                return true;
            }
        });
        /* viewPager.setOffscreenPageLimit(1);*/
        myNewsAdapter=new MyNewsAdapter(getSupportFragmentManager(),TagManager.myCategoryList);
        viewPager.setAdapter(myNewsAdapter);
        //TabLayout要与ViewPAger关联显示
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        toolbar.inflateMenu(R.menu.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    //R.id.home修改导航按钮的点击事件为打开侧滑栏
                    case android.R.id.home:
                        mDrawerLayout.openDrawer(GravityCompat.START);  //打开侧滑栏
                        break;
                    case R.id.userFeedback:
                        final EditText ed =new EditText(MainActivity.this);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("用户反馈");
                        dialog.setView(ed);
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //添加点击事件
                            }
                        });
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                        break;
                    case R.id.iv_search:
                        Intent intent=new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.userExit:
                        Toast.makeText(MainActivity.this,"ni click 退出",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
                return true;
            }
        });
         return true;
     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0: //返回的结果是来自于Activity B
                if (resultCode == Activity.RESULT_OK) {
                    //tt.setText(data.getStringExtra("respond"));
                    System.out.println("hhhhhhhhhhfuck");
                    myNewsAdapter.setNewFragments();
                    myNewsAdapter.notifyDataSetChanged();
                } else {
                    //tt.setText("What?Nobody?");
                }
                break;
            default:
                break;
        }
    }
}

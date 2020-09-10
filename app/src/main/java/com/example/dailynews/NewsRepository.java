package com.example.dailynews;

import android.os.AsyncTask;

import com.example.dailynews.json.MyNewsBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NewsRepository {
    private NewsDao newsDao;
    private NewsDB newsDB;
    public NewsRepository(NewsDB newsDB){
        this.newsDB = newsDB;
        this.newsDao = this.newsDB.newsDao();
    }
    /**
     * insert news to database
     * */
    public void insertDataBean(MyNewsBean.DataBean dataBean){
        //System.out.println("testtts");
        //if(getNewsByNewsID(dataBean))
        newsDao.insertDataBean(dataBean);
        //InsertNewsTask insertNewsTask = new InsertNewsTask();
        //insertNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,dataBean);
    }
    /********/

    /**
     *get all news from database
     */
    public List<MyNewsBean.DataBean> getAllDataBean(){
        try {
            GetAllNewsTask getAllNewsTask = new GetAllNewsTask();
            return getAllNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,0).get();
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    private class GetAllNewsTask extends AsyncTask<Integer, Void, List<MyNewsBean.DataBean>> {

        @Override
        protected List<MyNewsBean.DataBean> doInBackground(Integer... params){
            return newsDao.getAllDataBean();
        }
    }


    /**
     * delete news
     * */
    public void deleteDataBean(MyNewsBean.DataBean dataBean){
        newsDao.deleteDataBean(dataBean);

    }
    /****/

    /**
     * delte news by _Id
     * */
    public void deleteNewsBy_Id(String _id){
        newsDao.deleteNewsBy_id(_id);
    }

    /**
     * clear the table
     */
    public void clearDataBeans(){
        newsDao.clear();
    }


    /**
     * Update news
     * */
    public void updateNews(MyNewsBean.DataBean dataBean){
        newsDao.updateDataBean(dataBean);
    }

    /**
     *
     * */
    public MyNewsBean.DataBean getNewsByNewsID(String newsID){
        MyNewsBean.DataBean _news= newsDao.getDataBeanBy_id(newsID);
        if(_news==null ){
            return null;
        }
        return _news;
    }

    public List<MyNewsBean.DataBean> searchByKeyWord(String keyWord){
        return newsDao.searchByKeyWord(keyWord);
    }

}

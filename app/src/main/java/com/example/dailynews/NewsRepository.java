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
    NewsRepository(NewsDB newsDB){
        this.newsDB = newsDB;
        this.newsDao = this.newsDB.newsDao();
    }
    /**
     * insert news to database
     * */
    public void insertDataBean(MyNewsBean.DataBean... dataBean){
        //System.out.println("testtts");
        //if(getNewsByNewsID(dataBean))
        newsDao.insertDataBean(dataBean);
        //InsertNewsTask insertNewsTask = new InsertNewsTask();
        //insertNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,dataBean);
    }

    private class InsertNewsTask extends AsyncTask<MyNewsBean.DataBean, Void, Void>{

        @Override
        protected Void doInBackground(MyNewsBean.DataBean... dataBean){
            newsDao.insertDataBean(dataBean);
            return null;
        }
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
    public void deleteDataBean(MyNewsBean.DataBean... dataBean){
        DeleteNewsTask deleteNewsTask = new DeleteNewsTask();
        deleteNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,dataBean);

    }

    private class DeleteNewsTask extends AsyncTask<MyNewsBean.DataBean, Void, Void>{

        @Override
        protected Void doInBackground(MyNewsBean.DataBean... dataBean){
            newsDao.deleteDataBean(dataBean);
            return null;
        }
    }
    /****/

    /**
     * delte news by _Id
     * */
    public void deleteNewsBy_Id(String... _id){
        DeleteNewsByIdTask deleteNewsByEmailTask = new DeleteNewsByIdTask();
        deleteNewsByEmailTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,_id);
    }

    private class DeleteNewsByIdTask extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(String... _id){
            newsDao.deleteNewsBy_id(_id[0]);
            return null;
        }
    }

    /**
     * clear the table
     */
    public void clearDataBeans(){
        ClearNewsTask clearNewsTask = new ClearNewsTask();
        clearNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,0);
    }

    private class ClearNewsTask extends AsyncTask<Integer, Void, Void>{

        @Override
        protected Void doInBackground(Integer... params){
            newsDao.clear();
            return null;
        }
    }


    /**
     * Update news
     * */
    public void updateNews(MyNewsBean.DataBean... dataBean){
        UpdateNewsTask updateNewsTask = new UpdateNewsTask();
        updateNewsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,dataBean);
    }

    private class UpdateNewsTask extends AsyncTask<MyNewsBean.DataBean, Void, Void>{
        @Override
        protected Void doInBackground(MyNewsBean.DataBean...dataBean){
            newsDao.updateDataBean(dataBean);
            return null;
        }
    }

    /**
     *
     * */
    public MyNewsBean.DataBean getNewsByNewsID(String...newsID){
        try{
            GetNewsByNewsID getNewsByNewsID = new GetNewsByNewsID();
            MyNewsBean.DataBean _news = getNewsByNewsID.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,newsID).get();
            if(_news==null ){
                return null;
            }
            return _news;
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    private class GetNewsByNewsID extends AsyncTask<String, Void, MyNewsBean.DataBean>{
        @Override
        protected MyNewsBean.DataBean doInBackground(String...newsID){
            return newsDao.getDataBeanBy_id(newsID);
        }
    }

}

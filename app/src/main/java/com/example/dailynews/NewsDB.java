package com.example.dailynews;
import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dailynews.json.MyNewsBean;

import java.util.List;

@Dao    //Database access object
interface NewsDao {
    @Insert
    void  insertDataBean(MyNewsBean.DataBean... dataBean);
    @Update
    int updateDataBean(MyNewsBean.DataBean... dataBean);
    @Delete
    void deleteDataBean(MyNewsBean.DataBean...dataBean);

    @Query("SELECT * FROM dataBean")
    List<MyNewsBean.DataBean> getAllDataBean();

    @Query("SELECT * FROM dataBean WHERE _id = :id")
    MyNewsBean.DataBean getDataBeanBy_id(String... id);

    @Query("DELETE FROM dataBean")
    void clear();
    @Query("DELETE FROM dataBean WHERE _id in (:id1)")
    void deleteNewsBy_id(String... id1);

}
@Database(entities = {MyNewsBean.DataBean.class},version = 2)
public abstract class NewsDB extends RoomDatabase {
    public abstract NewsDao newsDao();
    public static NewsDB getAppDB(Context context, String name){
        return  Room.databaseBuilder(context.getApplicationContext(), NewsDB.class,
                name).fallbackToDestructiveMigration().build();
    }
    static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 为旧表添加新的字段
            database.execSQL("ALTER TABLE dataBean "
                    + " ADD COLUMN  sex INTEGER NOT NULL DEFAULT 0");
        }
    };
}
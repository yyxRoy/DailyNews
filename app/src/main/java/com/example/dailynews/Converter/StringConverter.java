package com.example.dailynews.Converter;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StringConverter {
    @TypeConverter
    public String listToString(List<String> list){
        StringBuffer sb = new StringBuffer();
        for(String string:list){
            sb.append(string);
            sb.append(',');
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
    @TypeConverter
    public List<String> stringToList(String string){
        return Arrays.asList(string.split(","));
    }
}

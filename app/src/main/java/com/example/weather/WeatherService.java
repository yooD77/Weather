package com.example.weather;
import android.util.Xml;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class WeatherService {
    //解析json文件返回天气信息的集合
    public static List<WeatherInfo> getInfosFromJson(InputStream is)
            throws IOException {
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        String json = new String(buffer, "utf-8");
        //使用gson库解析JSON数据
        Gson gson = new Gson();
        Type listType = new TypeToken<List<WeatherInfo>>() { }.getType();
        List<WeatherInfo> weatherInfos = gson.fromJson(json, listType);
        return weatherInfos;
    }

}

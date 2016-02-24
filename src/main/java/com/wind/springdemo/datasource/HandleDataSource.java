package com.wind.springdemo.datasource;

/**
 * Created by pc on 2016/2/23.
 */
public class HandleDataSource {
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();
    public static void putDataSource(String datasource) {
        holder.set(datasource);
    }

    public static String getDataSource() {
        return holder.get();
    }
}

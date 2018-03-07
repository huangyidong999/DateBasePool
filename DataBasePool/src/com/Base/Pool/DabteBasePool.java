package com.Base.Pool;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lucifer on 2018/3/8.
 */
public class DabteBasePool {

    private Properties prop = new Properties();
    //设置最大连接数
    private int maxConnection;
    //设置最大缓冲数
    private int maxCashConnection;
    //缓存空间
    private ConcurrentHashMap<Thread,Connection> map = new ConcurrentHashMap<Thread,Connection>();
    //数据库各项数据
    private String userName;
    private String passWord;
    private String url;
    private String DriverName;
    //使用双重检查的单例模式
    private static volatile DabteBasePool dabteBasePool;

    private DabteBasePool() {}

    public static DabteBasePool getInstance() {
        if (dabteBasePool == null) {
            synchronized (DabteBasePool.class) {
                if (dabteBasePool == null) {
                    dabteBasePool = new DabteBasePool();
                }
            }
        }
        return dabteBasePool;
    }

    public void loadDB(){
        try {
            FileInputStream in = new FileInputStream("E:\\Cindy\\DataBasePool\\src\\db.properties");
            prop.load(in);
            userName = prop.getProperty("jdbc.userName");
            passWord = prop.getProperty("jdbc.password");
            url = prop.getProperty("jdbc.url");
            DriverName = prop.getProperty("jdbc.driverNAME");

        }catch (Exception e){

        }

    }

    public Connection getConnection(Thread thread) {
        try {
            Class.forName(DriverName);
            Connection conn = DriverManager.getConnection(url);
            if(map.size() < maxCashConnection){
                map.put(thread.currentThread(),conn);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过内部类定时器自我调度来完成定时清理
     */
    public class Remove extends TimerTask{
        @Override
        public void run() {
            map.clear();//调用hashmap的清空方法
            new Timer().schedule(new Remove(),10000*600,10000*60);
        }
    }

    public int getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    public int getMaxCashConnection() {
        return maxCashConnection;
    }

    public void setMaxCashConnection(int maxCashConnection) {
        this.maxCashConnection = maxCashConnection;
    }

    public ConcurrentHashMap<Thread, Connection> getMap() {
        return map;
    }
}

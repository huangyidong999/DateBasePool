package com.Base.User;

import com.Base.Agent.MidAgent;

import java.sql.Connection;

/**
 * Created by Lucifer on 2018/3/8.
 */
public class User implements Runnable{

    private  String userName;
    private  String url;
    private  String passWord;
    private  Connection connection;
    private MidAgent midAgent;
    public User(){ };
    public User(MidAgent midAgent){
        this.midAgent = midAgent;
    }
    @Override
    public void run() {
        connection = midAgent.getConnection(Thread.currentThread());
    }

    /**
     * 将Connection置空，帮助虚拟机GC
     */
    public void remove(){
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection = null;
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}

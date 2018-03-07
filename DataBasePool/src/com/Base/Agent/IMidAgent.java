package com.Base.Agent;

import com.Base.Pool.DabteBasePool;

import java.sql.Connection;

/**
 * Created by Lucifer on 2018/3/8.
 */
public interface IMidAgent {
    /**
     * 通过user的线程对象来获取连接
     * @param thread
     * @return
     */
    public Connection getConnection(Thread thread);

    /**
     * 根据pool设置的最大线程大小来设置阻塞队列的大小
     * @param
     */
    public void Init();

}

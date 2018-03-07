package com.Base.Agent;

import com.Base.Pool.DabteBasePool;
import com.Base.User.User;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Lucifer on 2018/3/8.
 */
public class MidAgent implements IMidAgent {
    private int max ;
    //pool引用
    private  DabteBasePool dabteBasePool;
    //阻塞队列
    private ArrayBlockingQueue<Thread> Que =new ArrayBlockingQueue<Thread>(max);
    // 涉及缓存的读写锁
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 不涉及缓存的正常锁
    Lock lock = new ReentrantLock();

    public  MidAgent(DabteBasePool dabteBasePool){
        this.dabteBasePool = dabteBasePool;
    }

    @Override
    public Connection getConnection(Thread thread) {
        Connection conn = null;
        rwl.readLock().lock();
        if(dabteBasePool.getMap().containsKey(thread))
        {
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            conn = dabteBasePool.getConnection(thread);
            rwl.writeLock().unlock();
            rwl.readLock().lock();
        }
        if(conn != null){ rwl.readLock().unlock(); return  conn; }

        conn = dabteBasePool.getMap().get(thread);
        rwl.readLock().unlock();
        remove();
        return conn;
    }

    @Override
    public void Init() {
        max = dabteBasePool.getMaxConnection();
    }

    /**
     * 运用阻塞队列的put方法，一旦放满就会阻塞
     * @param thread
     */
    public void add(Thread thread){

        try {
            lock.lock();
            Que.put(thread);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void  remove(){
        try {
            lock.lock();
            Que.take();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

package com.Base;

import com.Base.Agent.MidAgent;
import com.Base.Pool.DabteBasePool;
import com.Base.User.User;
import com.Base.User.UserFactory;

/**
 * Created by Lucifer on 2018/3/8.
 */
public class Test {
    /**
     * 测试前请自己修改配置文件
     * @param args
     */
    public static void main(String[] args) {

        MidAgent midAgent = new MidAgent(DabteBasePool.getInstance());
        UserFactory a = new UserFactory();
        User user = a.getUser("a","b","c",midAgent);
        Thread thread = new Thread(user);
        thread.start();
        //已经获取了Connection，假设使用完毕
        user.remove();
    }
}

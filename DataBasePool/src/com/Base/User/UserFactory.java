package com.Base.User;

import com.Base.Agent.MidAgent;

/**
 * Created by Lucifer on 2018/3/8.
 */
public class UserFactory {

    public User getUser(String a, String b, String c, MidAgent midAgent){
        User user = new User(midAgent);
        user.setUserName(a);
        user.setPassWord(b);
        user.setUrl(c);
        return user;
    }

}

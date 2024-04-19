package com.cc.ccrpcprovider.demos.web;

import com.cc.ccrpccore.demos.annotion.RpcProvider;
import com.cc.ccrpcdemoapi.demos.web.User;
import com.cc.ccrpcdemoapi.demos.web.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public com.cc.ccrpcdemoapi.demos.web.User getUser(Integer age) {
        return new User("cc_"+System.currentTimeMillis(),age);
    }
}

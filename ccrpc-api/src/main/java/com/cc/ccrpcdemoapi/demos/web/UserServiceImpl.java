package com.cc.ccrpcdemoapi.demos.web;

public class UserServiceImpl implements UserService{
    @Override
    public User getUser(Integer age) {
        return new User("cc_"+System.currentTimeMillis(),age);
    }
}

package com.cc.ccrpcdemoapi.demos.web;

import com.cc.ccrpccore.demos.annotion.RpcProvider;

@RpcProvider
public interface UserService {

    User getUser(Integer age);
}

package com.cc.ccrpcprovider;

import com.cc.ccrpccore.demos.annotion.RpcProvider;
import com.cc.ccrpccore.demos.api.RpcRequest;
import com.cc.ccrpccore.demos.api.RpcResponse;
import com.cc.ccrpccore.demos.provider.ProviderBootStarp;
import com.cc.ccrpcprovider.demos.config.BootStrapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Import(BootStrapConfig.class )
public class CcRpcProviderApplication {

    @Resource
    private ProviderBootStarp providerBootStarp;

    @Resource
    private ApplicationContext applicationContext;




    public static void main(String[] args) {
        SpringApplication.run(CcRpcProviderApplication.class, args);
    }

    /**
     *
     * @param rpcRequest rpc请求参数
     * @return RpcResponse rpc响应
     */

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public RpcResponse invoke(@RequestBody RpcRequest rpcRequest){
        return providerBootStarp.invokeMethod(rpcRequest);




    }



}

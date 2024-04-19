package com.cc.ccrpcprovider;

import com.cc.ccrpccore.demos.annotion.RpcProvider;
import com.cc.ccrpccore.demos.api.RpcRequest;
import com.cc.ccrpccore.demos.api.RpcResponse;
import com.cc.ccrpccore.demos.provider.ProviderBootStarp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
@RestController
public class CcrpcProviderApplication {

    @Resource
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(CcrpcProviderApplication.class, args);
    }

    /**
     *
     * @param rpcRequest rpc请求参数
     * @return RpcResponse rpc响应
     */

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public RpcResponse invoke(@RequestBody RpcRequest rpcRequest){
        return invokeMethod(rpcRequest);



    }

    private RpcResponse invokeMethod(RpcRequest rpcRequest) {
        String serviceName = rpcRequest.getServiceName();
        Object o = serviceMap.get(serviceName);
        Method[] methods = o.getClass().getMethods();
        Method method = getMethod(methods, rpcRequest.getMethodName());
        Object invoke = null;
        RpcResponse rpcResponse = new RpcResponse();
        try {
            invoke = method.invoke(o, rpcRequest.getArgs());

            rpcResponse.setData(invoke);
            rpcResponse.setStatus("success ");
        } catch (Exception e) {
            rpcResponse.setStatus("fail");
        }
        return rpcResponse;
    }


    public Method getMethod(Method[] methods,String methodName){
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }


    private Map<String, Object> serviceMap = new HashMap<>();

    @PostConstruct
    public void buildProvider(){
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcProvider.class);
        beansWithAnnotation.forEach((k,v)->{
            Class<?>[] interfaces = v.getClass().getInterfaces();
            for (Class<?> anInterface : interfaces) {
                serviceMap.put(anInterface.getName(),v);
            }



        });





    }




}

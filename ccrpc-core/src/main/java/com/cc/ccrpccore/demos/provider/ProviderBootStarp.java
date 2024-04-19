package com.cc.ccrpccore.demos.provider;

import com.cc.ccrpccore.demos.annotion.RpcProvider;
import com.cc.ccrpccore.demos.api.RpcRequest;
import com.cc.ccrpccore.demos.api.RpcResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
 import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProviderBootStarp implements ApplicationContextAware {

    public ApplicationContext applicationContext;

    private static final Map<String, Object> SERVICE_MAP = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }

    public RpcResponse invokeMethod(RpcRequest rpcRequest) {
        String serviceName = rpcRequest.getServiceName();
        Object o = SERVICE_MAP.get(serviceName);
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



    @PostConstruct
    public void buildProvider(){
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcProvider.class);
        beansWithAnnotation.forEach((k,v)->{
            Class<?>[] interfaces = v.getClass().getInterfaces();
            for (Class<?> anInterface : interfaces) {
                SERVICE_MAP.put(anInterface.getName(),v);
            }
        });
    }




}

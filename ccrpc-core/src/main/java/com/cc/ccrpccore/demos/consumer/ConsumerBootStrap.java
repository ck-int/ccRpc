package com.cc.ccrpccore.demos.consumer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ConsumerBootStrap implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void screenConsumerServiceFields() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();


    }
}

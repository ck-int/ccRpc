package com.cc.ccrpccore.demos.conf;

import com.cc.ccrpccore.demos.consumer.ConsumerBootStrap;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    public ConsumerBootStrap consumerBootStarp(){
        return new ConsumerBootStrap();
    }

    public ApplicationRunner runScreenConsumerServiceFields (ConsumerBootStrap consumerBootStarp){
            return (x)->{
                consumerBootStarp.screenConsumerServiceFields();
            };
    }

}

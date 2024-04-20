package com.cc.ccrpccore.demos.conf;

import com.cc.ccrpccore.demos.provider.ProviderBootStarp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfig {


    @Bean
    public ProviderBootStarp providerBootStarp(){
        return new ProviderBootStarp();
    }
}

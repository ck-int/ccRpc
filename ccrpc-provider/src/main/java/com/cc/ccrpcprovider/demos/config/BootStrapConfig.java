package com.cc.ccrpcprovider.demos.config;

import com.cc.ccrpccore.demos.provider.ProviderBootStarp;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootStrapConfig {


    @Bean
    public ProviderBootStarp providerBootStarp(){
        return new ProviderBootStarp();
    }
}

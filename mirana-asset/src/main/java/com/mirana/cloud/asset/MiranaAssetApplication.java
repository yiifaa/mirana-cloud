package com.mirana.cloud.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@Import({ServiceConfigs.class, MvcConfigs.class})
public class MiranaAssetApplication extends SpringBootServletInitializer {
	
	/**
	 * 添加自身的配置信息
     * @param application
     * @return 
	 */
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        	return application.sources(MiranaAssetApplication.class);
	}

    public static void main(String[] args) {
    	SpringApplication.run(MiranaAssetApplication.class, args);
    }
    
}

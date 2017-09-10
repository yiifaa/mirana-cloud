package com.mirana.cloud.weak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@SpringBootApplication
@Import({ServiceConfigs.class, MvcConfigs.class})
public class MiranaWeakApplication extends SpringBootServletInitializer {
	
	/**
	 * 添加自身的配置信息
     * @param application
     * @return 
	 */
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        	return application.sources(MiranaWeakApplication.class);
	}

    public static void main(String[] args) {
    	SpringApplication.run(MiranaWeakApplication.class, args);
    }
    
}

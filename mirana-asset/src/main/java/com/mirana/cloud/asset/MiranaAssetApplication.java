package com.mirana.cloud.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class MiranaAssetApplication {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("ASSET", false);
	    return instance.getHomePageUrl();
	}

	@RequestMapping("/")
    public String home() {
        return "Hello world";
    }
	
	@RequestMapping("/info")
    public String info() {
        return this.serviceUrl();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MiranaAssetApplication.class).web(true).run(args);
    }
}

/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.asset;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author 甘焕
 *
 * 创建日期：2017年3月17日
 * version : 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "com.mirana.cloud.enreka",
			   includeFilters = {@Filter(Service.class), @Filter(Repository.class)}	
)
public class ServiceConfigs {

}

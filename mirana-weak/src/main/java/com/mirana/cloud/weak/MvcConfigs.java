/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.weak;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 甘焕
 *
 * 创建日期：2017年3月17日
 * version : 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "com.mirana.cloud.enreka",
	includeFilters = {@Filter(Controller.class), @Filter(RestController.class)}
)
public class MvcConfigs {

}

/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.weak.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
@RestController
public class IndexController {
	
	@RequestMapping("/info")
	public Map<String, Object> info() {
		ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
		builder.put("name", "WEAK");
		builder.put("port", 8082);
		return builder.build();
	}

}

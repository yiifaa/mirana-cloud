/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.asset.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.mirana.cloud.asset.Constants;

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
		builder.put("name", "ASSET");
		builder.put("port", 8081);
		return builder.build();
	}
	
	@RequestMapping("/")
	public Map<String, String> urls() {
		ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
		builder.put(Constants.ASSET_LIST, "/asset/list");
		return builder.build();
	}

}

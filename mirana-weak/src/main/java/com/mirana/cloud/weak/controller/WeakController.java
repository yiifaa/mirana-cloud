/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.weak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mirana.cloud.asset.service.WeakService;
import com.mirana.cloud.weak.domain.Asset;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
@RestController
@RequestMapping("/asset")
public class WeakController {
	
	private WeakService assetService;
	
	/**
	 * @param assetService
	 */
	@Autowired
	public WeakController(WeakService assetService) {
		super();
		this.assetService = assetService;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Asset> list() {
		return this.assetService.findAllAsset();
	}
	
}

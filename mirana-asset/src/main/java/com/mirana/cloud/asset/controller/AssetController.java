/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mirana.cloud.asset.domain.Asset;
import com.mirana.cloud.asset.service.AssetService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Completable;
import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
@RestController
@RequestMapping("/asset")
public class AssetController {
	
	private AssetService assetService;
	
	/**
	 * @param assetService
	 */
	@Autowired
	public AssetController(AssetService assetService) {
		super();
		this.assetService = assetService;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Asset> list() {
		return this.assetService.findAll();
	}
	
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public Asset detail(@PathVariable("id") Long id) {
		return this.assetService.findById(id);
	}
	
	@RequestMapping(value="/slow/{id}", method=RequestMethod.GET)
	public Asset findById(@PathVariable("id") Long id) {
		//	Completable asset = ;
		//	return asset.toObservable()		
		//return this.assetService.findById(id);
		return this.assetService.findByIds(id).toBlocking().single();
	}
}

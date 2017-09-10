/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.weak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mirana.cloud.asset.service.WeakService;
import com.mirana.cloud.weak.Constants;
import com.mirana.cloud.weak.domain.Asset;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
@Service
public class WeakServiceImpl implements WeakService {
	
	private EurekaClient discoveryClient;
	
	private RestTemplate restTemplate;
	
	/**
	 * @param discoveryClient
	 */
	@Autowired
	public WeakServiceImpl(EurekaClient discoveryClient) {
		super();
		this.discoveryClient = discoveryClient;
		this.restTemplate = new RestTemplate(); 
	}

	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("ASSET", false);
	    return instance.getHomePageUrl();
	}


	/* (non-Javadoc)
	 * @see com.mirana.cloud.asset.service.WeakService#findAllAsset()
	 */
	@Override
	public List<Asset> findAllAsset() {
		String url = this.serviceUrl() + Constants.ASSET_LIST;
		ResponseEntity<List<Asset>> results = this.restTemplate.exchange(url, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Asset>>() {});
		List<Asset> assets = results.getBody();
		return assets;
	}
	
	

}

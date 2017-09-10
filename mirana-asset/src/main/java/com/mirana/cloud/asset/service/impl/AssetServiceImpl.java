/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.asset.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.mirana.cloud.asset.domain.Asset;
import com.mirana.cloud.asset.service.AssetService;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
@Service
public class AssetServiceImpl implements AssetService {
	
	private final ImmutableMap<Long, Asset> assets;
	
	public AssetServiceImpl() {
		ImmutableMap.Builder<Long, Asset> builder = ImmutableMap.builder();
		//
		Asset a = new Asset();
		a.setId(1L);
		a.setName("路由器");
		Asset b = new Asset();
		b.setId(2L);
		b.setName("交换机");
		//
		builder.put(a.getId(), a);
		builder.put(b.getId(), b);
		assets = builder.build();
	}

	/* (non-Javadoc)
	 * @see com.mirana.cloud.asset.service.AssetService#findAll()
	 */
	@Override
	public List<Asset> findAll() {
		return assets.values().asList();
	}

	/* (non-Javadoc)
	 * @see com.mirana.cloud.asset.service.AssetService#findById(java.lang.Long)
	 */
	@Override
	public Asset findById(Long id) {
		return assets.get(id);
	}

}

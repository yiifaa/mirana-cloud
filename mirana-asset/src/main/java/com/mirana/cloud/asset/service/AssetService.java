/*
 * (c) Copyright 2017 STI技术小组
 * http://www.stixu.com
 */
package com.mirana.cloud.asset.service;

import java.util.List;

import com.mirana.cloud.asset.domain.Asset;

import rx.Observable;

/**
 * @author 甘焕
 *
 * 创建日期：2017年9月10日
 * version : 1.0.0
 */
public interface AssetService {
	
	public Observable<Asset> findByIds(final Long id);
	
	List<Asset> findAll();
	
	List<Asset> findAllDefault();
	
	Asset findById(Long id);

}

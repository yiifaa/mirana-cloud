package com.mirana.cloud.asset;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.mirana.cloud.asset.service.WeakService;
import com.mirana.cloud.weak.Constants;
import com.mirana.cloud.weak.domain.Asset;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiranaAssetApplicationTests {
	
	@Resource
	private WeakService assetService;
	
	@Resource
	private EurekaClient discoveryClient;
	
	private RestTemplate restTmpl;
	
	@Before
	public void before() {
		this.restTmpl = new RestTemplate(); 
	}
	
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("WEAK", false);
	    return instance.getHomePageUrl();
	}

	@Test
	public void contextLoads() {
		String url = this.serviceUrl() + Constants.ASSET_LIST;
		ResponseEntity<List<Asset>> results = this.restTmpl.exchange(url, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Asset>>() {});
		List<Asset> assets = results.getBody();
		assertThat(assets.size(), IsEqual.equalTo(2));
	}

}

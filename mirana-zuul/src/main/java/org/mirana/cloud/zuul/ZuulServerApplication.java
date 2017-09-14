package org.mirana.cloud.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * 
 * 
 * @author  <a href="mailto:ganhuanxp@163.com">甘焕</a>
 * @version  1.0
 * 开发日期：2017年9月14日 ： 上午10:41:02
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
	}
	
}

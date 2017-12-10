package com.ghx;

import com.ghx.domain.Result;
import com.ghx.domain.SysUser;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class GHXRestTest {
	
	String url = null;
	RestTemplate restTemplate = new RestTemplate();
	
	@Test //直接路由service
	public void testAdd(){
		url = "http://localhost:9002/api-provider-id/user/add";
		SysUser user = new SysUser();
		user.setUsername("routes service-999");
		user.setAddress("路由service");
		user.setAge((byte)10);
		user.setBirthday("2016-07-07");
		Result result = restTemplate.postForObject(url, user, Result.class);
		System.err.println(result);
	}
	
	@Test //路由service 查询
	public void testFind(){
		url = "http://localhost:9002/api-provider-id/user/find?id=1";
		 ResponseEntity<Result> result = restTemplate.getForEntity(url, Result.class);
		 System.err.println(result);
	}
	
	//=========================路由自己  admin=================================
	@Test
	public void testItselfAdd(){
		url = "http://localhost:9002/api-admin/add";
		SysUser user = new SysUser();
		user.setUsername("routes itself-1=999");
		user.setAddress("路由自己");
		user.setAge((byte)20);
		user.setBirthday("2016-10-10");
		Result result = restTemplate.postForObject(url, user, Result.class);
		System.err.println(result);
	}
	
	@Test
	public void testItselfFind(){
		url = "http://localhost:9002/api-admin/find?id=2";
		ResponseEntity<Result> result = restTemplate.getForEntity(url, Result.class);
		System.err.println(result);
	}
	
	//=====================调用feign--------声明式的webservice,并测试断路器
	//断路器 如果调取service 失败，那么会调用本身
	@Test
	public void testFeignAdd(){
		url = "http://localhost:9002/add";
		SysUser user = new SysUser();
		user.setUsername("feign test---8888");
		user.setAddress("feign");
		user.setAge((byte)20);
		user.setBirthday("2016-10-10");
		Result result = restTemplate.postForObject(url, user, Result.class);
		System.err.println(result);		
	}
	
	@Test
	public void testFeignFind(){
		url = "http://localhost:9002/find?id=3";
		ResponseEntity<Result> result = restTemplate.getForEntity(url, Result.class);
		System.err.println(result);
	}
	
	
}

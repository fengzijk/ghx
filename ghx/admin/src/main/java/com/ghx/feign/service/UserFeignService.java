package com.ghx.feign.service;

import com.ghx.domain.Result;
import com.ghx.domain.SysUser;
import com.ghx.feign.hystrix.UserFeignServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
*-------------------------------------------------
* @ClassName  : UserFeignService
* @Descprition : @FeignClient  value 对象的app.name，也就是所谓的serviceId，通过app.name可以实现负载均衡
 * fallback 调用服务端失败时的回调方法所使用的类
 * 在Feign直接定义调用REST的接口即可
 * [own-cloud-admin]-[com.learn.spring.cloud.admin.feign.service]-[UserFeignService]
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 14:44
*--------------------------------------------------
*/
@FeignClient(value="cloud-provider",fallback = UserFeignServiceHystrix.class)
public interface UserFeignService {
	
	@RequestMapping(value = "/user/add",method = RequestMethod.POST)
	public Result addUser(@RequestBody SysUser user);
	
	
	@RequestMapping(value = "/user/update",method = RequestMethod.POST)
	public Result updateUser(@RequestBody SysUser user);
	
	@RequestMapping(value = "/user/delete",method = RequestMethod.POST)
	public Result deleteUser(@RequestParam("id") Integer id);
	
	
	@RequestMapping(value = "/user/find",method = RequestMethod.GET)
	public Result findUserById(@RequestParam("id") Integer id);
	
	
	@RequestMapping(value = "/user/query",method = RequestMethod.GET)
	public Result queryUsers(@RequestParam("startTime") String startTime,
                             @RequestParam("endTime") String endTime,
                             @RequestParam("username") String username,
                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                             @RequestParam(name = "limit", defaultValue = "10") Integer limit);
	
	
	
}

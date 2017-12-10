package com.ghx.controller;

import com.ghx.domain.Result;
import com.ghx.domain.SysUser;
import com.ghx.feign.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*-------------------------------------------------
* @ClassName  : UserFeignController
* @Descprition :Feign是一个声明式的Web Service客户端，它使得编写Web Serivce客户端变得更加简单。我们只需要使用Feign来创建一个接口并用注解来配置它既可完成
 * [own-cloud-admin]-[com.learn.spring.cloud.admin.controller]-[UserFeignController]
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:40
*--------------------------------------------------
*/
@RestController
public class UserFeignController {

	@Autowired
	private UserFeignService userFeignService;
	
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result addUser(@RequestBody SysUser user){
		return userFeignService.addUser(user);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result updateUser(@RequestBody SysUser user){
		return userFeignService.updateUser(user);
	}
	
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public Result deleteUser(@RequestParam("id")Integer id){
		return userFeignService.deleteUser(id);
	}
	
	
	@RequestMapping(value = "/find",method = RequestMethod.GET)
	public Result findUserById(@RequestParam("id")Integer id){
		return userFeignService.findUserById(id);
	}
	
	
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	public Result queryUsers(@RequestParam("startTime")String startTime,
			@RequestParam("endTime")String endTime,
			@RequestParam("username")String username,
			@RequestParam(name = "pageNo",defaultValue="1") Integer pageNo,
			@RequestParam(name = "limit",defaultValue = "10") Integer limit){
		return userFeignService.queryUsers(startTime, endTime, username, pageNo, limit);
	}
	
}

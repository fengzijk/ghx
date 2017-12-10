package com.ghx.controller;

import com.ghx.domain.Pagination;
import com.ghx.domain.Result;
import com.ghx.domain.SysUser;
import com.ghx.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
/**
*-------------------------------------------------
* @ClassName  : SysUserController
* @Descprition : TODO
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time :
*--------------------------------------------------
*/
public class SysUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result addUser(@RequestBody SysUser user){
		Result result = new Result();
		try {
			userService.addUser(user);
			result.setRetCode(Result.RETCODE_SUCCESS);
		} catch (Exception e) {
			LOG.error("add user failed", e);
			result.setRetCode(Result.RETCODE_ERROR);
			result.setErrMsg("add user failed");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result updateUser(SysUser user){
		Result result = new Result();
		try {
			userService.updateUser(user);
			result.setRetCode(Result.RETCODE_SUCCESS);
		} catch (Exception e) {
			LOG.error("update user failed", e);
			result.setRetCode(Result.RETCODE_ERROR);
			result.setErrMsg("update user failed");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public Result deleteUser(Integer id){
		Result result = new Result();
		try {
			userService.deleteUser(id);
			result.setRetCode(Result.RETCODE_SUCCESS);
		} catch (Exception e) {
			LOG.error("delete user failed", e);
			result.setRetCode(Result.RETCODE_ERROR);
			result.setErrMsg("delete user failed");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/find",method = RequestMethod.GET)
	public Result findUserById(Integer id){
		Result result = new Result();
		try {
			SysUser user = userService.findUserById(id);
			result.setData(user);
			result.setRetCode(Result.RETCODE_SUCCESS);
		} catch (Exception e) {
			LOG.error("query user failed", e);
			result.setRetCode(Result.RETCODE_ERROR);
			result.setErrMsg("query user failed");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	public Result queryUsers(String startTime,String endTime,String username,
			@RequestParam(defaultValue="1") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer limit){
		Result result = new Result();
		try {
			Pagination pagination = userService.queryUsers(startTime,endTime,username,pageNo,limit);
			result.setData(pagination);
			result.setRetCode(Result.RETCODE_SUCCESS);
		} catch (Exception e) {
			LOG.error("query users failed", e);
			result.setRetCode(Result.RETCODE_ERROR);
			result.setErrMsg("query users failed");
			e.printStackTrace();
		}
		return result;
	}
	
}

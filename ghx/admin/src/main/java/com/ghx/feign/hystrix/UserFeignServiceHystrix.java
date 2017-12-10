package com.ghx.feign.hystrix;

import com.ghx.domain.Result;
import com.ghx.domain.SysUser;
import com.ghx.feign.service.UserFeignService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
*-------------------------------------------------
* @ClassName  : UserFeignServiceHystrix
* @Descprition : 在本类写失败后返回的逻辑处理
 * [own-cloud-admin]-[com.learn.spring.cloud.admin.feign.hystrix]-[UserFeignServiceHystrix]
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 14:44
*-------------------------------------------------- 
*/
@Component
public class UserFeignServiceHystrix implements UserFeignService {

	@Override
	public Result addUser(SysUser user) {
		//直接将参数进行原路返回
		Result result = new Result();
		result.setData(user);
		result.setRetCode(Result.RETCODE_ERROR);
		result.setErrMsg("调用新增服务API失败");
		return result;
	}

	@Override
	public Result updateUser(SysUser user) {
		Result result = new Result();
		result.setData(user);
		result.setRetCode(Result.RETCODE_ERROR);
		result.setErrMsg("调用更新服务API失败");
		return result;
	}

	@Override
	public Result deleteUser(Integer id) {
		Result result = new Result();
		result.setData(id);
		result.setRetCode(Result.RETCODE_ERROR);
		result.setErrMsg("调用删除服务API失败");
		return result;
	}

	@Override
	public Result findUserById(Integer id) {
		Result result = new Result();
		result.setData(id);
		result.setRetCode(Result.RETCODE_ERROR);
		result.setErrMsg("调用根据id检索服务API失败");
		return result;
	}

	@Override
	public Result queryUsers(String startTime, String endTime, String username, Integer pageNo, Integer limit) {
		Map<String,Object> paraMap = new HashMap<>();
		if(StringUtils.isNotBlank(startTime)){
			paraMap.put("startTime", startTime);
		}
		if(StringUtils.isNotBlank(endTime)){
			paraMap.put("endTime", endTime);
		}
		if(StringUtils.isNotBlank(username)){
			paraMap.put("username", username);
		}
		if(pageNo != null){
			paraMap.put("pageNo", pageNo);
		}
		if(limit != null){
			paraMap.put("limit", limit);
		}
		Result result = new Result();
		result.setData(paraMap);
		result.setRetCode(Result.RETCODE_ERROR);
		result.setErrMsg("调用根据条件查询服务API失败");
		return result;
	}

}

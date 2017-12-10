package com.ghx.service.impl;


import com.ghx.domain.Pagination;
import com.ghx.domain.SysUser;
import com.ghx.mapper.SysUserMapper;
import com.ghx.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
@Transactional(readOnly = true)
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserMapper userMapper;

	@Override
	@Transactional(readOnly = false)
	public void addUser(SysUser user) throws Exception {
		userMapper.addUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(SysUser user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Integer id) throws Exception {
		userMapper.deleteUser(id);
	}

	@Override
	public SysUser findUserById(Integer id) throws Exception {
		return userMapper.findUserId(id);
	}

	@Override
	public Pagination queryUsers(String startTime, String endTime, String username,
			Integer pageNo,Integer limit) throws Exception {
		Pagination pagination = null;
		Map<String,Object> paraMap = new HashMap<>();
		if(StringUtils.isNotBlank(startTime)){
			paraMap.put("startTime", startTime);
		}
		if(StringUtils.isNotBlank(endTime)){
			paraMap.put("endTime", endTime);
		}
		// 后模糊匹配
		if(StringUtils.isNotBlank(username)){
			paraMap.put("username", username);
		}
		int count = userMapper.queryUsersCount(paraMap);
		if(count > 0){
			pagination = new Pagination(pageNo, count, limit);
			paraMap.put("startNum", pagination.getStartNum());
			paraMap.put("limit", limit);
			List<SysUser> users = userMapper.queryUsers(paraMap);
			pagination.setRows(users);
		}
		return pagination;
	}

}

package com.ghx.service;


import com.ghx.domain.Pagination;
import com.ghx.domain.SysUser;

public interface SysUserService {

	public void addUser(SysUser user) throws Exception;

	public void updateUser(SysUser user) throws Exception;

	public void deleteUser(Integer id) throws Exception;

	public SysUser findUserById(Integer id) throws Exception;

	public Pagination queryUsers(String startTime, String endTime, String username
            , Integer pageNo, Integer limit) throws Exception;

}

package com.ghx.mapper;

import com.ghx.domain.SysUser;
import com.ghx.mapper.provider.SysUserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface SysUserMapper {

	@InsertProvider(type = SysUserProvider.class,method="addUser")
	public void addUser(SysUser user) throws Exception;

	@UpdateProvider(type = SysUserProvider.class,method = "updateUser")
	public void updateUser(SysUser user) throws Exception;

	@DeleteProvider(type = SysUserProvider.class,method = "deleteUser")
	public void deleteUser(Integer id) throws Exception;

	@Select("select id,username,address,age,remark,type,phone,birthday from sys_user where id = #{id}")
	public SysUser findUserId(Integer id) throws Exception;

	@SelectProvider(type = SysUserProvider.class, method = "queryUsersCount")
	public int queryUsersCount(Map<String, Object> paraMap) throws Exception;

	
	@SelectProvider(type = SysUserProvider.class, method = "queryUsers")
	public List<SysUser> queryUsers(Map<String, Object> paraMap) throws Exception;

}

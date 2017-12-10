package com.ghx.mapper.provider;

import com.ghx.domain.SysUser;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
*-------------------------------------------------
* @ClassName  : SysUserProvider
* @Descprition : TODO
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:28
*--------------------------------------------------
*/
public class SysUserProvider {
	
	public String addUser(SysUser user){
		StringBuilder sbStr = new StringBuilder("insert into sys_user (");
		//sbStr.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > ");
		if(StringUtils.isNotBlank(user.getUsername())){
			sbStr.append("username,");
		}
		if(StringUtils.isNotBlank(user.getAddress())){
			sbStr.append("address,");
		}
		//id,username,address,age,remark,type,phone,opt_time
		if(user.getAge() != null){
			sbStr.append("age,");
		}
		if(StringUtils.isNotBlank(user.getRemark())){
			sbStr.append("remark,");
		}
		if(user.getType() != null){
			sbStr.append("type,");
		}
		if(user.getPhone() != null){
			sbStr.append("phone,");
		}
		if(user.getBirthday() != null){
			sbStr.append("birthday,");
		}
		//sbStr.append("</trim> ");
		//sbStr.append("<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" > ");
		sbStr.deleteCharAt(sbStr.length()-1);
		sbStr.append(") values(");
		if(StringUtils.isNotBlank(user.getUsername())){
			sbStr.append("'").append(user.getUsername()).append("',");
		}
		if(StringUtils.isNotBlank(user.getAddress())){
			sbStr.append("'").append(user.getAddress()).append("',");
		}
		if(user.getAge() != null){
			sbStr.append(user.getAge()).append(",");
		}
		if(StringUtils.isNotBlank(user.getRemark())){
			sbStr.append("'").append(user.getRemark()).append("',");
		}
		if(user.getType() != null){
			sbStr.append(user.getType()).append(",");
		}
		if(user.getPhone() != null){
			sbStr.append(user.getPhone()).append(",");
		}
		if(user.getBirthday() != null){
			sbStr.append("'").append(user.getBirthday()).append("',");
		}
		sbStr.deleteCharAt(sbStr.length()-1);
		sbStr.append(") ");
		//sbStr.append("</trim> ");
		System.out.println(sbStr.toString());
		return sbStr.toString();
	}
	
	public String updateUser(SysUser user){
		StringBuilder sbStr = new StringBuilder("update sys_user ");
		//sbStr.append("<set> ").append("<trim suffixOverrides=\",\"> ");	
		sbStr.append("set ");
		if(StringUtils.isNotBlank(user.getUsername())){
			sbStr.append("").append("username = '").append(user.getUsername()).append("',");
		}
		if(StringUtils.isNotBlank(user.getAddress())){
			sbStr.append("address = '").append(user.getAddress()).append("',");
		}
		if(user.getAge() != null){
			sbStr.append("age = ").append(user.getAge()).append(",");
		}
		if(StringUtils.isNotBlank(user.getRemark())){
			sbStr.append("remark = '").append(user.getRemark()).append("',");
		}
		if(user.getType() != null){
			sbStr.append("type = ").append(user.getType()).append(",");
		}
		if(user.getPhone() != null){
			sbStr.append("phone = ").append(user.getPhone()).append(",");
		}
		if(user.getBirthday() != null){
			sbStr.append("birthday = '").append(user.getBirthday()).append("',");
		}
		//sbStr.append("</trim> ").append("</set> ");
		sbStr.deleteCharAt(sbStr.length()-1).append(" ");
		sbStr.append("where id = ").append(user.getId());
		return sbStr.toString();
	}
	
	public String deleteUser(Integer id){
		StringBuilder sbStr = new StringBuilder("delete from sys_user ");
		sbStr.append("where id =");
		//sbStr.append("<foreach collection=\"array\" separator=\",\" item=\"id\" open=\"(\" close=\")\"> ");
		//sbStr.append("#{id}").append("</foreach>");
		sbStr.append(id);
		return sbStr.toString();
	}
	
	
	public String queryUsersCount(Map<String, Object> paraMap){
		StringBuilder sbStr = new StringBuilder("select count(1) from (");
		sbStr.append(queryUsers(paraMap));
		sbStr.append(") m");
		return sbStr.toString();
	}
	
	
	public String queryUsers(Map<String, Object> paraMap){
		StringBuilder sbStr = new StringBuilder("select id,username,address,age,remark,type,phone,");
		sbStr.append("birthday from sys_user where 1 = 1 ");
		
		if(paraMap.containsKey("startTime")){
			sbStr.append("and birthday >= '").append(paraMap.get("startTime")).append("' ");
		}
		if(paraMap.containsKey("endTime")){
			sbStr.append("and birthday <= '").append(paraMap.get("endTime")).append("' ");
		}
		if(paraMap.containsKey("username")){
			sbStr.append("and username like '").append(paraMap.get("username")).append("%' ");
		}
		
		if(paraMap.containsKey("startNum")){
			sbStr.append("limit ").append(paraMap.get("startNum")).append(",")
			.append(paraMap.get("limit"));
		}		
		return sbStr.toString();
	}
	
}

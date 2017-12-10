package com.ghx.domain;

import lombok.Data;

import java.io.Serializable;
/**
*-------------------------------------------------
* @ClassName  : SysUser
* @Descprition : 用户
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:29
*--------------------------------------------------
*/
@Data
public class SysUser implements Serializable{
	
	private static final long serialVersionUID = 5762580476447590843L;
	
	private Integer id;
	private String username;
	private String address;
	private Byte   age;
	private String remark;
	private Byte type;
	private Integer phone;
	private String  birthday;
	
}

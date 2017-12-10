package com.ghx.provider;

import com.ghx.GHXProviderApplication;
import com.ghx.domain.Pagination;
import com.ghx.domain.SysUser;
import com.ghx.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GHXProviderApplication.class)
@WebAppConfiguration
public class UserTest {
	
	@Autowired
	private SysUserService userService;
	
	
	@Test
	public void testAdd() throws Exception{
		/*SysUser user = new SysUser();
		user.setUsername("张三");
		user.setAddress("北京市海淀区");
		user.setAge((byte)18);
		user.setRemark("heihei");
		user.setType((byte)2);
		user.setPhone(1234567);
		user.setBirthday("2000-07-07");*/
		SysUser user2 = new SysUser();
		user2.setUsername("张三-100");
		user2.setAddress("北京市其他区");
		user2.setAge((byte)20);
		user2.setRemark("heihei");
		user2.setType((byte)2);
		user2.setPhone(1234567);
		user2.setBirthday("2010-07-07");
		userService.addUser(user2);
	}
	
	@Test
	public void testUpdate() throws Exception{
		SysUser user = userService.findUserById(1);
		user.setRemark("hehe");
		userService.updateUser(user);
	}
	
	@Test
	public void testQuery() throws Exception{
		Pagination pagination = userService.queryUsers(null, null, null, 1, 10);
		System.out.println(pagination);
	}
	
	@Test
	public void testDelete() throws Exception{
		userService.deleteUser(1);
	}
	
}

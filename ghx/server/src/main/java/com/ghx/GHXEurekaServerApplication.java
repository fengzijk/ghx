package com.ghx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/**
*-------------------------------------------------
* @ClassName  : GHXEurekaServerApplication
* @Descprition : TODO
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:33
*-------------------------------------------------- 
*/
public class GHXEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GHXEurekaServerApplication.class, args);
	}
}

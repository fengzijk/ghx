package com.ghx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
public class GHXCloudAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GHXCloudAdminApplication.class, args);
	}
}

package com.ghx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.ghx")
@EnableAutoConfiguration
@PropertySource(value = "classpath:application.properties")
@EnableDiscoveryClient
public class GHXProviderApplication {

    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(OwnCloudProviderApplication.class);
		SpringContextUtil.setApplicationContext(applicationContext);
		applicationContext.start();*/
        SpringApplication.run(GHXProviderApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GHXProviderApplication.class);
    }
}

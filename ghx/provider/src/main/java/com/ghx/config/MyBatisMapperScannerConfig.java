package com.ghx.config;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

/**
*-------------------------------------------------
* @ClassName  : MyBatisMapperScannerConfig
* @Descprition :注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:26
*--------------------------------------------------
*/
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.learn.spring.cloud.api.mapper");
        return mapperScannerConfigurer;
    }

}

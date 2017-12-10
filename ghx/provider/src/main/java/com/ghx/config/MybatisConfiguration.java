package com.ghx.config;

import org.springframework.context.annotation.Configuration;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration("MybatisConfiguration")
@MapperScan(basePackages={"com.learn.spring.cloud.api.mapper"})
/**
*-------------------------------------------------
* @ClassName  : MybatisConfiguration
* @Descprition : TODO
* @Author : fengzijk
* @email: guozhifengvip@163.com
* @Time : 2017/12/10 13:30
*-------------------------------------------------- 
*/
public class MybatisConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(MybatisConfiguration.class);
	
	@Value("${druid.jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${druid.jdbc.url}")
	private String jdbcUrl;
	
	@Value("${druid.jdbc.userName}")
	private String jdbcUsername;
	
	@Value("${druid.jdbc.passWord}")
	private String jdbcPassword;
	
	@Value("${druid.jdbc.filters}")
	private String filters;
	
	@Value("${druid.jdbc.maxActive}")
	private int maxActive;
	
	@Value("${druid.jdbc.initialSize}")
	private int initialSize;
	
	@Value("${druid.jdbc.maxWait}")
	private int maxWait;
	
	@Value("${druid.jdbc.minIdle}")
	private int minIdle;
	
	@Value("${druid.jdbc.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	
	@Value("${druid.jdbc.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	
	@Value("${druid.jdbc.validationQuery}")
	private String validationQuery;
	
	@Value("${druid.jdbc.testWhileIdle}")
	private boolean testWhileIdle;
	
	@Value("${druid.jdbc.testOnBorrow}")
	private boolean testOnBorrow;
	
	@Value("${druid.jdbc.testOnReturn}")
	private boolean testOnReturn;
	
	@Value("${druid.jdbc.maxOpenPreparedStatements}")
	private int maxOpenPreparedStatements;
	
	@Value("${druid.jdbc.removeAbandoned}")
	private boolean removeAbandoned;
	
	@Value("${druid.jdbc.removeAbandonedTimeout}")
	private int removeAbandonedTimeout;
	
	@Value("${druid.jdbc.logAbandoned}")
	private boolean logAbandoned;
	  
	@Bean(name = "dataSource",destroyMethod="close")
	public DataSource dataSource() throws SQLException{
	    LOG.debug("---------> Set Druid Data Pool");
	    DruidDataSource source = new DruidDataSource();

	    source.setUsername(jdbcUsername);
	    source.setPassword(jdbcPassword);
	    source.setUrl(jdbcUrl);
	    source.setDriverClassName(driverClassName);
	    source.setFilters(filters);
	    source.setMaxActive(maxActive);
	    source.setInitialSize(initialSize);
	    source.setMinIdle(minIdle);
	    source.setMaxWait(maxWait);
	    source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	    source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	    source.setValidationQuery(validationQuery);
	    source.setTestWhileIdle(testWhileIdle);
	    source.setTestOnReturn(testOnReturn);
	    source.setTestOnBorrow(testOnBorrow);
	    source.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
	    source.setRemoveAbandoned(removeAbandoned);
	    source.setRemoveAbandonedTimeout(removeAbandonedTimeout);
	    source.setLogAbandoned(logAbandoned);

	    return source;
	 }
	
	 @Bean
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	    LOG.debug("---------> Set SqlSessionFactory");
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    Properties configProperties = new Properties();
	    configProperties.setProperty("dialect", "mysql");
	    //---待测试，看相应的SQL语句能否输出
	    //configProperties.setProperty("logImpl", "LOG4J2");
	    sessionFactory.setConfigurationProperties(configProperties);
	    return sessionFactory.getObject();	    
	 }
	 
	 @Bean(destroyMethod="clearCache")
	 public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	    LOG.debug("---------> Set SqlSessionTemplate");
	    sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
	    return new SqlSessionTemplate(sqlSessionFactory);
	 }	 
	
}

package com.ghx.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;


public class SpringContextUtil {
	
	private static  ApplicationContext applicationContext; 
	
	public static void setApplicationContext(ApplicationContext context) {
		 applicationContext = context;
	}
  
    /** 
     * 获取对象 
     * @param name 
     * @return Object
     * @throws BeansException 
     */  
    public static Object getBean(Class name) throws BeansException {
        return applicationContext.getBean(name);  
    }
    
}

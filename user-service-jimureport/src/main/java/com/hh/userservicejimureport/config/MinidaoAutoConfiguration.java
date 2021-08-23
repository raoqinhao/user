package com.hh.userservicejimureport.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecgframework.minidao.aspect.EmptyInterceptor;
import org.jeecgframework.minidao.factory.MiniDaoBeanScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author scott 2018/11/20
 * @version：1.0
 */
@Configuration
public class MinidaoAutoConfiguration{
	private static final Log logger = LogFactory.getLog(MinidaoAutoConfiguration.class);
	
	@Bean
    @ConditionalOnMissingBean(MiniDaoBeanScannerConfigurer.class)
    public static MiniDaoBeanScannerConfigurer miniDaoBeanScannerConfigurer(Environment env, ApplicationContext applicationContext) {
		logger.info(" ******************* init miniDao config [ begin ] *********************** ");
    	
		logger.info(" ------ minidao.base-package ------- "+env.getProperty("minidao.base-package","*"));
		logger.info(" ------ minidao.db-type ------------ "+env.getProperty("minidao.db-type","mysql"));
		//logger.info(" ------ minidao.annotation --------- "+env.getProperty("minidao.annotation"));
		logger.debug(" ------ minidao.format-sql --------- "+env.getProperty("minidao.format-sql","false"));
		logger.debug(" ------ minidao.key-type ----------- "+env.getProperty("minidao.key-type","origin"));
		logger.debug(" ------ minidao.show-sql ----------- "+env.getProperty("minidao.show-sql","false"));

    	MiniDaoBeanScannerConfigurer miniDaoBeanScannerConfigurer = new MiniDaoBeanScannerConfigurer();
    	miniDaoBeanScannerConfigurer.setBasePackage(env.getProperty("minidao.base-package","*"));
    	miniDaoBeanScannerConfigurer.setDbType(env.getProperty("minidao.db-type","mysql"));
    	if(applicationContext.getBean(EmptyInterceptor.class)!=null){
    		miniDaoBeanScannerConfigurer.setEmptyInterceptor(applicationContext.getBean(EmptyInterceptor.class));
    	}
    	
    	miniDaoBeanScannerConfigurer.setFormatSql(env.getProperty("minidao.format-sql",Boolean.class,false));
    	miniDaoBeanScannerConfigurer.setKeyType(env.getProperty("minidao.key-type","origin"));
    	miniDaoBeanScannerConfigurer.setShowSql(env.getProperty("minidao.show-sql",Boolean.class,false));
    	miniDaoBeanScannerConfigurer.setAnnotation(org.springframework.stereotype.Repository.class);
    	logger.info(" *******************  init miniDao config  [ end ] *********************** ");
        return miniDaoBeanScannerConfigurer;
    }
}

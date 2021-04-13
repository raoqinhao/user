package com.hh.userserviceactiviti.config;

import com.google.common.collect.ImmutableList;
import org.activiti.api.runtime.shared.identity.UserGroupManager;
import org.activiti.engine.impl.history.HistoryLevel;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class WorkFlowConfig {

    @Autowired
    private DataSource dataSource;

    @Primary
    @Bean
    public UserGroupManager userGroupManager() {
        return new UserGroupManager() {
            @Override
            public List<String> getUserGroups(String s) {
                return ImmutableList.of("指定用户归属组");
            }

            @Override
            public List<String> getUserRoles(String s) {
                return null;
            }

            @Override
            public List<String> getGroups() {
                return null;
            }

            @Override
            public List<String> getUsers() {
                return null;
            }
        };
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(PlatformTransactionManager transactionManager) {
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setTransactionManager(transactionManager);
        SpringAsyncExecutor springAsyncExecutor = new SpringAsyncExecutor();
        springAsyncExecutor.setTaskExecutor(threadPoolTaskExecutor());
        springProcessEngineConfiguration.setAsyncExecutor(springAsyncExecutor);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        springProcessEngineConfiguration.setUserGroupManager(userGroupManager());
        springProcessEngineConfiguration.setHistoryLevel(HistoryLevel.FULL);
        springProcessEngineConfiguration.setDbHistoryUsed(true);
        return springProcessEngineConfiguration;
    }

    @Primary
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(30);
        threadPoolTaskExecutor.setKeepAliveSeconds(500);
        threadPoolTaskExecutor.setQueueCapacity(500);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}

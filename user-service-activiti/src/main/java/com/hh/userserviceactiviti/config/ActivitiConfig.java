package com.hh.userserviceactiviti.config;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ActivitiConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration() {
        StandaloneProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(dataSource);
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        processEngineConfiguration.setAsyncExecutorActivate(false);
        return processEngineConfiguration;
    }

    @Bean
    @Primary
    public ProcessEngine buildProcessEngine() {
        return standaloneProcessEngineConfiguration().buildProcessEngine();
    }

    @Bean
    public RepositoryService repositoryService() {
        return buildProcessEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService() {
        return buildProcessEngine().getRuntimeService();
    }

    @Bean
    public TaskService taskService() {
        return buildProcessEngine().getTaskService();
    }

    @Bean
    public HistoryService historyService() {
        return buildProcessEngine().getHistoryService();
    }
}

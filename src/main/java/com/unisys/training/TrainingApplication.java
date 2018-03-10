package com.unisys.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@SpringBootApplication
public class TrainingApplication {

	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
          return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
	}

    @Bean
    public PlatformTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
    }

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}
}

package sap.amit.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import sap.amit.model.*;
import sap.amit.repo.*;
import sap.amit.util.*;

@Configuration
@EnableJpaRepositories(basePackageClasses = Sap_Prod_Repo.class)
public class ConnectCloud extends AbstractCloudConfig {

	/*@Bean
	public DataSource dataSource() {
		List<String> dataSourceNames = Arrays.asList("xne46wOMa58LHp2R");
		DataSourceConfig dbConfig = new DataSourceConfig(dataSourceNames);
		return connectionFactory().dataSource(dbConfig);
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		return EntityManagerFactoryProvider.get(dataSource, Sap_Prod.class.getPackage().getName());
	}

	@Bean(name = "transactionManager")
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}*/
}

package com.sph.newspaper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.sph.newspaper.repository"})
@PropertySource(name="propertyConfig", value = {"classpath:config.properties"})
public class RepositoryConfig  extends AbstractMongoConfiguration{
	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getProperty("mongo.db.name");
	}

	@Override
	public Mongo mongo() throws Exception {		
		return new MongoClient(env.getProperty("mongo.db.host"), Integer.valueOf(env.getProperty("mongo.db.port")));
	}	
	
	@Override
	protected String getMappingBasePackage() {
		return "com.sph.newspaper.domain";
	}	
}

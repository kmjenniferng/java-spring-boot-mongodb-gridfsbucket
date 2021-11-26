package com.example.spring.mongodb.gridfsbucket.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private Integer port;
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	
	@Bean
	public MongoClient getMongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://" + host + ":" + port + "/" + databaseName);
        MongoClientSettings mongoClientSettings = MongoClientSettings
        		.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
	}
	
	@Bean
	public GridFSBucket getgridFSBucket(MongoClient mongoClient) {
		MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
		return GridFSBuckets.create(mongoDatabase);
	}
}
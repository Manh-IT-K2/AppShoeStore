package com.example.AppShoeStoreBE.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class ConfigMongoDB {
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb+srv://sa:123@cluster0.x9nciri.mongodb.net/AppShoeStore?retryWrites=true&w=majority&appName=Cluster0"));
    }
}

package com.example.AppShoeStoreBE.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class ConfigMongoDB {
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb+srv://root:123@manh-it-k2.faw2zrx.mongodb.net/app_shoe_store?retryWrites=true&w=majority&appName=MANH-IT-K2"));
    }
}

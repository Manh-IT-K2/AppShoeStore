package com.example.AppShoeStoreBE.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;
}

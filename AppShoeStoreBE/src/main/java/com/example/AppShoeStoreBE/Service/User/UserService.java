package com.example.AppShoeStoreBE.Service.User;

import com.example.AppShoeStoreBE.Request.User.CreateAccountRequest;
import com.example.AppShoeStoreBE.Util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ApiResponse<String> CreateAccount(CreateAccountRequest createAccountRequest);

}

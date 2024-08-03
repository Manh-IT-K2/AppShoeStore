package com.example.AppShoeStoreBE.Service.User;

import com.example.AppShoeStoreBE.Entity.User;
import com.example.AppShoeStoreBE.Request.User.CreateAccountRequest;
import com.example.AppShoeStoreBE.Request.User.LoginAccountRequest;
import com.example.AppShoeStoreBE.Util.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // create account
    ApiResponse<User> CreateAccount(CreateAccountRequest createAccountRequest);

    // login account
    ApiResponse<User> LoginAccount(LoginAccountRequest loginRequest);
}

package com.example.AppShoeStoreBE.Service.User;

import com.example.AppShoeStoreBE.Entity.User;
import com.example.AppShoeStoreBE.Request.User.CreateAccountRequest;
import com.example.AppShoeStoreBE.Util.ApiResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse<String> CreateAccount(CreateAccountRequest u) {
        ApiResponse<String> response = new ApiResponse<>();
        try {
            User user = new User();
            user.setUserName(u.getUserName());
            user.setPassWord(u.getPassWord());
            user.setEmail(u.getEmail());

            // Insert the user into the "user" collection
            mongoTemplate.insert(user, "user");

            // Set the response status and message
            response.setStatus(true);
            response.setMessage("Account created successfully");

            // convert gson
            Gson gson = new Gson();
            response.setData(gson.toJson(user));
        } catch (Exception e) {
            // Handle any exceptions that occur during insertion
            response.setStatus(false);
            response.setMessage("Account creation failed: " + e.getMessage());
        }
        return response;
    }

}

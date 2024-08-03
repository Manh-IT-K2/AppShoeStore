package com.example.AppShoeStoreBE.Service.User;

import com.example.AppShoeStoreBE.Entity.User;
import com.example.AppShoeStoreBE.Request.User.CreateAccountRequest;
import com.example.AppShoeStoreBE.Request.User.LoginAccountRequest;
import com.example.AppShoeStoreBE.Util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;


    // create account
    @Override
    public ApiResponse<User> CreateAccount(CreateAccountRequest u) {
        ApiResponse<User> response = new ApiResponse<>();
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
            response.setData(user);

            //
            System.out.println("Create Account Success!");
        } catch (Exception e) {
            // Handle any exceptions that occur during insertion
            response.setStatus(false);
            response.setMessage("Account creation failed: " + e.getMessage());
            System.out.println("Create Account Failure!");
        }
        return response;
    }

    // login account
    @Override
    public ApiResponse<User> LoginAccount(LoginAccountRequest loginRequest) {
        Query query = new Query(Criteria.where("email").is(loginRequest.getEmail()));
        User user = mongoTemplate.findOne(query, User.class, "user");
        // Assuming you have a constructor or a builder for ApiResponse
        ApiResponse<User> response = new ApiResponse<>();
        if (user != null && user.getPassWord().equals(loginRequest.getPassWord())) {
            response.setData(user);
            response.setStatus(true);
            response.setMessage("Login Success!");
            System.out.println("Login Success!");
        } else {
            response.setStatus(false);
            response.setMessage("Login Failure!");
            System.out.println("Login Failure!");
        }
        return response;
    }

}

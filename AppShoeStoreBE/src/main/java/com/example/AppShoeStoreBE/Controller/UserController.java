package com.example.AppShoeStoreBE.Controller;

import com.example.AppShoeStoreBE.Request.User.CreateAccountRequest;
import com.example.AppShoeStoreBE.Service.User.UserService;
import com.example.AppShoeStoreBE.Util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    // create account
    @PostMapping("createAccount")
    public ResponseEntity<ApiResponse<String>> createAccount(@RequestBody CreateAccountRequest u) {
        ApiResponse<String> response = userService.CreateAccount(u);
        if (response.isStatus()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

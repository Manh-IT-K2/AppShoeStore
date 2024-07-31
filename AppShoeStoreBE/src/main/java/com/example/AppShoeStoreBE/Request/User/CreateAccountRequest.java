package com.example.AppShoeStoreBE.Request.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

    private String userName;

    private String passWord;

    private String email;
}

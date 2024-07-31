package com.example.AppShoeStoreBE.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String userName;

    private String passWord;

    private String email;

    private String avatar;
}

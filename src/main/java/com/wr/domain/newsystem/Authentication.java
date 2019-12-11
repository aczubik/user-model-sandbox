package com.wr.domain.newsystem;

import com.wr.domain.newsystem.IAM;
import com.wr.domain.newsystem.NewJWTToken;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authentication {

    private final IAM iam;
    private final UserManagementClient userManagementClient;

    NewJWTToken signInByCredentials(String mail, String password) {
        NewJWTToken token = iam.signInByCredentials(mail, password);

        return token;
    }
}

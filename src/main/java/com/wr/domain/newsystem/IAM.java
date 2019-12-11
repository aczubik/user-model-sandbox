package com.wr.domain.newsystem;

import com.wr.domain.UserGuid;


public interface IAM {
    IAMIdentity createIdentity(String mail, String password, UserGuid userGuid);

    NewJWTToken signInByCredentials(String mail, String password);
}

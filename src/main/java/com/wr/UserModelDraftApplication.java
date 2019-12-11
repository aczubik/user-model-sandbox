package com.wr;

import com.wr.domain.*;
import com.wr.domain.newsystem.IAM;
import com.wr.domain.newsystem.IAMIdentity;
import com.wr.domain.newsystem.NewJWTToken;


class KeyCloakAdapter implements IAM {

    @Override
    public IAMIdentity createIdentity(String mail, String password, UserGuid userGuid) {
        return null;
    }

    @Override
    public NewJWTToken signInByCredentials(String mail, String password) {
        return null;
    }
}


class UserManagement {

}

public class UserModelDraftApplication {

    public static void main(String[] args) {

    }
}

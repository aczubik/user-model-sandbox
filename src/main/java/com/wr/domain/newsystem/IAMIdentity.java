package com.wr.domain.newsystem;

import com.wr.domain.IdentityId;
import com.wr.domain.SenderId;
import com.wr.domain.UserGuid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class IAMIdentity {
    private IdentityId identityId;
    private String mail;
    private String password;
    private UserGuid userGuid;
    private SenderId senderId;
}

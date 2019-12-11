package com.wr.domain.bridge;

import com.wr.domain.IdentityId;
import com.wr.domain.LegacyJWTToken;
import com.wr.domain.SenderId;
import com.wr.domain.UserGuid;
import com.wr.domain.newsystem.IAM;
import com.wr.domain.newsystem.IAMIdentity;
import com.wr.domain.newsystem.NewJWTToken;
import lombok.AllArgsConstructor;

interface IAMIdentityRepository {
    void save(IAMIdentity identity);
    IAMIdentity findBy(IdentityId id);
    IAMIdentity findBy(String mail);
}

@AllArgsConstructor
public class LegacyIAM implements IAM {

    private final LegacyApiClient legacyApiClient;
    private final AuthServiceClient authServiceClient;
    private final IAMIdentityRepository identityRepository;

    @Override
    public IAMIdentity createIdentity(String mail, String password, UserGuid userGuid) {
        SenderId senderId = legacyApiClient.createUserAccount(mail, password, userGuid);
        // I am not sure if that separate IdentityRepository is required. If we're able to add UserGuid to token in AuthService.
        IAMIdentity iamIdentity = new IAMIdentity(IdentityId.createRandom(), mail, password, userGuid, senderId);
        identityRepository.save(iamIdentity);
        return iamIdentity;
    }

    @Override
    public NewJWTToken signInByCredentials(String mail, String password) {
        LegacyJWTToken legacyJWTToken = authServiceClient.login(mail, password);
        IAMIdentity iamIdentity = identityRepository.findBy(mail);
        return new NewJWTToken(legacyJWTToken, iamIdentity.getUserGuid());
    }
}

package com.wr.domain.newsystem;

import com.wr.domain.IdentityId;
import com.wr.domain.UserGuid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Registration {

    private final IAM iam;
    private final UserManagementClient userManagementClient;

    IdentityId registerUser(String mail, String password) {
        var userGuid = UserGuid.createRandom();

        // there is an assumption that if this call fails the who "lets create user" fails and leaves no trace of this user within that system
        // on the other hand if it succeeds and next call fails, identity created within this call is sufficient to create user while signing-in
        var identity = iam.createIdentity(mail, password, userGuid);

        // this call mail fail and its ok as described above
        userManagementClient.createUserAsync(identity);

        return identity.getIdentityId();
    }
}

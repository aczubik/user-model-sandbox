package com.wr.domain.newsystem;

public interface UserManagementClient {

    void createUserAsync(IAMIdentity identity);
    void createUserIfNotExistsAsync(IAMIdentity identity);
}

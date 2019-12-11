package com.wr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@ToString
@Getter
public class IdentityId {
    private UUID id;

    public static IdentityId createRandom() {
        return new IdentityId(UUID.randomUUID());
    }
}

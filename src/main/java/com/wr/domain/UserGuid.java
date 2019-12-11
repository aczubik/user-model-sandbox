package com.wr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@ToString
@Getter
public class UserGuid {
    private UUID id;

    public static UserGuid createRandom() {
        return new UserGuid(UUID.randomUUID());
    }
}

package com.wr.domain.newsystem;

import com.wr.domain.LegacyJWTToken;
import com.wr.domain.UserGuid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class NewJWTToken {
    private final LegacyJWTToken legacyJWTToken;
    private final UserGuid userGuid;
}

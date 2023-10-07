package com.div.model.dto;

import com.div.annotation.MatchPassword;
import com.div.annotation.UniqeEmail;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationDto {
    private String token;
    private String refreshToken;
}

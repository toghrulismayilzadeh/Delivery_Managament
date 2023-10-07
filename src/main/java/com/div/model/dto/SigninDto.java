package com.div.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SigninDto {
    private String email;
    private String password;
}

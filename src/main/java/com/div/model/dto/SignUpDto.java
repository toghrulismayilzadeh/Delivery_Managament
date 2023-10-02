package com.div.model.dto;

import com.div.annotation.MatchPassword;
import com.div.annotation.UniqeEmail;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@MatchPassword
@UniqeEmail
public class SignUpDto {
    @Pattern(regexp = "[A-Za-z]+")
    @NotBlank
    @Max(25)
    private String firstName;
    @Pattern(regexp = "[A-Za-z]+")
    @NotBlank
    @Max(35)
    private String lastName;
    @Pattern(regexp = "[0-9]{3}+[0-9]{3}+[0-9]{4}")
    @NotBlank
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "[\\w.-]+@[\\w.-]+.\\w+$")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String confrimPassword;
}

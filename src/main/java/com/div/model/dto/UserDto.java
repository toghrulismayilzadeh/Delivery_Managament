package com.div.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
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
    private Float balance;
    private String location;

}

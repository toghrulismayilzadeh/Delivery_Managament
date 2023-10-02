package com.div.model.dto;

import com.div.model.entity.OrderPlace;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
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
    private String location;
    private Boolean status;
    @OneToOne(mappedBy = "driver")
    private OrderPlace orderPlace;
}

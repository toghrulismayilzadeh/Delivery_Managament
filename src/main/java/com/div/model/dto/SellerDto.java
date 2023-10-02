package com.div.model.dto;

import com.div.model.entity.Catagory;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

public class SellerDto {
    @NotBlank
    @Max(50)
    private String name;
    @Past
    private LocalDate creatDate;
    private String location;
    private Boolean status;
    private List<Catagory> catagories;
}

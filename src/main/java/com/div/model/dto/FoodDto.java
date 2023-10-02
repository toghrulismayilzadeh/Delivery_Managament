package com.div.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class FoodDto {
    @NotBlank
    private String name;
    @NotBlank
    private float price;
    private String image;
    private String foodDetails;
    private Boolean status;
    private Long catagoryId;
}

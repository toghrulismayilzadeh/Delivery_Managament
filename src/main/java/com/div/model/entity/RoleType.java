package com.div.model.entity;

public enum RoleType {
    ADMIN("Admin"),
    SELLER("Seller"),
    USER("User"),
    DRIVER("Driver");

     public final String roleName ;


    RoleType(String roleName){

        this.roleName=roleName;

    }


}

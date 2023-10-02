package com.div.mapper;


import com.div.model.dto.UserDto;
import com.div.model.dto.SignUpDto;
import com.div.model.entity.Permission;
import com.div.model.entity.Role;
import com.div.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;



@Mapper(componentModel = "spring",imports = {LocalDateTime.class, LocalDate.class, UUID.class})
public abstract class UserMapper {
    @Autowired
    protected PasswordEncoder encoder;
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "orderPlace", ignore = true)
    @Mapping(target = "balance", constant = "0.0F")
    @Mapping(target = "creatDate", expression = "java(LocalDate.from(LocalDateTime.now()))")
    public abstract User dtoToEntity (UserDto userDto);

    public abstract UserDto entitytoDto (User user);
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "username", constant = "true")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "balance", constant = "0")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "orderPlace", ignore = true)
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID())")
    @Mapping(target = "role", expression = "java(generateRole())")
    @Mapping(target = "creatDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "password",expression = "java(encoder.encode(signUpDto.getPassword()))")
    public abstract User signupToEntity(SignUpDto signUpDto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "creatDate", ignore = true)
    @Mapping(target = "orderPlace", ignore = true)
    public abstract void updateEntity(@MappingTarget User user, UserDto userDto);

    public  Role generateRole (){
        Permission p1=new Permission(null,"READ_CUSTOMER");
        Permission p2=new Permission(null,"WRITE_CUSTOMER");
        Permission p3=new Permission(null,"UPDATE_CUSTOMER");
        Permission p4=new Permission(null,"DELETE_CUSTOMER");
        List<Permission> permissions= Arrays.asList(p1,p2,p3,p4);
        Role role =new Role(1,"CUSTOMER",permissions);
        return role;
    }

}

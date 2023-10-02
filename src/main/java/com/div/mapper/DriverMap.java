package com.div.mapper;

import com.div.model.dto.DriverDto;
import com.div.model.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring",imports = {LocalDateTime.class, LocalDate.class})
public abstract class DriverMap {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "creatDate", ignore = true)
    public abstract Driver dtoToEntity(DriverDto dto);
    @Mapping(target = "orderPlace", ignore = true)
    public abstract DriverDto entityToDto (Driver driver);
    public abstract void updateEntity(@MappingTarget Driver driver, DriverDto driverDto);


}

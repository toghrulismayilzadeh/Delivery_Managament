package com.div.service;

import com.div.exception.NoDataFoundException;
import com.div.mapper.DriverMap;
import com.div.model.dto.DriverDto;
import com.div.model.entity.Driver;
import com.div.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repository;
    private final DriverMap map;
    public List<DriverDto> findAll() {
        return repository.findAll()
                .stream()
                .map(s->map.entityToDto(s))
                .toList();
    }

    public DriverDto findById(Long id) {
        Driver driver = repository.findById(id).orElseThrow(NoDataFoundException::new);
        DriverDto driverDto = map.entityToDto(driver);
        return driverDto;
    }
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public DriverDto save(DriverDto driverDto) {
        Driver driver = map.dtoToEntity(driverDto);
        Driver save = repository.save(driver);
        return map.entityToDto(save);
    }
    @Transactional(rollbackFor = {SQLException.class,RuntimeException.class})
    public DriverDto updateById(Long id, DriverDto driverDto) {
        Driver driver = repository.findById(id).orElseThrow(NoDataFoundException::new);
        map.updateEntity(driver,driverDto);
        Driver save = repository.save(driver);
        return map.entityToDto(save);
    }
    @Transactional(rollbackFor = {SQLException.class,RuntimeException.class})
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

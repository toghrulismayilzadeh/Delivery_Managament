package com.div.service;

import com.div.exception.NoDataFoundException;
import com.div.mapper.UserMapper;
import com.div.model.dto.UserDto;
import com.div.model.entity.User;
import com.div.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper map;
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(map::entitytoDto)
                .toList();
    }

    public UserDto findById(Long id) {
        User user = repository.findById(id).orElseThrow(NoDataFoundException::new);
        UserDto userDto = map.entitytoDto(user);
        return userDto;
    }
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public UserDto save(UserDto userDto) {
        User user = map.dtoToEntity(userDto);
            User save = repository.save(user);
            return map.entitytoDto(save);
    }
    @Transactional(rollbackFor = {SQLException.class,RuntimeException.class})
    public UserDto updateById(Long id, UserDto userDto) {
        User user = repository.findById(id).orElseThrow(NoDataFoundException::new);
        map.updateEntity(user, userDto);
        User save = repository.save(user);
        return map.entitytoDto(save);
    }
    @Transactional(rollbackFor = {SQLException.class,RuntimeException.class})
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

//    public UserDetailsService customerDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//                return repository.findByEmail(email);
//            }
//        };
//    }
}

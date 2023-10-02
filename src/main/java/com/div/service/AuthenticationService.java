package com.div.service;

import com.div.mapper.UserMapper;
import com.div.model.dto.SignUpDto;
import com.div.model.entity.User;
import com.div.model.entity.Role;
import com.div.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service
@RequiredArgsConstructor
public class AuthenticationService  {
    private final UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final UserMapper map;
    private String baseUrl="http://127.0.0.1:8080/";
    private boolean isSending = false;
    private Queue<SimpleMailMessage> queue = new ConcurrentLinkedQueue<>();
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public User signup(SignUpDto signUpDto){
        User user = map.signupToEntity(signUpDto);
        User save = userRepository.save(user);
        simplemassage(save);
        return save;
    }
    public void simplemassage (User user){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("togrul.isamyilzada.2003@gmail.com");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Registration Confirmation");
        mailMessage.setText(baseUrl+"registration/confirmation/"+ user.getUuid());
    }
    @Scheduled(fixedDelay = 5000)
    public void sendMail() {
        while (!isSending && !queue.isEmpty()) {
            isSending = true;
            mailSender.send(queue.poll());
        }
        isSending = false;
    }
    @Transactional(rollbackFor = {SQLException.class, RuntimeException.class})
    public User enableUpdate(UUID uuid) {
        User byUuid = userRepository.findByUuid(uuid);
        byUuid.setEnabled(true);
        User save = userRepository.save(byUuid);
        return save;
    }


}

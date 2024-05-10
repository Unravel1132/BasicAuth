package com.jdbchibernatesql.securityregistrationauth.Entity;


import com.github.javafaker.Faker;
import com.jdbchibernatesql.securityregistrationauth.Repository.MyUserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;


@Service
@AllArgsConstructor
public class AppService {

    private final UserDetailsService userDetailsService;
    private List<Application> myAppList;
    private  MyUserRepository MyUserRepository;
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void loadInDb(){
        Faker  faker = new Faker();
        myAppList = IntStream.rangeClosed(1, 100)
                .mapToObj(i  -> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();



    }
    public List<Application> getAllApp(){
        return myAppList;
    }

    public Application getAppById(int id){
        return myAppList.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public void addUser(MyUser myUser){
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
         MyUserRepository.save(myUser);

    }



}

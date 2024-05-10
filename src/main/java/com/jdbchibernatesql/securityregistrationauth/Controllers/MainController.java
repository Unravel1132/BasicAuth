package com.jdbchibernatesql.securityregistrationauth.Controllers;


import com.jdbchibernatesql.securityregistrationauth.Entity.AppService;
import com.jdbchibernatesql.securityregistrationauth.Entity.Application;
import com.jdbchibernatesql.securityregistrationauth.Entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MainController {

    private final AppService app;

    @Autowired
    public MainController(AppService app) {
        this.app = app;
    }


    @GetMapping("/homePage")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String homePage(){
        return "Hello World";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Application> findAll(){
        return app.getAllApp();
    }
    @GetMapping("/{id}")
    public Application getById(@PathVariable int id){
        return app.getAppById(id);
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser myUser){
        app.addUser(myUser);
        return "User added";
    }


}

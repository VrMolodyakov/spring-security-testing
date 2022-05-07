package com.example.securityWithHibernate.Controller;

import com.example.securityWithHibernate.Model.Users;
import com.example.securityWithHibernate.Paging.Page;
import com.example.securityWithHibernate.Paging.PagingRequest;
import com.example.securityWithHibernate.Repository.UserService;
import com.example.securityWithHibernate.Repository.UsersRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestService {

    @Autowired
    UserService userService;


    @GetMapping(value = "/getAdmin",produces = "application/json")
    public List<Users> listOfUsers(){

        System.out.println("---------------here-------------");
        return userService.findAllUsers();
    }

}

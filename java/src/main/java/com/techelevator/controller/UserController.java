package com.techelevator.controller;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RequestMapping("/users")
    @RestController
    @PreAuthorize("isAuthenticated()")
    @CrossOrigin(origins = "http://localhost:8080")
    public class UserController {

        private UserDao userDao;

        public UserController(UserDao userDao) {
            this.userDao = userDao;

        }

    }
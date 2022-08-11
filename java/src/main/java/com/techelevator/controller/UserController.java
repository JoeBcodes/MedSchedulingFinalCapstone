package com.techelevator.controller;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RequestMapping("/users")
    @RestController
    @PreAuthorize("isAuthenticated()")
    public class UserController {

        private UserDao userDao;

        public UserController(UserDao userDao) {
            this.userDao = userDao;

        }
//
//        @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
//        public List<User> findAll() {
//            return userDao.findAll();
//        }

    }
package com.example.springboot0814training.service.impl;

import com.example.springboot0814training.dao.UserDAO;
import com.example.springboot0814training.dto.UserRegisterQuest;
import com.example.springboot0814training.model.User;
import com.example.springboot0814training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public Integer register(UserRegisterQuest userRegisterQuest) {

        User user = userDAO.getUserByEmail(userRegisterQuest.getEmail());

        if (user != null) {
            log.error("Email {} is already in use", userRegisterQuest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDAO.register(userRegisterQuest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }
}

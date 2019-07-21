package com.eror.controller;

import com.eror.mapper.UserMapper;
import com.eror.dto.UserDTO;
import com.eror.model.User;
import com.eror.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserMapper userConverter;

    @Autowired
    public UserController(UserService userService, UserMapper userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @RequestMapping
    public ResponseEntity<List<User>> listOfUsers() {
        LOGGER.info("start listOfUsers users");
        try {
            List<User> users = userService.findAll();
            LOGGER.info("Found {} users", users.size());
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/{id}")
    public ResponseEntity<UserDTO> loadOne(@PathVariable int id) {
        LOGGER.info("start loadOne user by id: ", id);
        try {
            User user = userService.find(id);
            LOGGER.info("Found: {}", user);
            return new ResponseEntity<>(userConverter.userToDTO(user), HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("start creating user: ", userDTO);
        try {
            User user = userService.create(userConverter.DTOtoUser(userDTO));
            return new ResponseEntity<>(userConverter.userToDTO(user), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        LOGGER.info("start update user: ", userDTO);
        try {
            User user = userService.update(id, userConverter.DTOtoUser(userDTO));
            return new ResponseEntity<>(userConverter.userToDTO(user), HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        if (userService.delete(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}

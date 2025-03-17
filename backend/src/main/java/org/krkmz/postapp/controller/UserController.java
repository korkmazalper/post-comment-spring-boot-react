package org.krkmz.postapp.controller;

import org.krkmz.postapp.entity.User;
import org.krkmz.postapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/users" )
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }

    @GetMapping( "/{userId}" )
    public User getUser (@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser (@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PutMapping( "/{userId}" )
    public User updateUser (@PathVariable Long userId, @RequestBody User userToUpdate) {


        return userService.updateUser(userId, userToUpdate);
    }

    @DeleteMapping( "/{userId}" )
    public void deleteUser (@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}

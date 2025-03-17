package org.krkmz.postapp.service;

import org.krkmz.postapp.entity.User;
import org.krkmz.postapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User getUserById (Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with " +
                "id:" + userId));
    }

    public User save (User newUser) {
        return userRepository.save(newUser);
    }

    public void deleteById (Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser (Long userId, User userToUpdate) {
        Optional<User> user = Optional.of(userRepository.getById(userId));
        if ( user.isPresent() ) {
            User foundUser = user.get();
            foundUser.setUserName(userToUpdate.getUserName());
            foundUser.setPassword(userToUpdate.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        return null;
    }
}
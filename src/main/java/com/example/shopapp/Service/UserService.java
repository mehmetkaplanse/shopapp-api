package com.example.shopapp.Service;

import com.example.shopapp.Entitities.User;
import com.example.shopapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User login(User userRequest) {
        Optional<User> userOptional = userRepository.findByUsername(userRequest.getUsername());
        if(userOptional.isPresent()) {
            if(userRequest.getPassword().equals(userOptional.get().getPassword())) {
                return userOptional.get();
            }
        }
        return null;
    }
}

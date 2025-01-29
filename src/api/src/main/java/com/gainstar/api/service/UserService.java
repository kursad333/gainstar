package com.gainstar.api.service;

import com.gainstar.api.entity.User;
import com.gainstar.api.entity.UserCreationDTO;
import com.gainstar.api.entity.UserRole;
import com.gainstar.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserCreationDTO user) {
        try {
            User existingUsername = this.userRepository.findByUsername(user.username());
            if (existingUsername != null) {
                throw new Exception("User with username " + user.username() + " already exists");
            }
            User newUser = new User();
            newUser.setUsername(user.username());
            // TODO: Hash the password before saving it. We need Spring Security dependency for this.
            newUser.setPassword(user.password());
            newUser.setUserRole(UserRole.USER); // Default to USER role. This seems common practice
            this.userRepository.save(newUser);
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

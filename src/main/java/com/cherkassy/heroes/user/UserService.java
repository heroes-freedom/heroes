package com.cherkassy.heroes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User createUser(@Valid UserCreationForm userCreationForm) {
        User user = new User();
        user.setEmail(userCreationForm.getEmail());
        user.setFirstName(userCreationForm.getFirstName());
        user.setLastName(userCreationForm.getLastName());
        user.setRole(Role.USER);

        String password = 1000000 + new Random().nextInt(9000000) + "";
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        System.out.println("Creating user[email=" + user.getEmail() + ", password=" + password + "]");

        return userRepository.save(user);
    }
}
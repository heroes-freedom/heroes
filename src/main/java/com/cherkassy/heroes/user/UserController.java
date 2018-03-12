package com.cherkassy.heroes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<User> allUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/current")
    public User currentUser(Authentication authentication) {
        return userService.getUserByEmail(authentication.getName())
                .orElseThrow(() -> new IllegalStateException("Session Expired."));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserCreationForm userCreationForm) {
        User user = userService.createUser(userCreationForm);
        return ResponseEntity
                .created(URI.create("/api/heroes/users" + user.getUserId()))
                .body(user);
    }
}
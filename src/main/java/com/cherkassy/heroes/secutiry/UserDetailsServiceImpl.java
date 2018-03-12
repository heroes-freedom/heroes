package com.cherkassy.heroes.secutiry;

import com.cherkassy.heroes.user.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.cherkassy.heroes.user.User> oUser = userRepository.getUserByEmail(userName);
        com.cherkassy.heroes.user.User user = oUser.orElseThrow(() -> new UsernameNotFoundException(userName));
        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
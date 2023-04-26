package com.example.asgn2.services;



import com.example.asgn2.config.security.AuthUser;
import com.example.asgn2.model.User;
import com.example.asgn2.model.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public AuthUser loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException(
                       String.format("User %s not found", email)));
        return new AuthUser(user.getId(), user.getEmail(), user.getPassword());
    }
}

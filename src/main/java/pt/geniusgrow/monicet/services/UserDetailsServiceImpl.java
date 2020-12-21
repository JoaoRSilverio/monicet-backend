package pt.geniusgrow.monicet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pt.geniusgrow.monicet.interfaces.repositories.UserRepository;
import pt.geniusgrow.monicet.models.application.ApplicationUser;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userRepository.getUserByEmail(s);
        if(applicationUser == null) throw new UsernameNotFoundException(s);
        return new User(applicationUser.getEmail(),applicationUser.getPassword(), Collections.emptyList());
    }
}

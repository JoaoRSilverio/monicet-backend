package pt.geniusgrow.monicet.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pt.geniusgrow.monicet.interfaces.repositories.company.UserRepository;
import pt.geniusgrow.monicet.interfaces.services.DefaultUserDetailService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.security.ApplicationUserPrincipal;

@Service
public class CustomUserDetailServiceImpl implements DefaultUserDetailService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.getUserByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        UserDetails userDetails = new ApplicationUserPrincipal(user);
        return userDetails;
    }
}

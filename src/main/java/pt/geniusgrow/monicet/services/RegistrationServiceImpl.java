package pt.geniusgrow.monicet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.repositories.UserRepo;

import javax.persistence.PersistenceException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto registerNewUser(ApplicationUser applicationUser) throws PersistenceException {

        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        userRepo.saveUser(applicationUser);
        return new UserDto(applicationUser.getName(), applicationUser.getEmail());
    }
}

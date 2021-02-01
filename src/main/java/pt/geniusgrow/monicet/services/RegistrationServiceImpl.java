package pt.geniusgrow.monicet.services;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt.geniusgrow.monicet.dtos.CompanyDto;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.repositories.UserRepo;
import pt.geniusgrow.monicet.repositories.address.CountryRepo;
import pt.geniusgrow.monicet.repositories.person.CompanyRepo;
import pt.geniusgrow.monicet.repositories.person.PersonRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void editPersonDetails(Person person) {
        personRepo.savePerson(person);
    }

    @Override
    public UserDto getPersonByUser(String email) {
        return userRepo.getUserByEmail(email).getPerson();
    }

    @Override
    public UserDto registerNewUser(ApplicationUser applicationUser) throws PersistenceException {

        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        userRepo.saveUser(applicationUser);
        return new UserDto(applicationUser.getName(), applicationUser.getEmail());
    }

    @Override
    public CompanyDto getCompanyByName(String name) {
        return companyRepo.getCompanyByName(name);
    }

   
}

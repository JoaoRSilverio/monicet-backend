package pt.geniusgrow.monicet.interfaces.services;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.dtos.CompanyDto;
import pt.geniusgrow.monicet.dtos.PersonDto;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.company.Company;

public interface RegistrationService {

    UserDto getPersonByUser(String email);

    void editPersonDetails(PersonDto person);

    UserDto registerNewUser(ApplicationUser applicationUser) throws PersistenceException;

    UserDto changePassword(ApplicationUser applicationUser) throws PersistenceException;
    
    CompanyDto getCompanyByName(String name);

    CompanyDto registerNewCompany(Company company) throws PersistenceException;

    CompanyDto editCompany(Company company);
}

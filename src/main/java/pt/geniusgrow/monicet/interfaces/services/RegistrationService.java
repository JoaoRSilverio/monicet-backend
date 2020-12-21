package pt.geniusgrow.monicet.interfaces.services;

import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.models.application.ApplicationUser;

import javax.persistence.PersistenceException;

public interface RegistrationService {
    UserDto registerNewUser(ApplicationUser applicationUser) throws PersistenceException;
}

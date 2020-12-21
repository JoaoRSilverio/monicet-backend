package pt.geniusgrow.monicet.interfaces.repositories;

import pt.geniusgrow.monicet.models.application.ApplicationUser;

import javax.persistence.PersistenceException;

public interface UserRepository  {
    ApplicationUser getUser(Long id);
    ApplicationUser getUserByEmail(String email) ;
    Long saveUser(ApplicationUser applicationUser) throws PersistenceException;
}

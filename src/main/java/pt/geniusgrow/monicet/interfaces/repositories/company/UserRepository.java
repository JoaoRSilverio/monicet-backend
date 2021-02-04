package pt.geniusgrow.monicet.interfaces.repositories.company;

import java.util.Collection;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.ApplicationUser;

public interface UserRepository  {

    Collection<ApplicationUser> getAll();

    ApplicationUser getUser(Long id);

    ApplicationUser getUserByEmail(String email) ;

    Boolean deleteUser(Long id);

    Long saveUser(ApplicationUser applicationUser) throws PersistenceException;
}

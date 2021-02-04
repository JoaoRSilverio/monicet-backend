package pt.geniusgrow.monicet.repositories;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import io.ebean.EbeanServer;
import pt.geniusgrow.monicet.interfaces.repositories.company.UserRepository;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.models.common.ERoles;

@Repository
public class UserRepo extends BeanRepository<Long, ApplicationUser> implements UserRepository {
    public UserRepo(EbeanServer server) {
        super(ApplicationUser.class, server);
    }

    @Override
    public ApplicationUser getUser(Long id) {
        ApplicationUser applicationUser = this.server.find(ApplicationUser.class, id);
        return applicationUser;
    }

    @Override
    public ApplicationUser getUserByEmail(String email) {
        ApplicationUser applicationUser = this.server.find(ApplicationUser.class).where().eq("email", email).findOne();
        return applicationUser;
    }

    public Long saveUser(ApplicationUser applicationUser) throws PersistenceException {
        updateRoles(applicationUser.getPerson());
        this.server.save(applicationUser);
        if (applicationUser.getId() != null) {
            return applicationUser.getId();
        }
        throw new PersistenceException("couldnt save");
    }

    private void updateRoles(Person person) {
        if(person.getSkipperCompanies().isEmpty()) {
            person.getUser().removeRole(ERoles.SKIPPER);
        }else {
            person.getUser().addRole(ERoles.SKIPPER);
        }
        
        if(person.getGuideCompanies().isEmpty()) {
            person.getUser().removeRole(ERoles.GUIDE);
        }else {
            person.getUser().addRole(ERoles.GUIDE);
        }

        if(person.getWatchmanCompanies().isEmpty()) {
            person.getUser().removeRole(ERoles.WATCHMAN);
        }else {
            person.getUser().addRole(ERoles.WATCHMAN);
        }
    }

    @Override
    public Collection<ApplicationUser> getAll() {
        return this.server.find(ApplicationUser.class).findList();
    } 

    @Override
    public Boolean deleteUser(Long id) {
        return this.server.delete(ApplicationUser.class, id) == 0;
    }
}

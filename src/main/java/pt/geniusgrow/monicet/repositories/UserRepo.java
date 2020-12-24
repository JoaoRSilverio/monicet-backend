package pt.geniusgrow.monicet.repositories;

import io.ebean.EbeanServer;
import org.springframework.stereotype.Repository;
import pt.geniusgrow.monicet.interfaces.repositories.UserRepository;
import pt.geniusgrow.monicet.models.application.ApplicationUser;

import javax.persistence.PersistenceException;

@Repository
public class UserRepo extends BeanRepository<Long, ApplicationUser> implements UserRepository {
    public UserRepo( EbeanServer server) {
        super(ApplicationUser.class, server);
    }

    @Override
    public ApplicationUser getUser(Long id) {
        ApplicationUser applicationUser = this.server.find(ApplicationUser.class,id);
        return applicationUser;
    }

    @Override
    public ApplicationUser getUserByEmail(String email) {
       ApplicationUser applicationUser = this.server
               .find(ApplicationUser.class)
               .where()
               .eq("email",email)
               .findOne();
       return applicationUser;
    }

    public Long saveUser(ApplicationUser applicationUser) throws PersistenceException {
        this.server.save(applicationUser);
        if(applicationUser.getId() != null){
            return applicationUser.getId();
        }
        throw new PersistenceException("couldnt save");
    }
}

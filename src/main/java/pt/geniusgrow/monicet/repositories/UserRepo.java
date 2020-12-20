package pt.geniusgrow.monicet.repositories;

import io.ebean.EbeanServer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pt.geniusgrow.monicet.interfaces.repositories.UserRepository;
import pt.geniusgrow.monicet.models.User;
@Repository
public class UserRepo extends BeanRepository<Long, User> implements UserRepository {
    public UserRepo( EbeanServer server) {
        super(User.class, server);
    }

    @Override
    public User getUser(Long id) {
        User user = this.server.find(User.class,id);
        return user;
    }
    public Long saveUser(User user) throws Exception{
        this.server.save(user);
        if(user.getId() != null){
            return user.getId();
        }
        throw new Exception("coulnt save");
    }
}

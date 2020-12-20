package pt.geniusgrow.monicet.interfaces.repositories;

import pt.geniusgrow.monicet.models.User;

public interface UserRepository  {
    User getUser(Long id);
    Long saveUser(User user) throws Exception;
}

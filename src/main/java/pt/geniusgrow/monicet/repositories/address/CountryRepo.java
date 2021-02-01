package pt.geniusgrow.monicet.repositories.address;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import io.ebean.EbeanServer;
import pt.geniusgrow.monicet.interfaces.repositories.CountryRepository;
import pt.geniusgrow.monicet.models.application.address.Country;
import pt.geniusgrow.monicet.repositories.BeanRepository;

@Repository
public class CountryRepo extends BeanRepository<Long, Country> implements CountryRepository {
    public CountryRepo(EbeanServer server) {
        super(Country.class, server); 
    }

    @Override
    public Country getUser(Long id) {
        Country applicationUser = this.server.find(Country.class,id);
        return applicationUser;
    }

    @Override
    public Country getUserByEmail(String email) {
        Country applicationUser = this.server
               .find(Country.class)
               .where()
               .eq("email",email)
               .findOne();
       return applicationUser;
    }

    public Long saveCountry(Country applicationUser) throws PersistenceException {
        this.server.save(applicationUser);
        if(applicationUser.getId() != null){
            return applicationUser.getId();
        }
        throw new PersistenceException("couldnt save");
    }
}

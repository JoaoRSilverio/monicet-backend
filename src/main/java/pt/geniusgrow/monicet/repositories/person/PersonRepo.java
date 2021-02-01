package pt.geniusgrow.monicet.repositories.person;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ebean.EbeanServer;
import pt.geniusgrow.monicet.interfaces.repositories.PersonRepository;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.models.common.ERoles;
import pt.geniusgrow.monicet.repositories.BeanRepository;
import pt.geniusgrow.monicet.repositories.UserRepo;

@Repository
public class PersonRepo extends BeanRepository<Long, Person> implements PersonRepository {
    
    @Autowired
    private UserRepo userRepo;
    
    public PersonRepo(EbeanServer server) {
        super(Person.class, server);
    }

    @Override
    public Person getPerson(Long id) {
        Person person = this.server.find(Person.class,id);
        return person;
    }

    @Override
    public Long savePerson(Person person) throws PersistenceException {
        updateRoles(person);
        this.server.save(person);
        return person.getId();
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
        userRepo.save(person.getUser());
    }

}

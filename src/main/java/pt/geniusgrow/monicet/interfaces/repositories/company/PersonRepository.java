package pt.geniusgrow.monicet.interfaces.repositories.company;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.company.Person;

public interface PersonRepository {
   
    Person getPerson(Long id);

    Long savePerson(Person person) throws PersistenceException;
    
}

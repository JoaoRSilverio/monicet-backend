package pt.geniusgrow.monicet.interfaces.repositories;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.address.Country;

public interface CountryRepository {
    Country getUser(Long id);
    Country getUserByEmail(String email) ;
    Long saveCountry(Country country) throws PersistenceException;
}

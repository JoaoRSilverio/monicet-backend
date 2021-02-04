package pt.geniusgrow.monicet.interfaces.repositories.company;

import java.util.Collection;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.company.Boat;

public interface BoatRepository {
   
    Collection<Boat> getAllBoat();

    Boat getBoat(Long id);

    Collection<Boat> getBoatByCompany(Long companyId);

    Boolean deleteBoat(Long id);

    Long saveBoat(Boat boat) throws PersistenceException;
}

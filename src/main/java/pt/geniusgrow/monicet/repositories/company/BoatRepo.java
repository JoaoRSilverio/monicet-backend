package pt.geniusgrow.monicet.repositories.company;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import io.ebean.EbeanServer;
import pt.geniusgrow.monicet.interfaces.repositories.company.BoatRepository;
import pt.geniusgrow.monicet.models.application.company.Boat;
import pt.geniusgrow.monicet.repositories.BeanRepository;

@Repository
public class BoatRepo extends BeanRepository<Long, Boat> implements BoatRepository {

    public BoatRepo(EbeanServer server) {
        super(Boat.class, server);
    }

    @Override
    public Long saveBoat(Boat boat) throws PersistenceException {
        this.server.save(boat);
        return boat.getId();
    }

    @Override
    public Boat getBoat(Long id) {
        return this.server.find(Boat.class, id);
    }

    @Override
    public Collection<Boat> getBoatByCompany(Long companyId) {
        return this.server.find(Boat.class).where().eq("company_id", companyId).findList();
    }

    @Override
    public Collection<Boat> getAllBoat() {
        return this.server.find(Boat.class).findList();
    }

    @Override
    public Boolean deleteBoat(Long id) {
        return this.server.delete(Boat.class, id) == 0;
    }

}

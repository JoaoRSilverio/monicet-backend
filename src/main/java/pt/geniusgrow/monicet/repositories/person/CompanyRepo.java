package pt.geniusgrow.monicet.repositories.person;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import io.ebean.EbeanServer;
import pt.geniusgrow.monicet.interfaces.repositories.CompanyRepository;
import pt.geniusgrow.monicet.models.application.company.Company;
import pt.geniusgrow.monicet.repositories.BeanRepository;

@Repository
public class CompanyRepo extends BeanRepository<Long, Company> implements CompanyRepository {
    public CompanyRepo(EbeanServer server) {
        super(Company.class, server);
    }

    @Override
    public Long saveCompany(Company company) throws PersistenceException {
        this.server.save(company);
        return company.getId();
    }

    @Override
    public Company getCompany(Long id) {
        return this.server.find(Company.class, id);
    }

    @Override
    public Company getCompanyByName(String name) {
        return this.server.find(Company.class).where()
        .eq("name",name)
        .findOne();
    }

    

}

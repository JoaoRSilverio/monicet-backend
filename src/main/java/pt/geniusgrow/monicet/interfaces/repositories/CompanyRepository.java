package pt.geniusgrow.monicet.interfaces.repositories;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.company.Company;

public interface CompanyRepository {
   
    Company getCompany(Long id);

    Company getCompanyByName(String name);

    Long saveCompany(Company company) throws PersistenceException;
}

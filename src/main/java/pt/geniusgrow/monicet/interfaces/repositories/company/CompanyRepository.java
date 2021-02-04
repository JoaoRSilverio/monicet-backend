package pt.geniusgrow.monicet.interfaces.repositories.company;

import java.util.Collection;

import javax.persistence.PersistenceException;

import pt.geniusgrow.monicet.models.application.company.Company;

public interface CompanyRepository {
   
    Collection<Company> getAllCompanies();

    Company getCompany(Long id);

    Company getCompanyByName(String name);

    Boolean deleteCompany(Long id);

    Long saveCompany(Company company) throws PersistenceException;
}

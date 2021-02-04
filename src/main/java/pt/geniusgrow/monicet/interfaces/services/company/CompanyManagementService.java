package pt.geniusgrow.monicet.interfaces.services.company;

import java.util.Set;

import pt.geniusgrow.monicet.dtos.entities.company.BoatDto;
import pt.geniusgrow.monicet.dtos.entities.company.CompanyDto;
import pt.geniusgrow.monicet.dtos.entities.company.UserDto;


public interface CompanyManagementService {

    Set<CompanyDto> findAllCompany();

    CompanyDto findCompanyByName(String name);

    CompanyDto findCompanyById(String id);

    boolean createCompany(CompanyDto company);

    boolean updateCompany(CompanyDto company);

    boolean deleteCompany(CompanyDto company);

    Set<BoatDto> findBoatsByCompany(String companyId);

    BoatDto findBoatById(String Id);

    boolean createBoat(CompanyDto company, BoatDto boat);

    boolean updateBoat(BoatDto boat);

    boolean deleteBoat(BoatDto boat);

    Set<UserDto> findAllPerson();

    UserDto findPersonByEmail(String email);

    boolean createPerson(UserDto user);

    boolean updatePerson(UserDto user);

    boolean deletePerson(UserDto user);

}

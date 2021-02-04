package pt.geniusgrow.monicet.services.company;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt.geniusgrow.monicet.dtos.entities.company.BoatDto;
import pt.geniusgrow.monicet.dtos.entities.company.CompanyDto;
import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.interfaces.repositories.company.BoatRepository;
import pt.geniusgrow.monicet.interfaces.repositories.company.CompanyRepository;
import pt.geniusgrow.monicet.interfaces.repositories.company.UserRepository;
import pt.geniusgrow.monicet.interfaces.services.company.CompanyManagementService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.Role;
import pt.geniusgrow.monicet.models.application.company.Boat;
import pt.geniusgrow.monicet.models.application.company.Company;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.models.common.ERoles;

@Service
public class CompanyManagementServiceImpl implements CompanyManagementService {

    @Autowired
    private CompanyRepository companyRepo;

    @Autowired
    private BoatRepository boatRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Set<CompanyDto> findAllCompany() {
        return companyRepo.getAllCompanies().stream().map(c -> c.getDto()).collect(Collectors.toSet());
    }

    @Override
    public CompanyDto findCompanyByName(String name) {
        return Optional.ofNullable(companyRepo.getCompanyByName(name)).map(c -> c.getDto()).orElse(null);
    }

    @Override
    public CompanyDto findCompanyById(String id) {
        return Optional.ofNullable(companyRepo.getCompany(Long.valueOf(id))).map(c -> c.getDto()).orElse(null);
    }

    @Override
    public boolean createCompany(CompanyDto dto) {
        Company company = new Company(dto.getName(), dto.getEmail(), dto.getAcronym(), dto.getPhone(), dto.getMobile(),
                dto.getFax(), dto.getObservations());
        companyRepo.saveCompany(company);
        return true;
    }

    @Override
    public boolean updateCompany(CompanyDto dto) {
        Company company = companyRepo.getCompany(Long.valueOf(dto.getId()));
        if (company == null) {
            throw new IllegalArgumentException("Company not found for the given id: " + dto.getId());
        }
        company.edit(dto);
        companyRepo.saveCompany(company);
        return true;
    }

    @Override
    public boolean deleteCompany(CompanyDto dto) {
        Company company = companyRepo.getCompany(Long.valueOf(dto.getId()));
        if (company == null) {
            throw new IllegalArgumentException("Company not found for the given id: " + dto.getId());
        }

        return companyRepo.deleteCompany(company.getId());
    }

    @Override
    public Set<BoatDto> findBoatsByCompany(String companyId) {
        return boatRepo.getBoatByCompany(Long.valueOf(companyId)).stream().map(b -> b.getDto())
                .collect(Collectors.toSet());
    }

    @Override
    public BoatDto findBoatById(String id) {
        return Optional.ofNullable(boatRepo.getBoat(Long.valueOf(id))).map(b -> b.getDto()).orElse(null);
    }

    @Override
    public boolean createBoat(CompanyDto company, BoatDto dto) {
        Boat boat = new Boat();
        boat.edit(dto);
        boat.setCompany(companyRepo.getCompany(Long.valueOf(company.getId())));

        boatRepo.saveBoat(boat);
        return true;
    }

    @Override
    public boolean updateBoat(BoatDto dto) {
        Boat boat = boatRepo.getBoat(Long.valueOf(dto.getId()));
        if (boat == null) {
            throw new IllegalArgumentException("Boat not found for the given id: " + dto.getId());
        }
        boat.edit(dto);

        boatRepo.saveBoat(boat);
        return true;
    }

    @Override
    public boolean deleteBoat(BoatDto dto) {
        Boat boat = boatRepo.getBoat(Long.valueOf(dto.getId()));
        if (boat == null) {
            throw new IllegalArgumentException("Boat not found for the given id: " + dto.getId());
        }

        return boatRepo.deleteBoat(boat.getId());
    }

    @Override
    public Set<UserDto> findAllPerson() {
        return userRepo.getAll().stream().map(u -> u.getDto()).collect(Collectors.toSet());
    }

    @Override
    public UserDto findPersonByEmail(String email) {
        return Optional.ofNullable(userRepo.getUserByEmail(email)).map(u -> u.getDto()).orElse(null);
    }

    @Override
    public boolean createPerson(UserDto dto) {
        ApplicationUser user = userRepo.getUserByEmail(dto.getEmail());
        if (user != null) {
            throw new IllegalArgumentException("Já existe um user com esse email!");
        }

        Set<Role> roles = new HashSet<>();
        Role userRole = new Role(ERoles.USER);
        roles.add(userRole);
        final Person person = new Person();
        final ApplicationUser newUser = new ApplicationUser(dto.getEmail(), dto.getPassword(), person, roles);
        person.setUser(newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        userRepo.saveUser(newUser);

        return true;
    }

    @Override
    public boolean updatePerson(UserDto dto) {
        ApplicationUser user =  userRepo.getUserByEmail(dto.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("Não existe user com esse email!");
        }
        user.edit(dto);

        userRepo.saveUser(user);

        return true;
    }

    @Override
    public boolean deletePerson(UserDto dto) {
        ApplicationUser user =  userRepo.getUserByEmail(dto.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("Não existe user com esse email: " + dto.getEmail());
        }

        return userRepo.deleteUser(user.getId());
    }

}

package pt.geniusgrow.monicet.controllers.web.autenticated.company;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.controllers.web.AbstractEntityController;
import pt.geniusgrow.monicet.dtos.entities.company.CompanyDto;
import pt.geniusgrow.monicet.interfaces.services.company.CompanyManagementService;

@RestController
@RequestMapping(value = Routes.COMPANY_CONTROLLER)
public class CompanyController extends AbstractEntityController {

    @Autowired
    private CompanyManagementService service;

    @RequestMapping(method = RequestMethod.GET, value = Routes.SEARCH)
    public Set<CompanyDto> search() {
        try {
            return service.findAllCompany();
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível obter a lista das empresas!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.CREATE)
    public Boolean create(@RequestBody CompanyDto company) {
        try {
            return service.createCompany(company);
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível criar uma nova empresa!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.UPDATE)
    public Boolean update(@PathVariable("id") String companyId, @RequestBody CompanyDto company) {
        try {
            if (service.findCompanyById(companyId) != null) {
                return service.updateCompany(company);
            }

            throw new IllegalArgumentException("Não existe uma empresa com esse id!");
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível atualizar a informação da empresa!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.DELETE)
    public Boolean delete(@PathVariable("id") String companyId) {
        try {
            CompanyDto company = service.findCompanyById(companyId);
            if (company != null) {
                return service.deleteCompany(company);
            }

            throw new IllegalArgumentException("Não existe uma empresa com esse id!");
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível apagar a empresa!");
        }
    }

}

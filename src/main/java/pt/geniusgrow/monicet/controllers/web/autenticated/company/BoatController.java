package pt.geniusgrow.monicet.controllers.web.autenticated.company;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.entities.company.BoatDto;
import pt.geniusgrow.monicet.dtos.entities.company.CompanyDto;
import pt.geniusgrow.monicet.interfaces.services.company.CompanyManagementService;

@RestController
@RequestMapping(value = Routes.BOAT_CONTROLLER)
public class BoatController {

    @Autowired
    private CompanyManagementService service;

    @RequestMapping(method = RequestMethod.GET, value = Routes.SEARCH)
    public Set<BoatDto> search(@PathVariable("companyId") String companyId) {
        try {
            return service.findBoatsByCompany(companyId);
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível obter a lista dos barcos!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.CREATE)
    public Boolean create(@PathVariable("companyId") String companyId, @RequestBody BoatDto boat) {
        try {
            CompanyDto company = service.findCompanyById(companyId);
            if (company == null) {
                throw new IllegalArgumentException("Não existe uma empresa com esse id!");
            }
            return service.createBoat(company, boat);
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível criar um novo barco!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.UPDATE)
    public Boolean update(@PathVariable("companyId") String companyId, @PathVariable("id") String boatId,
            @RequestBody BoatDto boat) {
        try {
            if (service.findBoatById(companyId) != null) {
                return service.updateBoat(boat);
            }

            throw new IllegalArgumentException("Não existe um barco com esse id!");
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível atualizar a info do barco!");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.DELETE)
    public Boolean delete(@PathVariable("companyId") String companyId, @PathVariable("id") String boatId) {
        try {
            BoatDto boat = service.findBoatById(boatId);
            if (boat != null) {
                return service.deleteBoat(boat);
            }

            throw new IllegalArgumentException("Não existe um barco com esse id!");
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível apagar o barco!");
        }
    }

}

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
import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.interfaces.services.company.CompanyManagementService;

@RestController
@RequestMapping(value = Routes.PERSON_CONTROLLER)
public class PersonController extends AbstractEntityController {

    @Autowired
    private CompanyManagementService service;

    @RequestMapping(method = RequestMethod.GET, value = Routes.SEARCH)
    public Set<UserDto> search() {
        try {
            return service.findAllPerson();
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível obter a lista das pessoas!");
        }
    }

    @RequestMapping(value = Routes.CREATE)
    public Boolean create(@RequestBody UserDto user) {
        //TODO: is possible to create a person in backoffice. how to manage the first authentication
        throw new RuntimeException("Deve criar um novo utilizador usando a página de registar!");
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.UPDATE)
    public Boolean update(@PathVariable("id") String userEmail, @RequestBody UserDto user) {
        try {
            if (service.findPersonByEmail(userEmail) != null) {
                user.setEmail(userEmail);
                return service.updatePerson(user);
            }

            throw new IllegalArgumentException("Não existe uma pessoa com esse email!");
        } catch (Throwable t) {
            t.printStackTrace();
            throw new RuntimeException("Não foi possível atualizar a informação da pessoa!", t);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = Routes.DELETE)
    public Boolean delete(@PathVariable("id") String userEmail) {
        try {
            UserDto user = service.findPersonByEmail(userEmail);
            if (user != null) {
                return service.deletePerson(user);
            }

            throw new IllegalArgumentException("Não existe uma pessoa com esse email!");
        } catch (Throwable t) {
            // TODO:
            throw new RuntimeException("Não foi possível apagar a pessoa!");
        }
    }
}

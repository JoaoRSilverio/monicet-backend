package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.requests.PersonRequestDto;
import pt.geniusgrow.monicet.dtos.responses.OperationDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.company.Person;

@RestController
@RequestMapping(value = Routes.PERSON_CONTROLLER)
public class CompanyController extends AbstractSecuredController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping( method = RequestMethod.POST ,
    value = "/edit")
    @Secured("ADMIN")
    public OperationDto securedEndpoint(@RequestBody PersonRequestDto personDto) {
        try {
            Person person = registrationService.getPersonByUser(personDto.getEmail());
            person.init(personDto);
            person.setCompany(registrationService.getCompanyByName(personDto.getCompanyName()));
            
            registrationService.editPersonDetails(person);
        }catch(Throwable t) {
            return new OperationDto(t.getLocalizedMessage(), Boolean.FALSE); 
        }

        return new OperationDto(Boolean.TRUE);
    }
}

package pt.geniusgrow.monicet.controllers.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.requests.TestRequestDto;

@RestController
public class TestSecuredController extends AbstractSecuredController {
    @RequestMapping( method = RequestMethod.POST ,
    value = Routes.TESTROUTE)
    @Secured("ADMIN")
    public String securedEndpoint(@RequestBody TestRequestDto testRequestDto){
        String gotText = testRequestDto.getSomeText();
        return gotText;
    }
}

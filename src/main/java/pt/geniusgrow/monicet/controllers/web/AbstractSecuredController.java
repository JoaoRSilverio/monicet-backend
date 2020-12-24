package pt.geniusgrow.monicet.controllers.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import pt.geniusgrow.monicet.security.ERoles;

@RestController
//@Secured("USER")
public abstract class AbstractSecuredController {
}

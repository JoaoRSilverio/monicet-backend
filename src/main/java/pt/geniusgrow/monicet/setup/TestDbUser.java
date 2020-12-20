package pt.geniusgrow.monicet.setup;

import io.ebean.config.CurrentUserProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Testing")
@Component("CurrentUser")
public class TestDbUser implements CurrentUserProvider {
    @Override
    public Object currentUser() {
        return "monicet-backend";
    }
}

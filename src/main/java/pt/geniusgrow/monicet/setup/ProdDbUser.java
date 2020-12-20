package pt.geniusgrow.monicet.setup;

import io.ebean.config.CurrentUserProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Production")
@Component("CurrentUser")
public class ProdDbUser implements CurrentUserProvider {
        @Override
        public Object currentUser() {
            return "production";
        }

}

package pt.geniusgrow.monicet.singletons;

import javax.sql.DataSource;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

  @Qualifier("CurrentUser")
  CurrentUserProvider currentUser;

    @Override
    public EbeanServer getObject() throws Exception {

        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.setCurrentUserProvider(currentUser);
        config.loadFromProperties();

        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

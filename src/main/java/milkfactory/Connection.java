package milkfactory;

import lombok.extern.java.Log;
import milkfactory.receivingdept.models.Order;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class Connection {

    private SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory() {
        return sessionFactory == null ? getConnectionProvider() : sessionFactory;
    }

    @Bean(name = "postgres")
    public SessionFactory getConnectionProvider() {
        log.info("......Bootstrapping hibernate connection.......");
        log.warning("Could not initiate twice");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Order.class)
                .buildMetadata()
                .buildSessionFactory();
        this.sessionFactory = sessionFactory;
        return this.sessionFactory;
    }

    private void destroyConnection() {
        log.warning("bye-bye connection");
    }
}

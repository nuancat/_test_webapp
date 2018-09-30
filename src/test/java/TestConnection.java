import milkfactory.Connection;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestConnection {


    @Test
    void testConnect() {
        Connection c = new Connection();
        SessionFactory sessionFactory = c.getSessionFactory();
        if (sessionFactory == null) {
            fail("not Connected");
        }
    }
}

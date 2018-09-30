import configurationBeans.WebEngine;
import milkfactory.Connection;
import milkfactory.receivingdept.controller.MilkReceiveController;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();

        registeringControllers(ac);

        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }

    private void registeringControllers(AnnotationConfigWebApplicationContext ac) {
        ac.register(MilkReceiveController.class);
        ac.register(Connection.class);
        ac.register(WebEngine.class);
        ac.refresh();
    }

}

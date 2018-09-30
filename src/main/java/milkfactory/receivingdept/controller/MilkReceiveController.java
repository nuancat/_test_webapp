package milkfactory.receivingdept.controller;

import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Log
@Controller
public class MilkReceiveController {

    @Autowired
    @Qualifier("postgres")
    SessionFactory sessionFactory;

    @RequestMapping(path = "/ooo")
    public void simpleResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info(request.getRequestURI());
        Session session = sessionFactory.openSession();
        PrintWriter writer = response.getWriter();
        writer.println("101 Spring");
        writer.flush();
        response.setStatus(HttpServletResponse.SC_OK);

    }

}

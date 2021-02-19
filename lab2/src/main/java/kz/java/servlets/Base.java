package kz.java.servlets;

import kz.java.DataBase;
import kz.java.user;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.atomic.AtomicReference;

import static kz.java.user.NAME.Adam;
import static kz.java.user.NAME.Sagi;

public class Base implements ServletContextListener {

    private AtomicReference<DataBase> data;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        data = new AtomicReference<>(new DataBase());
        data.get().add(new user(1, "Sagi", "1234", Sagi));
        data.get().add(new user(2, "Adam", "1234", Adam));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("data", data);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        data = null;
    }
}

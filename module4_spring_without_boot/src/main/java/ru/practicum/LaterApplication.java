package ru.practicum;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LaterApplication {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setSilent(true);
        tomcat.getConnector().setPort(PORT);

        // то самое "приложение" или "контекст" с пустым путём
        Context tomcatContext = tomcat.addContext("", null);

        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.scan("ru.practicum");
        applicationContext.setServletContext(tomcatContext.getServletContext());
        applicationContext.refresh();

        // класс Wrapper позволяет задать дополнительные настройки для сервлета
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        Wrapper dispatcherWrapper =
                Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);
        dispatcherWrapper.addMapping("/");
        dispatcherWrapper.setLoadOnStartup(1);

        tomcat.start();
    }
}

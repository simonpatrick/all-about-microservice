package io.hedwig.booklib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by patrick on 15/11/11.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer{
    @Autowired
    private Environment environment;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if(!environment.acceptsProfiles(Profiles.PRODUCTION)){
            initH2Console(servletContext);
        }
    }

    private void initH2Console(ServletContext servletContext) {
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext
                .addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2/*");
        h2ConsoleServlet.setInitParameter("-properties", "src/main/resources");
        h2ConsoleServlet.setLoadOnStartup(1);
    }
}

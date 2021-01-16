package takar;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/authentication/connexion").setViewName("formConnexion");
        //registry.addViewController("/authentication/welcome").setViewName("welcome");
        //registry.addViewController("/authentication/connexion").setViewName("login");
    }
}

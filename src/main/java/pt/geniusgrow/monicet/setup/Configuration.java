package pt.geniusgrow.monicet.setup;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/{spring:\\w+}")
                    .setViewName("forward:/");
            registry.addViewController("/**/{spring:\\w+}")
                    .setViewName("forward:/");
            registry.addViewController("/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}")
                    .setViewName("forward:/");
        }


}

package pt.geniusgrow.monicet.setup;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultWebMvcConfigurer implements WebMvcConfigurer {
 
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

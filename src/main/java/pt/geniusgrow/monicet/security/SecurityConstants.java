package pt.geniusgrow.monicet.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:development.properties")
public class SecurityConstants {
    @Value("${app.api.auth.secret}")
    public static String SECRET;
    @Value("${app.api.auth.exp}")
    public static long EXPIRATION_TIME;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String HEADER_STRING = "Authorization";
}

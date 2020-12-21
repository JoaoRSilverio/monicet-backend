package pt.geniusgrow.monicet.security;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
    @Value("${app.api.auth.secret}")
    public static String SECRET;
    @Value("{app.api.auth.exp}")
    public static String EXPIRATION_TIME;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String HEADER_STRING = "Authorization";
}

package pt.geniusgrow.monicet.security;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:development.properties")
public class JWTUtil {

    private String generateJwtToken(String email, long exp) {
        // String testSec = env.getProperty("app.api.auth.secret");
        String secret = "harcodedSecretBecauseICantInjectStuffYet";
        String token = JWT.create().withSubject(email).withExpiresAt(new Date(System.currentTimeMillis() + exp))
                .sign(Algorithm.HMAC512(secret.getBytes()));
        return token;
    }

    public String generateAccessToken(String email) {
        return generateJwtToken(email, 180000);
    }

    public String generateRefreshToken(String email) {
        return generateJwtToken(email, 180000000);
    }
}

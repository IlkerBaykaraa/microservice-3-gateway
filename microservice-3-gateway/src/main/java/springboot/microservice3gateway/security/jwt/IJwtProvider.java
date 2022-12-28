package springboot.microservice3gateway.security.jwt;

import org.springframework.security.core.Authentication;
import springboot.microservice3gateway.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}

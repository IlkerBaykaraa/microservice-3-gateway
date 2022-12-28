package springboot.microservice3gateway.service;

import springboot.microservice3gateway.model.User;

public interface IAuthenticationService {
    String signInAndReturnJWT(User signInRequest);
}

package springboot.microservice3gateway.service;

import springboot.microservice3gateway.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String userName);

    List<User> findAUserList();
}

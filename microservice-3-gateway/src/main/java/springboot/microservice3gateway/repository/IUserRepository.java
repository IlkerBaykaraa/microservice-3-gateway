package springboot.microservice3gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.microservice3gateway.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);
}

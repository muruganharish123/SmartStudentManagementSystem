package studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
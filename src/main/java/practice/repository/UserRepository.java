package practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
     User findUserByEmail(String email);
     User findUserById(String id);
}

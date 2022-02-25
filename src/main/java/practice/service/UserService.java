package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.entity.User;
import practice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void saveUser(String firstName, String lastName, String email, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }

    public String findIDByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user.getId();
    }

    public User findUserByID(String id) {
        return userRepository.findUserById(id);
    }
}

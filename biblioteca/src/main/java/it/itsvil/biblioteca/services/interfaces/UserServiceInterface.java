package it.itsvil.biblioteca.services.interfaces;

import it.itsvil.biblioteca.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserServiceInterface {
    User save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();

    void deleteUserByEmail(String email);

    User updatePassword(String email, String newPassword);
}

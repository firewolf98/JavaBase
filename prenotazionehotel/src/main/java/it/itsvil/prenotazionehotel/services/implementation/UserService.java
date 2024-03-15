package it.itsvil.prenotazionehotel.services.implementation;

import it.itsvil.prenotazionehotel.model.User;
import it.itsvil.prenotazionehotel.repository.UserRepository;
import it.itsvil.prenotazionehotel.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findById(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserByEmail(String email) {
        userRepository.deleteById(email);
    }

    @Override
    public User updatePassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findById(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(newPassword);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

}

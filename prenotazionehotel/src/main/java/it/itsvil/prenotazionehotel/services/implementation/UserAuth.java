package it.itsvil.prenotazionehotel.services.implementation;

import it.itsvil.prenotazionehotel.model.User;
import it.itsvil.prenotazionehotel.repository.UserRepository;
import it.itsvil.prenotazionehotel.services.interfaces.UserAuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuth implements UserAuthInterface {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        if(email!=null && password!=null && !email.isEmpty() && !password.isEmpty()) {
            User user = userRepository.findByEmail(email);
            if(user!= null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User signin(User user) {
        if(user.getEmail()!= null && user.getPassword()!=null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
            if(userRepository.findByEmail(user.getEmail())!=null) {
                return null;
            }
            User userCreated = userRepository.save(user);
            return userCreated;
        }
        return null;
    }
}

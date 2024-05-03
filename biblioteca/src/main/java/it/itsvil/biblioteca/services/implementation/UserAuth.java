package it.itsvil.biblioteca.services.implementation;

import it.itsvil.biblioteca.model.User;
import it.itsvil.biblioteca.repository.UserRepository;
import it.itsvil.biblioteca.services.interfaces.UserAuthInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAuth implements UserAuthInterface {
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        if(email!=null && password!=null && !email.isEmpty() && !password.isEmpty()) {
            //User user = userRepository.findByEmail(email);
            User user = getUserByEmailAndPassword(email, password);
            if(user!= null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User signin(User user) {
        if(user.getEmail()!= null && user.getPassword()!=null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
            if(getUserByEmailAndPassword(user.getEmail(), user.getPassword())!=null) {
                return null;
            }
            //User userCreated = userRepository.save(user);
            User userCreated = addUser(user.getEmail(), user.getPassword());
            return userCreated;
        }
        return null;
    }

    private Map<String,User> readFromFile() {
        Map<String, User> userMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\users"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String email = parts[0].trim();
                    String password = parts[1].trim();
                    User user = new User(email, password);
                    userMap.put(email, user);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userMap;
    }

    private User getUserByEmailAndPassword(String email, String password) {
        Map<String, User> userMap = readFromFile();
        for (User user : userMap.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private User addUser(String email, String password) {
        Map<String, User> userMap = readFromFile();
        User newUser = new User(email, password);

        if (userMap.containsKey(email)) {
            System.err.println("L'utente con l'email " + email + " esiste già.");
            return null;
        }

        userMap.put(email, newUser);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Utente\\Desktop\\ItSvil\\EserciziJava\\biblioteca\\src\\main\\java\\it\\itsvil\\biblioteca\\fileditest\\users", true))) {

            writer.write(email + "," + password);
            writer.newLine();
            writer.flush();
            return newUser;
        } catch (IOException e) {
            userMap.remove(email);
            e.printStackTrace();
            return null;
        }
    }


}

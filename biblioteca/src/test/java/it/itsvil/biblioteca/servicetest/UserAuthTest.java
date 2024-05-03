package it.itsvil.biblioteca.servicetest;

import it.itsvil.biblioteca.model.User;
import it.itsvil.biblioteca.repository.UserRepository;
import it.itsvil.biblioteca.services.implementation.UserAuth;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAuthTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserAuth userAuth;

    //Testing del Login

    @Test
    public void authValid() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("luca@gmail.com","password");

        assertNotNull(auth);
        assertEquals("luca@gmail.com", auth.getEmail());
    }

    @Test
    public void authNotValidWrongEmail() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("wrongEmail","password");

        assertNull(auth);
    }

    @Test
    public void authNotValidWrongPassword() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("luca@gmail.com","wrongPassword");

        assertNull(auth);
    }

    @Test
    public void authNotValidEmptyEmail() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("","password");

        assertNull(auth);
    }

    @Test
    public void authNotValidEmptyPassowrd() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("luca@gmail.com","");

        assertNull(auth);
    }

    @Test
    public void authNotValidNullEmail() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login(null,"password");

        assertNull(auth);
    }

    @Test
    public void authNotValidNullPassowrd() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User auth = userAuth.login("luca@gmail.com",null);

        assertNull(auth);
    }

    //Testing del Sign in

    @Test
    public void signinValid() {
        User user = new User();
        user.setEmail("luca1@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User("luca1@gmail.com","password"));

        assertNotNull(created);
    }

    @Test
    public void signinEmailAlreadyExist() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User("luca@gmail.com","password"));

        assertNull(created);
    }

    @Test
    public void signinEmailNull() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User(null,"password"));

        assertNull(created);
    }

    @Test
    public void signinPsswordNull() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User("luca@gmail.com",null));

        assertNull(created);
    }

    @Test
    public void signinEmailEmpty() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User("","password"));

        assertNull(created);
    }

    @Test
    public void signinPasswordEmpty() {
        User user = new User();
        user.setEmail("luca@gmail.com");
        user.setPassword("password");

        User created = userAuth.signin(new User("luca@gmail.com",""));

        assertNull(created);
    }
}

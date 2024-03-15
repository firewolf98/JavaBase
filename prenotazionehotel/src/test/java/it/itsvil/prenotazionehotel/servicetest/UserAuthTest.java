package it.itsvil.prenotazionehotel.servicetest;

import it.itsvil.prenotazionehotel.model.User;
import it.itsvil.prenotazionehotel.repository.UserRepository;
import it.itsvil.prenotazionehotel.services.implementation.UserAuth;
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
        user.setEmail("email");
        user.setPassword("password");

        when(userRepository.findByEmail("email")).thenReturn(user);

        User auth = userAuth.login("email","password");

        assertNotNull(auth);
        assertEquals("email", auth.getEmail());
    }

    @Test
    public void authNotValidWrongEmail() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userRepository.findByEmail("wrongEmail")).thenReturn(null);

        User auth = userAuth.login("wrongEmail","password");

        assertNull(auth);
    }

    @Test
    public void authNotValidWrongPassword() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userRepository.findByEmail("email")).thenReturn(user);

        User auth = userAuth.login("email","wrongPassword");

        assertNull(auth);
    }

    @Test
    public void authNotValidEmptyEmail() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User auth = userAuth.login("","password");

        assertNull(auth);
    }

    @Test
    public void authNotValidEmptyPassowrd() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User auth = userAuth.login("username","");

        assertNull(auth);
    }

    @Test
    public void authNotValidNullEmail() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User auth = userAuth.login(null,"password");

        assertNull(auth);
    }

    @Test
    public void authNotValidNullPassowrd() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User auth = userAuth.login("username",null);

        assertNull(auth);
    }

    //Testing del Sign in

    @Test
    public void signinValid() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        User created = userAuth.signin(new User("email","password"));

        assertNotNull(created);
    }

    @Test
    public void signinEmailAlreadyExist() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User created = userAuth.signin(new User("email","password"));

        assertNull(created);
    }

    @Test
    public void signinEmailNull() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User created = userAuth.signin(new User(null,"password"));

        assertNull(created);
    }

    @Test
    public void signinPsswordNull() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User created = userAuth.signin(new User("email",null));

        assertNull(created);
    }

    @Test
    public void signinEmailEmpty() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User created = userAuth.signin(new User("","password"));

        assertNull(created);
    }

    @Test
    public void signinPasswordEmpty() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        User created = userAuth.signin(new User("email",""));

        assertNull(created);
    }
}

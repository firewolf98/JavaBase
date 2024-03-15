package it.itsvil.prenotazionehotel.repository;

import it.itsvil.prenotazionehotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String>{

    User findByEmail(String email);
}

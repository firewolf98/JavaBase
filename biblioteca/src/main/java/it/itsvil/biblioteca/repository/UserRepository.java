package it.itsvil.biblioteca.repository;

import it.itsvil.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String>{

    User findByEmail(String email);
}

package it.itsvil.springcorsi.repository;

import it.itsvil.springcorsi.model.StudenteBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<StudenteBean,Long> {

}

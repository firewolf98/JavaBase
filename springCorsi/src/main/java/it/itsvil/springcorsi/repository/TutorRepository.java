package it.itsvil.springcorsi.repository;

import it.itsvil.springcorsi.model.TutorBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorBean,Long> {
}

package it.itsvil.springcorsi.repository;

import it.itsvil.springcorsi.model.CorsoBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoRepository extends JpaRepository<CorsoBean,Long> {
}

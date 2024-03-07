package it.itsvil.springcorsi.repository;

import it.itsvil.springcorsi.model.CorsoStudenteBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorsoStudenteRepository extends JpaRepository<CorsoStudenteBean,Long> {
}

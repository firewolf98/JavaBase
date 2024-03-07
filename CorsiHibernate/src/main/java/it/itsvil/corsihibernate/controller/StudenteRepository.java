package it.itsvil.corsihibernate.controller;

import it.itsvil.corsihibernate.model.StudenteBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<StudenteBean,Long> {

}

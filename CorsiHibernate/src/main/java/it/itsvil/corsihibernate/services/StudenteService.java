package it.itsvil.corsihibernate.services;

import it.itsvil.corsihibernate.controller.StudenteRepository;
import it.itsvil.corsihibernate.model.StudenteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class StudenteService {


    private StudenteRepository studenteRepository;

    public StudenteBean save(StudenteBean studente) {
        return studenteRepository.save(studente);
    }

    public Optional<StudenteBean> findById(Long id) {
        return studenteRepository.findById(id);
    }

}


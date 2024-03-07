package it.itsvil.springcorsi.services;


import it.itsvil.springcorsi.repository.StudenteRepository;
import it.itsvil.springcorsi.model.StudenteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public StudenteBean save(StudenteBean studente) {
        return studenteRepository.save(studente);
    }

    public Optional<StudenteBean> findById(Long id) {
        return studenteRepository.findById(id);
    }

    public List<StudenteBean> getAllStudenti() {
        return studenteRepository.findAll();
    }

    public void deleteById(Long id) {
        studenteRepository.deleteById(id);
    }

    public StudenteBean updateStudente(Long id, StudenteBean updatedStudente) {
        Optional<StudenteBean> studenteOptional = studenteRepository.findById(id);
        if (studenteOptional.isPresent()) {
            StudenteBean studente = studenteOptional.get();
            studente.setNome(updatedStudente.getNome());
            studente.setCognome(updatedStudente.getCognome());
            return studenteRepository.save(studente);
        } else {
            return null;
        }
    }
}


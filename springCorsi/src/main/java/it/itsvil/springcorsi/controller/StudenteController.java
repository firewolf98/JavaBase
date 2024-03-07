package it.itsvil.springcorsi.controller;

import it.itsvil.springcorsi.model.StudenteBean;
import it.itsvil.springcorsi.services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studenti")
public class StudenteController {

    private final StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @PostMapping
    public ResponseEntity<StudenteBean> createStudente(@RequestBody StudenteBean studente) {
        StudenteBean createdStudente = studenteService.save(studente);
        return new ResponseEntity<>(createdStudente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudenteBean> getStudenteById(@PathVariable Long id) {
        Optional<StudenteBean> studente = studenteService.findById(id);
        return studente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<StudenteBean>> getAllStudenti() {
        List<StudenteBean> studenti = studenteService.getAllStudenti();
        if (studenti.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(studenti, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudente(@PathVariable Long id) {
        Optional<StudenteBean> studenteOptional = studenteService.findById(id);
        if (studenteOptional.isPresent()) {
            studenteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudenteBean> updateStudente(@PathVariable Long id, @RequestBody StudenteBean updatedStudente) {
        StudenteBean studente = studenteService.updateStudente(id, updatedStudente);
        if (studente != null) {
            return new ResponseEntity<>(studente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}


package it.itsvil.springcorsi.controller;

import it.itsvil.springcorsi.model.TutorBean;
import it.itsvil.springcorsi.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private final TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<TutorBean> createTutor(@RequestBody TutorBean tutor) {
        TutorBean createdTutor = tutorService.save(tutor);
        return new ResponseEntity<>(createdTutor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorBean> getTutorById(@PathVariable Long id) {
        Optional<TutorBean> tutor = tutorService.findById(id);
        return tutor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TutorBean>> getAllTutor() {
        List<TutorBean> tutors = tutorService.findAllTutor();
        if (tutors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tutors, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        Optional<TutorBean> tutorOptional = tutorService.findById(id);
        if (tutorOptional.isPresent()) {
            tutorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorBean> updateTutor(@PathVariable Long id, @RequestBody TutorBean updatedTutor) {
        TutorBean tutor = tutorService.updateTutor(id, updatedTutor);
        if (tutor != null) {
            return new ResponseEntity<>(tutor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
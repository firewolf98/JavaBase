package it.itsvil.springcorsi.controller;

import it.itsvil.springcorsi.model.CorsoBean;
import it.itsvil.springcorsi.model.TutorBean;
import it.itsvil.springcorsi.services.CorsoService;
import it.itsvil.springcorsi.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/corso")
public class CorsoController {

    private final CorsoService corsoService;
    private final TutorService tutorService;

    @Autowired
    public CorsoController(CorsoService corsoService, TutorService tutorService) {
        this.corsoService = corsoService;
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<CorsoBean> createCorso(@RequestBody Map<String, Object> requestBody) {
        Long tutorId = Long.parseLong(requestBody.get("tutor_id").toString());
        Optional<TutorBean> tutorOptional = tutorService.findById(tutorId);
        TutorBean tutor = tutorOptional.orElse(null);
        CorsoBean corso = new CorsoBean();
        corso.setNome(requestBody.get("nome").toString());
        corso.setDurata(Integer.parseInt(requestBody.get("durata").toString()));
        corso.setTutor(tutor);
        CorsoBean createdCorso = corsoService.save(corso);
        return new ResponseEntity<>(createdCorso, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorsoBean> getCorsoById(@PathVariable Long id) {
        Optional<CorsoBean> corso = corsoService.findById(id);
        return corso.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<CorsoBean>> getAllCorsi() {
        List<CorsoBean> corsi = corsoService.findAllCorsi();
        if (corsi.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(corsi, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorso(@PathVariable Long id) {
        Optional<CorsoBean> corsoOptional = corsoService.findById(id);
        if (corsoOptional.isPresent()) {
            corsoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorsoBean> updateCorso(@PathVariable Long id, @RequestBody CorsoBean updatedCorso) {
        CorsoBean corso = corsoService.updateCorso(id, updatedCorso);
        if (corso != null) {
            return new ResponseEntity<>(corso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

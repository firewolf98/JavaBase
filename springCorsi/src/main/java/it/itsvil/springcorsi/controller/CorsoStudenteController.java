package it.itsvil.springcorsi.controller;

import it.itsvil.springcorsi.model.CorsoBean;
import it.itsvil.springcorsi.model.CorsoStudenteBean;
import it.itsvil.springcorsi.model.StudenteBean;
import it.itsvil.springcorsi.services.CorsoService;
import it.itsvil.springcorsi.services.CorsoStudenteService;
import it.itsvil.springcorsi.services.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/corsostudente")
public class CorsoStudenteController {

    private final CorsoStudenteService corsoStudenteService;
    private final CorsoService corsoService;
    private final StudenteService studenteService;

    @Autowired
    public CorsoStudenteController(CorsoStudenteService corsoStudenteService, CorsoService corsoService, StudenteService studenteService) {
        this.corsoStudenteService = corsoStudenteService;
        this.corsoService = corsoService;
        this.studenteService = studenteService;
    }

    @PostMapping
    public ResponseEntity<CorsoStudenteBean> createCorsoStudente(@RequestBody Map<String, Object> requestBody) {
        CorsoStudenteBean corsoStudente = new CorsoStudenteBean();
        Long corsoId = Long.parseLong(requestBody.get("corso_id").toString());
        Long studenteId = Long.parseLong(requestBody.get("studente_id").toString());
        Optional<CorsoBean> corsoOptional = corsoService.findById(corsoId);
        CorsoBean corso = corsoOptional.orElse(null);
        Optional<StudenteBean> studenteOptional = studenteService.findById(studenteId);
        StudenteBean studente = studenteOptional.orElse(null);
        corsoStudente.setCorso(corso);
        corsoStudente.setStudente(studente);
        CorsoStudenteBean createdCorsoStudente = corsoStudenteService.save(corsoStudente);
        return new ResponseEntity<>(createdCorsoStudente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorsoStudenteBean> getCorsoStudenteById(@PathVariable Long id) {
        Optional<CorsoStudenteBean> corsoStudente = corsoStudenteService.findById(id);
        return corsoStudente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<CorsoStudenteBean>> getAllCorsoStudenti() {
        List<CorsoStudenteBean> corsoStudenti = corsoStudenteService.findAllCorsoStudente();
        if (corsoStudenti.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(corsoStudenti, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorsoStudente(@PathVariable Long id) {
        Optional<CorsoStudenteBean> corsoStudenteOptional = corsoStudenteService.findById(id);
        if (corsoStudenteOptional.isPresent()) {
            corsoStudenteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorsoStudenteBean> updateCorsoStudente(@PathVariable Long id, @RequestBody CorsoStudenteBean updatedCorsoStudente) {
        CorsoStudenteBean corsoStudente = corsoStudenteService.updateCorsoStudente(id, updatedCorsoStudente);
        if (corsoStudente != null) {
            return new ResponseEntity<>(corsoStudente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

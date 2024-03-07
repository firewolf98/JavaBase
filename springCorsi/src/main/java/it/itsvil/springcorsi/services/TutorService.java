package it.itsvil.springcorsi.services;

import it.itsvil.springcorsi.model.TutorBean;
import it.itsvil.springcorsi.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    public TutorBean save(TutorBean tutor) {
        return tutorRepository.save(tutor);
    }

    public Optional<TutorBean> findById(Long id) {
        return tutorRepository.findById(id);
    }

    public List<TutorBean> findAllTutor() {return tutorRepository.findAll();}

    public void deleteById(Long id) { tutorRepository.deleteById(id);}

    public TutorBean updateTutor(Long id, TutorBean updatedTutor) {
        Optional<TutorBean> tutorOptional = tutorRepository.findById(id);
        if (tutorOptional.isPresent()) {
            TutorBean tutor = tutorOptional.get();
            tutor.setNome(updatedTutor.getNome());
            tutor.setCognome(updatedTutor.getCognome());
            tutor.setEmail(updatedTutor.getEmail());
            tutor.setTelefono(updatedTutor.getTelefono());
            return tutorRepository.save(tutor);
        } else {
            return null;
        }
    }
}

package it.itsvil.springcorsi.services;

import it.itsvil.springcorsi.model.CorsoBean;
import it.itsvil.springcorsi.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    public CorsoBean save(CorsoBean corso) {
        return corsoRepository.save(corso);
    }

    public Optional<CorsoBean> findById(Long id) {
        return corsoRepository.findById(id);
    }

    public List<CorsoBean> findAllCorsi() { return corsoRepository.findAll();}

    public void deleteById(Long id) { corsoRepository.deleteById(id);}

    public CorsoBean updateCorso(Long id, CorsoBean updatedCorso) {
        Optional<CorsoBean> corsoOptional = corsoRepository.findById(id);
        if (corsoOptional.isPresent()) {
            CorsoBean corso = corsoOptional.get();
            corso.setNome(updatedCorso.getNome());
            corso.setDurata(updatedCorso.getDurata());
            corso.setStato(updatedCorso.getStato());
            return corsoRepository.save(corso);
        } else {
            return null;
        }
    }
}

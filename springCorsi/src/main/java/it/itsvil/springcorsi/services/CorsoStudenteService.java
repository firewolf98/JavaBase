package it.itsvil.springcorsi.services;

import it.itsvil.springcorsi.model.CorsoStudenteBean;
import it.itsvil.springcorsi.repository.CorsoStudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CorsoStudenteService {

    @Autowired
    private CorsoStudenteRepository corsoStudenteRepository;

    public CorsoStudenteBean save(CorsoStudenteBean corsoStudente) {
        return corsoStudenteRepository.save(corsoStudente);
    }

    public Optional<CorsoStudenteBean> findById(Long id) {
        return corsoStudenteRepository.findById(id);
    }

    public List<CorsoStudenteBean> findAllCorsoStudente() { return corsoStudenteRepository.findAll();}

    public void deleteById(Long id) { corsoStudenteRepository.deleteById(id);}

    public CorsoStudenteBean updateCorsoStudente(Long id, CorsoStudenteBean updatedCorsoStudente) {
        Optional<CorsoStudenteBean> corsoStudenteOptional = corsoStudenteRepository.findById(id);
        if (corsoStudenteOptional.isPresent()) {
            CorsoStudenteBean corsoStudente = corsoStudenteOptional.get();
            corsoStudente.setCorso(updatedCorsoStudente.getCorso());
            corsoStudente.setStudente(updatedCorsoStudente.getStudente());
            return corsoStudenteRepository.save(corsoStudente);
        } else {
            return null;
        }
    }
}

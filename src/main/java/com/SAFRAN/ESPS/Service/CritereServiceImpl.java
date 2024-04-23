package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Critere;
import com.SAFRAN.ESPS.Repository.CritereRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CritereServiceImpl implements CritereService{

    @Autowired
    CritereRepository critereRepository;

    @Override
    public Critere ajouterCritere(Critere critere) {
        return critereRepository.save(critere);
    }

    @Override
    public Critere modifierCritere(Critere critere) {
        return critereRepository.save(critere);
    }

    @Override
    public List<Critere> listCritere() {
        return critereRepository.findByEtatactive(true);
    }

 
     @Override
    public List<Critere> listCritereByOKDId(long id) {
        return critereRepository.findByOkdId(id);
    }
 
    

    @Override
    public void supprimerById(Long id) {
        critereRepository.deleteById(id);

    }
    
     @Override
    public Critere getCritereById(Long id) {
        Optional<Critere> critere = critereRepository.findById(id);

        if(critere.isPresent()) {
            return critere.get();
        }
        return null;
    }

    
}



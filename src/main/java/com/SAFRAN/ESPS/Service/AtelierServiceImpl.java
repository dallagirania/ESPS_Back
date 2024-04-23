package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Atelier;
import com.SAFRAN.ESPS.Repository.AtelierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtelierServiceImpl implements AtelierService{

    @Autowired
    AtelierRepository atelierRepository;

    @Override
    public Atelier ajouterAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    @Override
    public Atelier modifierAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    @Override
    public List<Atelier> listAtelier() {
        return atelierRepository.findByEtatactive(true);
    }

 
     @Override
    public List<Atelier> listAtelierByActiviteId(long id) {
        return atelierRepository.findByEtatactiveAndActiviteId(true,id);
    }
 

    @Override
    public void supprimerById(Long id) {
        atelierRepository.deleteById(id);

    }
    
     @Override
    public Atelier getAtelierById(Long id) {
        Optional<Atelier> atelier = atelierRepository.findById(id);

        if(atelier.isPresent()) {
            return atelier.get();
        }
        return null;
    }

    
}

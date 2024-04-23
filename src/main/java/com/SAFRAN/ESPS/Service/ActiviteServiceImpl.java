package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Activite;
import com.SAFRAN.ESPS.Repository.ActiviteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActiviteServiceImpl implements ActiviteService{

    @Autowired
    ActiviteRepository activiteRepository;

    @Override
    public Activite ajouterActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    @Override
    public Activite modifierActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    @Override
    public List<Activite> listActivite() {
        return activiteRepository.findByEtatactive(true);
    }
    
    @Override
    public List<Activite> listActiviteByUniteId(long id) {
        return activiteRepository.findByEtatactiveAndUniteId(true,id);
    }
 
    

    @Override
    public void supprimerById(Long id) {
        activiteRepository.deleteById(id);

    }
    
     @Override
    public Activite getActiviteById(Long id) {
        Optional<Activite> activite = activiteRepository.findById(id);

        if(activite.isPresent()) {
            return activite.get();
        }
        return null;
    }
    
}

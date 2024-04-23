package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.Utilisateur;
import com.SAFRAN.ESPS.Repository.HabilitationRepository;
import com.SAFRAN.ESPS.Repository.UtilisateurRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilitationServiceImpl implements HabilitationService{
      @Autowired
    HabilitationRepository habilitationRepository;
     @Autowired
     UtilisateurRepository utilisateurRepository;
     @Override
   public Habilitation ajouterHabilitation(Habilitation habilitation) {
    // Enregistrer l'habilitation avec les utilisateurs associés
    return habilitationRepository.save(habilitation);
}

    @Override
    public Habilitation modifierHabilitation(Habilitation habilitation) {
        return habilitationRepository.save(habilitation);
    }

    @Override
    public List<Habilitation> listHabilitation() {
        return habilitationRepository.findByEtatactive(true);
    }
       @Override
    public List<Habilitation> listHabilitationByProcedeId(long id) {
        return habilitationRepository.findByProcedeId(id);
    }

    @Override
    public void supprimerById(Long id) {
        habilitationRepository.deleteById(id);
        
    }
    @Override
    public Habilitation getHabilitationById(Long id) {
        Optional<Habilitation> cc = habilitationRepository.findById(id);

        if(cc.isPresent()) {
            return cc.get();
        }
        return null;
    }

      @Override
   public List<Utilisateur> findUsersByHabilitationId(Long habilitationId) {
        return habilitationRepository.findUsersByHabilitationId(habilitationId);
    }
       @Override
   public List<Utilisateur> findAllUsersByHabilitationId(Long habilitationId) {
        return habilitationRepository.findAllUsersByHabilitationId(habilitationId);
    }
    
 
}



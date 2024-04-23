package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.Utilisateur;
import java.util.List;
import java.util.Optional;


public interface HabilitationService {
    Habilitation ajouterHabilitation(Habilitation habilitation);
    Habilitation modifierHabilitation(Habilitation habilitation);
    List<Habilitation> listHabilitation(); 
    List<Habilitation> listHabilitationByProcedeId(long id);
    void supprimerById(Long id);
    Habilitation getHabilitationById(Long id);
    List<Utilisateur> findUsersByHabilitationId(Long habilitationId);
    List<Utilisateur> findAllUsersByHabilitationId(Long habilitationId);
    
}
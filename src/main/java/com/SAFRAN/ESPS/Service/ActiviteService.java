package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Activite;
import java.util.List;


public interface ActiviteService {
     Activite ajouterActivite(Activite activite);
    Activite modifierActivite(Activite activite);
    List<Activite> listActivite(); 
    List<Activite> listActiviteByUniteId(long id);
    void supprimerById(Long id);
    Activite getActiviteById(Long id);
}

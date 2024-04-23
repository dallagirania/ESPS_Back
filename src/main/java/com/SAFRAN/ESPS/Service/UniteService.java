package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Unite;
import java.util.List;
import java.util.Optional;


public interface UniteService {
    
    Unite ajouterUnite(Unite unite);
    Unite modifierUnite(Unite unite);
    List<Unite> listUnite();
    void supprimerById(Long id);
    Unite getUniteById(Long id);
}

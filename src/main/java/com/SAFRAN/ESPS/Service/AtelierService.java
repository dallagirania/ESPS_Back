package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Atelier;
import java.util.List;


public interface AtelierService {
    
     Atelier ajouterAtelier(Atelier atelier);
    Atelier modifierAtelier(Atelier atelier);
    List<Atelier> listAtelier();
     List<Atelier> listAtelierByActiviteId(long id);
    void supprimerById(Long id);
    Atelier getAtelierById(Long id);
}

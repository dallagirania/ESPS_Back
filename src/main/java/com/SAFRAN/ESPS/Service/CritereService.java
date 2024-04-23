package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Critere;
import java.util.List;


public interface CritereService {
    Critere ajouterCritere(Critere carte);
    Critere modifierCritere(Critere carte);
    List<Critere> listCritere();
    List<Critere> listCritereByOKDId(long id);
    void supprimerById(Long id);
    Critere getCritereById(Long id); 
}


package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Utilisateur;
import java.util.List;

public interface UtilisateurService {
     Utilisateur ajouterUser(Utilisateur user);
    Utilisateur modifierUser(Utilisateur user);
    List<Utilisateur> listUser() ;
    List<Utilisateur> listUserMOD();
    List<Utilisateur> listUserRUO();
    void supprimerById(Long id);
    Utilisateur getUserById(Long id);
}

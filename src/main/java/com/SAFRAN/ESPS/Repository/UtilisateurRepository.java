/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
   
    Utilisateur findIdByMatricule(String matricule);
    boolean existsByMatricule(String matricule);
    
    public List<Utilisateur> findByEtatactive(Boolean actif);
    
    public List<Utilisateur> findByEtatactiveAndRoleId(Boolean actif ,Long role);
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Utilisateur;
import com.SAFRAN.ESPS.Repository.UtilisateurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

   @Autowired
    UtilisateurRepository userRepository;

  @Override
    public Utilisateur ajouterUser(Utilisateur user) {
        return userRepository.save(user);
    }
    
    @Override
    public Utilisateur modifierUser(Utilisateur user) {
        return userRepository.save(user);
    }

    @Override
    public List<Utilisateur> listUser() {
        return userRepository.findByEtatactive(true);
    }

    @Override
    public List<Utilisateur> listUserMOD() {
        return userRepository.findByEtatactiveAndRoleId(true,3L);
    }
     @Override
    public List<Utilisateur> listUserRUO() {
        return userRepository.findByEtatactiveAndRoleId(true,2L);
    }

  //@Override
    // public Optional<Unite> getUniteById(Long id) {
      //  return uniteRepository.findById(id);
    //}
    

    @Override
    public void supprimerById(Long id) {
        userRepository.deleteById(id);

    }
    
     @Override
    public Utilisateur getUserById(Long id) {
        Optional<Utilisateur> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }
    
}
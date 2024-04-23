/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Formation;
import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.Role;
import com.SAFRAN.ESPS.Model.Unite;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class UtilisateurDTO implements Serializable{
    
    private Long id;
    private String username;
    private String prenom;
    private String email;
    private String matricule;
    private Boolean etatactive=true;
    private String mdp;
    private long activite_id;
    private String image;
    private Role role;
    private Unite unite;
   // private List<Formation> formation;
    
}

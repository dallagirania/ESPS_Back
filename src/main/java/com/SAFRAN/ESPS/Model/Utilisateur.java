
package com.SAFRAN.ESPS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String prenom;
    private String email;
    private String matricule;
    private Boolean etatactive=true;
    private String mdp;
    private long activite_id; 
    @Column (name="image", columnDefinition="text")
    private String image;
    
    //relation avec Unite
    @ManyToOne
    @JoinColumn(name="uniteId")
    private Unite unite;
    
    
    @ManyToOne
    @JoinColumn(name="roleId")
    private Role role; 
    
     //relation avec formation
    //@OneToMany (mappedBy ="utilisateur")
   // @JsonManagedReference
//    private List<Formation> formation;
   
   
}

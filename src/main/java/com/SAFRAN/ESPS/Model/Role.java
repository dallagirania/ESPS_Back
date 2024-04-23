package com.SAFRAN.ESPS.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Roles")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Boolean etatactive=true;
    
    
   //@OneToMany (mappedBy ="role")
   // private List<User> utilisateur;
   // @JsonManagedReference
  // public List<User> getutilisateur() {
    //   return utilisateur;
    //}
    
    
}
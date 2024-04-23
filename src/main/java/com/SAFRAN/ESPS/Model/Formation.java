package com.SAFRAN.ESPS.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "formation")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_init;
    private String date_fin;
    private Boolean etatactive=true; 
    private long  qualit_id;
    

  //  @JsonManagedReference
    @ManyToOne
    private Habilitation habilitation;
    
   //relation avec files
    @OneToMany 
    private List<Document> files;
     
    @ManyToOne
  //  @JsonManagedReference
    private Utilisateur utilisateur; 
    
     @OneToMany 
    private List<ModFormation> modformation;
}

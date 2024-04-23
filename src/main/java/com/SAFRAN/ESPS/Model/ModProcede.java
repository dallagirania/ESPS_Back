package com.SAFRAN.ESPS.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModProcede {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private String rev;
    private String code;
    private String designation;
    private String etat;
    private int nb_critere;
    private String date_init;
    private String date_fin;
    private Boolean etatactive=true;
    
    @OneToMany 
    private List<Document> files;
    
    @ManyToOne
    private Procede procede;
}

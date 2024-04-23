package com.SAFRAN.ESPS.Model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesureOKD")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MesureOKD {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Commentaire;
    private String date_add;
    private String date_modif;
    private String evenement;
    private String equipe;      
    private Boolean etatactive=true;
    private long operateur;
    private long id_qualite;
  //relation avec okd 
    @ManyToOne
    private OKD okd;
     
    @Column
    @ElementCollection
    private Map<String, Long> val = new HashMap<>();
}

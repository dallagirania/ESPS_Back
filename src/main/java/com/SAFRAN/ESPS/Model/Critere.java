package com.SAFRAN.ESPS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "critere")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Critere {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    private String valeur;
    private String min;
    private String max;
    private Boolean etatactive=true;
    
      //relation avec OKD
    @ManyToOne
    @JoinColumn(name="okdId")
    private OKD okd;
    
    @JsonBackReference
    public OKD getOKD() {
        return okd;
    }
    
}

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
@Table(name = "carteContole")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarteControle {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private int nb_valeur;
    private String fonction;
    private Boolean etatactive=true;
    private String min;
    private String max;
      //relation avec Procede
    @ManyToOne
    @JoinColumn(name="procedeId")
    private Procede procede;
    
    @JsonBackReference
    public Procede getProcede() {
        return procede;
    } 
}

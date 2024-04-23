package com.SAFRAN.ESPS.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "mesureCC")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MesureCC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resultat;
    private String Commentaire;
    private String date;
    private String motif_saisie;      
    private Boolean etatactive=true;
    private Long operateur;
    private Long qualiticien ;
  //relation avec carte Controle 
    @ManyToOne
    private CarteControle carte;
     
    @Column
    @ElementCollection(targetClass=Float.class)
    private List<Float> val;
}

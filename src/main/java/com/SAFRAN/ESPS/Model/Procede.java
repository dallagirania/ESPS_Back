package com.SAFRAN.ESPS.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Procedes")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Procede {
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
    
    @Column (name="att1", columnDefinition="text")
    private String att1;
    
    @Column (name="att2", columnDefinition="text")
    private String att2;
    
    private Boolean etatactive=true;
  
    @Column (name="image", columnDefinition="text")
    private String image;
   
    //relation avec atelier  
    @ManyToOne
    private Atelier atelier;
   // @JoinColumn(name="atelierId")
   
    
    @JsonBackReference
    //@JsonIgnore
    public Atelier getAtelier() {
        return atelier;
    }
    
    //relation avec OKD
     @OneToMany (mappedBy ="procede")
    private List<OKD> okd;

    @JsonManagedReference
    public List<OKD> getOKD() {
        return okd;
    }
    
    //relation avec Carte De Controle
     @OneToMany (mappedBy ="procede")
    private List<CarteControle> carte;

    @JsonManagedReference
    public List<CarteControle> getCarteControle() {
        return carte;
    }
    
    //relation avec files
     @OneToMany 
    private List<Document> files;

   
    
    
}

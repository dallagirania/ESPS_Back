package com.SAFRAN.ESPS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Activites")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Activite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
   
    @Column (name="image", columnDefinition="text")
    private String image;
    
    //relation avec Unite
    @ManyToOne
    @JoinColumn(name="uniteId")
    private Unite unite;
    
    @JsonBackReference
    public Unite getUnite() {
        return unite;
    }
    
    //relation avec Atelier
    
    @OneToMany (mappedBy ="activite")
    private List<Atelier> atelier;

    @JsonManagedReference
    public List<Atelier> getAtelier() {
        return atelier;
    }
    
   

}

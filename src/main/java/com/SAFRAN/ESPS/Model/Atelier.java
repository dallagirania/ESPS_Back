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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ateliers")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Atelier {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
  
     @Column (name="image", columnDefinition="text")
    private String image;
    
    //relation avec Activite
    @ManyToOne
    @JoinColumn(name="activiteId")
    private Activite activite;
    
    @JsonBackReference
    public Activite getActivite() {
        return activite;
    }
    
    @OneToMany (mappedBy ="atelier")
    private List<Procede> procede;

    @JsonManagedReference
    public List<Procede> getProcede() {
        return procede;
    }
}


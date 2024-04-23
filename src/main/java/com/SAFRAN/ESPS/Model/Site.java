package com.SAFRAN.ESPS.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
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
@Table(name = "Sites")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
   
    
    @Column (name="image", columnDefinition="text")
    private String image;
    
   
    @OneToMany (mappedBy ="site")
    private List<Unite> unite;

    @JsonManagedReference
    public List<Unite> getUnite() {
        return unite;
    }
    
   
}


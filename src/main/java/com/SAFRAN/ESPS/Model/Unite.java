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
@Table(name = "Unites")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Unite {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
    
    @Column (name="image", columnDefinition="text")
    private String image;
    
    //relation avec Site 
    @ManyToOne
    @JoinColumn(name="siteId")
    private Site site;
    
    @JsonBackReference
    public Site getSite() {
        return site;
    }
    
    //relation avec Activité 
    
    @OneToMany (mappedBy ="unite")
    private List<Activite> activite;
    @JsonIgnore
    public List<Activite> getActivite() {
        return activite;
    }
  
}

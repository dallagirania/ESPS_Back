package com.SAFRAN.ESPS.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.nio.file.Path;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "files")
@Setter 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    public static byte[] readAllBytes(Path toPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    private String path;
    private Boolean etatactive=true;
    
     //relation avec atelier  
   /* @ManyToOne
    @JoinColumn(name="filesId")
    private Procede procede;
    */
  
    
    
}

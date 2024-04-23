package com.SAFRAN.ESPS.DTO;
import com.SAFRAN.ESPS.Model.Unite;
import java.io.Serializable;
import lombok.Data;

@Data
public class ActiviteDTO  implements Serializable{
     private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
    private String image;
    private Unite unite;
}
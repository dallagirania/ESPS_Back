package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Procede;
import java.io.Serializable;
import lombok.Data;

@Data
public class OkdDTO  implements Serializable{
  private Long id;
    private String nom;
    private String ref;
    private String designation;
    private String date_init;
    private Boolean etatactive=true;
      //relation avec Procede
    private Procede procede;
    
}

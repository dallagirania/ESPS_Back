package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Procede;
import java.io.Serializable;
import lombok.Data;

@Data
public class HabilitationDTO implements Serializable{
  private Long id;
    private String titre;
    private String ref;
    private Boolean etatactive=true;
    private String date_creation;
     //relation avec Procede 
    private Procede procede;   
}

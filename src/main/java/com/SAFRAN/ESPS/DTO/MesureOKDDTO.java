package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.OKD;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class MesureOKDDTO {
    private Long id;
    private String Commentaire;
    private String date_add;
     private String date_modif;
    private String evenement;
    private String equipe;      
    private Boolean etatactive=true;
    private long operateur;
    private long id_qualite;
  //relation avec okd 
    private OKD okd;
     private Map<String, Long> val = new HashMap<>();
}

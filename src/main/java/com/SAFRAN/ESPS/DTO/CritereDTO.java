package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.OKD;
import java.io.Serializable;
import lombok.Data;

@Data
public class CritereDTO implements Serializable{
    private Long id;
    private String nom;
    private String type;
    private String valeur;
    private String min;
    private String max;
    private Boolean etatactive=true;
     //relation avec OKD
   private OKD okd;
    
}

package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.MesureCC;
import lombok.Data;

@Data
public class ValeurCDTO {
     private Long id;
    private String valeur;
    private MesureCC mesureC;
    
}

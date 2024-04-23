package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Procede;
import java.io.Serializable;
import lombok.Data;

@Data
public class CarteControleDTO implements Serializable{
    private Long id;
    private String nom;
    private String ref;
    private int nb_valeur;
    private String fonction;
    private Boolean etatactive=true;
    private String min;
    private String max;
    //relation avec Procede
  
    private Procede procede;
}

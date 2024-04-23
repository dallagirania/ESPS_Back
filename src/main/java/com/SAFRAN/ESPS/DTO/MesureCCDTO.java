package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.ValeurC;
import java.util.List;
import lombok.Data;

@Data
public class MesureCCDTO {
   private Long id;
    private String resultat;
    private String Commentaire;
    private String date;
    private String motif_saisie;      
    private Boolean etatactive=true;
    private Long operateur;
    private Long qualiticien ;
  //relation avec carte Controle 

    private CarteControle carte;  
    private List<Float> val;

}

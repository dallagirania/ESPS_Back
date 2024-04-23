package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.ModFormation;
import com.SAFRAN.ESPS.Model.Utilisateur;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class FormationDTO implements Serializable{
    private Long id;
    private String date_init;
    private String date_fin;
    private Boolean etatactive=true; 
    private long  qualit_id;
    
    private Habilitation habilitation;
    private Utilisateur utilisateur; 
    //relation avec files
    private List<Document> files;
    private List<ModFormation> modformation;
}

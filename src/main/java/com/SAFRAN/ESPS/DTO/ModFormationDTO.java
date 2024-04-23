package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.Formation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
public class ModFormationDTO implements Serializable {
    private Long id;
    private String date_init;
    private String date_fin;
    private Boolean etatactive=true; 
    private long  qualit_id;
    private Formation formation;
    private List<Document> files;
      
}


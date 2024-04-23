package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Activite;
import java.io.Serializable;
import lombok.Data;

@Data
public class AtelierDTO  implements Serializable {
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
    private String image;
    private Activite activite;
}


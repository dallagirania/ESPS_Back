package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Site;
import java.io.Serializable;
import lombok.Data;

@Data
public class UniteDTO implements Serializable{
    private Long id;
    private String nom;
    private String ref;
    private String designation;
    private Boolean etatactive=true;
    private String image;
    private Site site;
}

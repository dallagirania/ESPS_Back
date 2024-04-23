package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.Atelier;
import com.SAFRAN.ESPS.Model.Document;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class ProcedeDTO implements Serializable{
    private Long id;
    private String nom;
    private String ref;
    private String rev;
    private String code;
    private String designation;
    private String etat;
    private int nb_critere;
    private String date_init;
    private String date_fin;
    private String att1;
    private String att2;
    private String image;
    private Atelier atelier;
    private Boolean etatactive=true;
    private List<Document> files;
}


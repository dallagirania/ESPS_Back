package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.OKD;
import java.util.List;


public interface OKDService {
    OKD ajouterOKD(OKD okd);
    OKD modifierOKD(OKD okd);
    List<OKD> listOKD();
     List<OKD> listOKDByProcedeId(long id);
    void supprimerById(Long id);
    OKD getOKDById(Long id); 
}

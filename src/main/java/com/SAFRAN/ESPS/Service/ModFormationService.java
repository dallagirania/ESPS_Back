package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Formation;
import com.SAFRAN.ESPS.Model.ModFormation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ModFormationService {
     ModFormation ajouterModFormation(ModFormation modFormation,MultipartFile[] files);
  //     Formation ajouterFormation(Formation formation);
    ModFormation modifierModFormation(ModFormation modFormation);
    List<ModFormation> listModFormation(); 
    List<ModFormation> listModFormationByFormationId(long id);
    void supprimerById(Long id);
    ModFormation getModFormationById(Long id); 
    ResponseEntity telechargement(String fileName);
}

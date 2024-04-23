package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.ModProcede;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface ModProcedeService {
       ModProcede ajouterModProcede( ModProcede  modProcede,MultipartFile[] files);
  //     Formation ajouterFormation(Formation formation);
    ModProcede modifierModProcede(ModProcede modProcede);
    List<ModProcede> listModProcede(); 
    List<ModProcede> listModProcedeByProcedeId(long id);
    void supprimerById(Long id);
    ModProcede getModProcedeById(Long id); 
    ResponseEntity telechargement(String fileName);
    
    
}

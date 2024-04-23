package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Procede;
import java.io.IOException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface ProcedeService {
    Procede ajouterProcede(Procede procede,MultipartFile[] files);
    Procede modifierProcede(Procede procede,MultipartFile[] files);
    List<Procede> listProcede();
    Procede supprimerProcede(Procede procede);
    Procede getProcedeById(Long id);
    ResponseEntity telechargement(String fileName);
    ResponseEntity<String> getImg(String imageName)throws IOException;
    
    Procede getProcedeWithLastModProcede(Long ProcedeId);
    
    List<Procede> getProcedesWithLastModProcede();
}


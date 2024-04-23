package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Formation;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FormationService {
    Formation ajouterFormation(Formation formation,MultipartFile[] files);
    Formation modifierFormation(Formation formation,MultipartFile[] files);
    List<Formation> listFormation(); 
    List<Formation> listFormationByHabilitationId(long id);
    Formation supprimerFormation(Formation formation);
    Formation getFormationById(Long id); 
    ResponseEntity telechargement(String fileName);
   // Formation getFormationWithLastModFormation(Long formationId);
    List<Formation> findByEtatactiveAndHabilitationId(Long habilitationId) ;
}
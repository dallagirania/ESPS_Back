package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.Formation;
import com.SAFRAN.ESPS.Model.ModFormation;
import com.SAFRAN.ESPS.Model.Procede;
import com.SAFRAN.ESPS.Repository.FormationRepository;
import com.SAFRAN.ESPS.Repository.ModFormationRepository;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FormationServiceImpl implements FormationService{

    @Autowired
    FormationRepository formationRepository;
    @Autowired
    private FileUpload fileUpload;
    
    @Override
    public Formation ajouterFormation(Formation formation,MultipartFile[] files) {
      //  return procedeRepository.save(procede);
     ArrayList<Document> f2 = new ArrayList<Document>();
        int i = 0;
      
        Iterable<MultipartFile> multipartFile;
        //Sauvgarder les fichiers:
        for (MultipartFile file : files) {
          try {
              f2.add(fileUpload.uploadFileFormation(file));
          } catch (IOException ex) {
              Logger.getLogger(FormationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        formation.setFiles(f2);
        Formation savedFormation = formationRepository.save(formation);
        return (savedFormation); 
         //  return formationRepository.save(formation);
    }

    @Override
    public Formation modifierFormation(Formation formation,MultipartFile[] files) {
       // return formationRepository.save(formation);
       ArrayList<Document> f2 = new ArrayList<Document>();
        int i = 0;
        //Sauvgarder les criteres:
        Iterable<MultipartFile> multipartFile;
        //Sauvgarder les fichiers:
        for (MultipartFile file : files) {
          try {
              f2.add(fileUpload.uploadFileFormation(file));
          } catch (IOException ex) {
              Logger.getLogger(ProcedeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        formation.setFiles(f2);
        Formation savedFormation = formationRepository.save(formation);
        return (savedFormation);
    }

    @Override
    public List<Formation> listFormation() {
        return formationRepository.findByEtatactive(true);
    }

 
       @Override
   public List<Formation> listFormationByHabilitationId(long id) {
        return formationRepository.findByHabilitationId(id);
    }

    @Override
    public Formation supprimerFormation(Formation formation) {
       return formationRepository.save(formation);
    }

    @Override
    public Formation getFormationById(Long id) {
        Optional<Formation> formation = formationRepository.findById(id);

        if(formation.isPresent()) {
            return formation.get();
        }
        return null;
    }
    
    
    @Override

   public ResponseEntity telechargement(String fileName) {

        Path path = Paths.get("C:\\ESPS\\Formation" + fileName);

        Resource resource = null;

        try {

            resource =  (Resource) new UrlResource(path.toUri());

        } catch (MalformedURLException e) {

            e.getMessage();

        }

        return ResponseEntity.ok()

                //.contentType(MediaType.parseMediaType("image/png"))

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.name())

                .body(resource);

    }
    
     @Autowired
    private ModFormationRepository modFormationRepository;

    public List<Formation> findByEtatactiveAndHabilitationId(Long habilitationId) {
        List<Formation> formations = formationRepository.findByHabilitationId(habilitationId);

        for (Formation formation : formations) {
            List<ModFormation> modFormations = modFormationRepository.findByFormation(formation);

            if (!modFormations.isEmpty()) {
                ModFormation lastModFormation = modFormations.get(modFormations.size() - 1);
                formation.setDate_init(lastModFormation.getDate_init());
                formation.setDate_fin(lastModFormation.getDate_fin());
                formation.setFiles(lastModFormation.getFiles());
            }
        }

        return formations;
}
      public List<Formation> findByEtatactiveAndHabilitation(Long habilitationId) {
        List<Formation> formations = formationRepository.findByEtatactiveAndHabilitationId(true,habilitationId);

        for (Formation formation : formations) {
            List<ModFormation> modFormations = modFormationRepository.findByFormation(formation);

            if (!modFormations.isEmpty()) {
                ModFormation lastModFormation = modFormations.get(modFormations.size() - 1);
                formation.setDate_init(lastModFormation.getDate_init());
                formation.setDate_fin(lastModFormation.getDate_fin());
                formation.setFiles(lastModFormation.getFiles());
            }
        }

        return formations;
}
        
}

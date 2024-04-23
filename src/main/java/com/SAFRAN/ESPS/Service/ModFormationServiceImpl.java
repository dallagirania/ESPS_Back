package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.ModFormation;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ModFormationServiceImpl implements ModFormationService{

    @Autowired
    ModFormationRepository modformationRepository;
    @Autowired
    private FileUpload fileUpload;
    
    @Override
    public ModFormation ajouterModFormation(ModFormation modformation,MultipartFile[] files) {
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

        modformation.setFiles(f2);
        ModFormation savedModif = modformationRepository.save(modformation);
        return (savedModif); 
         //  return formationRepository.save(formation);
    }

    @Override
    public  ModFormation modifierModFormation( ModFormation modformation) {
        return modformationRepository.save(modformation);
    }

    @Override
    public List< ModFormation> listModFormation() {
        return modformationRepository.findByEtatactive(true);
    }

 
       @Override
    public List< ModFormation> listModFormationByFormationId(long id) {
        return modformationRepository.findByFormationId(id);
    }

    @Override
    public void supprimerById(Long id) {
        modformationRepository.deleteById(id);

    }

    @Override
    public  ModFormation getModFormationById(Long id) {
        Optional< ModFormation> modformation = modformationRepository.findById(id);

        if(modformation.isPresent()) {
            return modformation.get();
        }
        return null;
    }
    
    @Override
    public ResponseEntity telechargement(String fileName) {

        Path path = Paths.get("C:\\ESPS\\Formation\\" + fileName);

        Resource resource = null;

        try {

            resource =   new UrlResource(path.toUri());

        } catch (MalformedURLException e) {

            e.getMessage();

        }

        return ResponseEntity.ok()

                //.contentType(MediaType.parseMediaType("image/png"))

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())

                .body(resource);

    }
       
}

package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.ModFormation;
import com.SAFRAN.ESPS.Model.ModProcede;
import com.SAFRAN.ESPS.Repository.ModFormationRepository;
import com.SAFRAN.ESPS.Repository.ModProcedeRepository;
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
public class ModProcedeServiceImpl implements ModProcedeService{

    @Autowired
    ModProcedeRepository modprocedeRepository;
    @Autowired
    private FileUpload fileUpload;
    
    @Override
    public ModProcede ajouterModProcede(ModProcede modprocede,MultipartFile[] files) {
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

        modprocede.setFiles(f2);
        ModProcede savedModif = modprocedeRepository.save(modprocede);
        return (savedModif); 
         //  return formationRepository.save(formation);
    }

    @Override
    public  ModProcede modifierModProcede( ModProcede modprocede) {
        return modprocedeRepository.save(modprocede);
    }

    @Override
    public List< ModProcede> listModProcede() {
        return modprocedeRepository.findByEtatactive(true);
    }

 
       @Override
    public List< ModProcede> listModProcedeByProcedeId(long id) {
        return modprocedeRepository.findByProcedeId(id);
    }

    @Override
    public void supprimerById(Long id) {
        modprocedeRepository.deleteById(id);

    }

    @Override
    public  ModProcede getModProcedeById(Long id) {
        Optional< ModProcede> modformation = modprocedeRepository.findById(id);

        if(modformation.isPresent()) {
            return modformation.get();
        }
        return null;
    }
    
    @Override
    public ResponseEntity telechargement(String fileName) {

        Path path = Paths.get("C:\\ESPS" + fileName);

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

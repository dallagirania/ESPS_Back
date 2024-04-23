package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Document;
import com.SAFRAN.ESPS.Model.ModProcede;
import com.SAFRAN.ESPS.Model.Procede;
import com.SAFRAN.ESPS.Repository.ModProcedeRepository;
import com.SAFRAN.ESPS.Repository.ProcedeRepository;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class ProcedeServiceImpl implements ProcedeService{

    @Autowired
    ProcedeRepository procedeRepository;
     @Autowired
    private FileUpload fileUpload;

    @Override
    public Procede ajouterProcede(Procede procede,MultipartFile[] files) {
      //  return procedeRepository.save(procede);
      ArrayList<Document> f2 = new ArrayList<Document>();
        int i = 0;
        //Sauvgarder les criteres:
        Iterable<MultipartFile> multipartFile;
        //Sauvgarder les fichiers:
        for (MultipartFile file : files) {
          try {
              f2.add(fileUpload.uploadFile(file));
          } catch (IOException ex) {
              Logger.getLogger(ProcedeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        procede.setFiles(f2);
        Procede savedProcede = procedeRepository.save(procede);
        return (savedProcede);
    }


    @Override
    public Procede modifierProcede(Procede procede,MultipartFile[] files) {
            ArrayList<Document> f2 = new ArrayList<Document>();
        int i = 0;
        //Sauvgarder les criteres:
        Iterable<MultipartFile> multipartFile;
        //Sauvgarder les fichiers:
        for (MultipartFile file : files) {
          try {
              f2.add(fileUpload.uploadFile(file));
          } catch (IOException ex) {
              Logger.getLogger(ProcedeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        procede.setFiles(f2);
        Procede savedProcede = procedeRepository.save(procede);
        return (savedProcede);
    }

    @Override
    public List<Procede> listProcede() {
        return procedeRepository.findByEtatactive(true);
    }

 
    

    @Override
    public Procede supprimerProcede(Procede procede) {
       return procedeRepository.save(procede);
    }

    
     @Override
    public Procede getProcedeById(Long id) {
        Optional<Procede> procede = procedeRepository.findById(id);

        if(procede.isPresent()) {
            return procede.get();
        }
        return null;
    }
    
   @Override
    public ResponseEntity telechargement(String fileName) {

        Path path = Paths.get("C:\\ESPS\\" + fileName);

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
    
  @Override
public ResponseEntity<String> getImg(String imageName) throws IOException {
        String imagePath = "C://ESPS//"+ imageName;
        System.out.println(imagePath);
        Resource imageResource = new FileSystemResource(imagePath);
         System.out.println("data:image/png;base64 : " + imageResource.getFile().toPath());
        byte[] imageBytes = Files.readAllBytes(imageResource.getFile().toPath());
         System.out.println("data:image/png;base64 : " + imageBytes);
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        System.out.println("data:image/png;base64," + base64Image);
        return ResponseEntity.ok("data:image/png;base64," + base64Image);

}
@Autowired
    private ModProcedeRepository modProcedeRepository;

   @Override  
   
    public Procede getProcedeWithLastModProcede(Long procedeId) {
        Optional<Procede> procedeOptional = procedeRepository.findById(procedeId);

        if (procedeOptional.isPresent()) {
            Procede procede = procedeOptional.get();
            List<ModProcede> modProcedes = modProcedeRepository.findByProcede(procede);

            if (!modProcedes.isEmpty()) {
                ModProcede lastModProcede = modProcedes.get(modProcedes.size() - 1);
                procede.setDate_init(lastModProcede.getDate_init());
                procede.setDate_fin(lastModProcede.getDate_fin());
            }

            return procede;
        } else {
            throw new RuntimeException("Formation not found with id: " + procedeId);
        }
    }
      @Override
       public List<Procede> getProcedesWithLastModProcede() {
        List<Procede> procedes = procedeRepository.findByEtatactive(true);
          System.out.println("test Procede : ");
        for (Procede procede : procedes) {
            List<ModProcede> modProcedes = modProcedeRepository.findByProcede(procede);
                System.out.println("test ModProcede : ");
            if (!modProcedes.isEmpty()) {
                System.out.println("test interne : ");
                ModProcede lastModProcede = modProcedes.get(modProcedes.size() - 1);
                procede.setDate_init(lastModProcede.getDate_init());
                procede.setDate_fin(lastModProcede.getDate_fin());
            }
        }
        System.out.println("test fin : ");
        return procedes;
    }
}




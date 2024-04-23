
package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Repository.FilesRepository;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileUpload {
    
    @Autowired
    FilesRepository fileRepository;
    
    // ==> Ajout Files Pour Procede Spéciale:
    
    public com.SAFRAN.ESPS.Model.Document uploadFile(MultipartFile multipartFile) throws IOException {

        String nom = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        int i = 0;

        int position = 0;

        Path uploadPath = Paths.get("C:\\ESPS");
        com.SAFRAN.ESPS.Model.Document response = new com.SAFRAN.ESPS.Model.Document();

        response.setNom(nom);

        String nomFile = nom;

        position = nom.indexOf(".");

        String s = nomFile.substring(position + 1, nomFile.length());


        response.setPath(uploadPath + nomFile);

        response.setType(s);
        Date d = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(d);
        fileRepository.save(response); // Save the object once
        String fileName = response.getId() + "_Procede_"+ "_" + dateStr + "_" + nom;
        response.setNom(fileName);

        response.setPath(uploadPath + "\\" + fileName);

        if (!java.nio.file.Files.exists(uploadPath)) {

            java.nio.file.Files.createDirectories(uploadPath);

        }

        try (InputStream inputStream = multipartFile.getInputStream()) {

            Path filePath = uploadPath.resolve(fileName);

            java.nio.file.Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ioe) {

            throw new IOException("Could not save file: " + nom, ioe);

        }

        return response;

    }


// ==> Ajout Files Pour Formation:
    
   public com.SAFRAN.ESPS.Model.Document uploadFileFormation(MultipartFile multipartFile) throws IOException {

        String nom = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        int i = 0;

        int position = 0;

        Path uploadPath = Paths.get("C:\\ESPS\\Formation");
        com.SAFRAN.ESPS.Model.Document response = new com.SAFRAN.ESPS.Model.Document();

        response.setNom(nom);

        String nomFile = nom;

        position = nom.indexOf(".");

        String s = nomFile.substring(position + 1, nomFile.length());
        Date d = new Date();

        response.setPath(uploadPath + nomFile);

        response.setType(s);

        fileRepository.save(response); // Save the object once
        String fileName = response.getId() + "_Habilitation_"+"_"+d.getDate() + "_" + d.getMonth() + "_" + d.getTime() + nom;

        response.setNom(fileName);

        response.setPath(uploadPath + "\\" + fileName);

        if (!java.nio.file.Files.exists(uploadPath)) {

            java.nio.file.Files.createDirectories(uploadPath);

        }

        try (InputStream inputStream = multipartFile.getInputStream()) {

            Path filePath = uploadPath.resolve(fileName);

            java.nio.file.Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ioe) {

            throw new IOException("Could not save file: " + nom, ioe);

        }

        return response;

    }
}


package com.SAFRAN.ESPS.controller;


import org.springframework.http.HttpStatus;
import com.SAFRAN.ESPS.Service.AtelierService;
import com.SAFRAN.ESPS.Service.ProcedeService;

import com.SAFRAN.ESPS.Model.Procede;
import com.SAFRAN.ESPS.DTO.ProcedeDTO;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/procede")

public class ProcedeController {
    @Autowired
    AtelierService atelierService;
    @Autowired
    ProcedeService procedeService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public ProcedeDTO ajouterProcede(  @RequestPart("procede") ProcedeDTO procedeDto,@RequestPart("files") MultipartFile[] files){
        Procede procedeRequest=modelMapper.map(procedeDto,Procede.class);
        Procede procede=procedeService.ajouterProcede(procedeRequest,files);
        ProcedeDTO procedeResponse=modelMapper.map(procede,ProcedeDTO.class);
    return procedeResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Procede modifierProcede(@PathVariable("id")Long id,  @RequestPart("procede") Procede procede,@RequestPart("files") MultipartFile[] files){
        Procede newProcede=procedeService.modifierProcede(procede,files);
        return newProcede;
    }

  @RequestMapping(value = "/supprimer/{id}",method = RequestMethod.PUT)
    public Procede supprimerProcede(@PathVariable("id")Long id,@RequestBody Procede procede){
        Procede newProcede=procedeService.supprimerProcede(procede);
        return newProcede;
    }
 

   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<ProcedeDTO> getProcedeById(@PathVariable("id")Long id){
        Procede procede=procedeService.getProcedeById(id);
        ProcedeDTO procedeDto=modelMapper.map(procede,ProcedeDTO.class);
        return ResponseEntity.ok().body(procedeDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<ProcedeDTO>listProcede(){
            return procedeService.listProcede().stream().map(procede -> modelMapper.map(procede,ProcedeDTO.class)).collect(Collectors.toList());
         }

        
           @GetMapping("/telechargement/{fileName}")
    public ResponseEntity telechargement(@PathVariable String fileName) {
         System.out.println("44444444444444444444");
         System.out.println(fileName);
        return procedeService.telechargement(fileName);
    }
    
      @GetMapping("/getImage/{imgName}")
    public ResponseEntity<String> getImage(@PathVariable String imgName) {
        try {
            return procedeService.getImg(imgName);
        } catch (IOException e) {
            // Gérer les erreurs d'entrée/sortie ici
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erreur lors de la récupération de l'image.");
        }
    }
    
     @GetMapping("/denier_date/{id}")
    public Procede getProcedeWithLastModProcede(@PathVariable Long id) {
        return procedeService.getProcedeWithLastModProcede(id);
    }
     @GetMapping("/denier_date")
     public List<Procede> getProcedesWithLastModProcede() {
        return procedeService.getProcedesWithLastModProcede();
    }
}
    
   


    


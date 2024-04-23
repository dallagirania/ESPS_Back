package com.SAFRAN.ESPS.Controller;


import com.SAFRAN.ESPS.DTO.ModFormationDTO;
import com.SAFRAN.ESPS.Model.ModFormation;
import com.SAFRAN.ESPS.Service.FormationService;
import com.SAFRAN.ESPS.Service.ModFormationService;
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
@RequestMapping(value = "/modformation")
public class ModFormationController {
     @Autowired
    ModFormationService modformationService;
    @Autowired
    FormationService formationService;
    @Autowired
    private ModelMapper modelMapper;
    
         
    @RequestMapping(method = RequestMethod.POST)
    public ModFormationDTO ajouterModFormation( @RequestPart("modformation")ModFormationDTO  modformationDto,@RequestPart("files") MultipartFile[] files){
        ModFormation modformationRequest=modelMapper.map(modformationDto,ModFormation.class);
        ModFormation modformation=modformationService.ajouterModFormation(modformationRequest,files);
        ModFormationDTO modformationResponse=modelMapper.map(modformation,ModFormationDTO.class);
    return modformationResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModFormation modifierModFormation(@PathVariable("id")Long id,@RequestBody ModFormation modformation){
        ModFormation newFormation=modformationService.modifierModFormation(modformation);
        return newFormation;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerModFormation(@PathVariable("id")Long id){
        modformationService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<ModFormationDTO> geModFormationById(@PathVariable("id")Long id){
        ModFormation modformation=modformationService.getModFormationById(id);
        ModFormationDTO modformationDto=modelMapper.map(modformation,ModFormationDTO.class);
        return ResponseEntity.ok().body(modformationDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<ModFormationDTO>listModFormation(){
            return modformationService.listModFormation().stream().map(modformation -> modelMapper.map(modformation,ModFormationDTO.class)).collect(Collectors.toList());
         }

    @GetMapping("/formation/{formationId}")
    public List<ModFormationDTO> getModFormationByFormationId(@PathVariable Long formationId) {
        List<ModFormation> critere = modformationService.listModFormationByFormationId(formationId);
        return critere.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private ModFormationDTO mapToDTO(ModFormation c) {
        ModFormationDTO modformationDTO  = new ModFormationDTO();
        modformationDTO.setId(c.getId());
        modformationDTO.setDate_fin(c.getDate_fin());
        modformationDTO.setDate_init(c.getDate_init());
        modformationDTO.setFormation(c.getFormation());
        modformationDTO.setFiles(c.getFiles());
        modformationDTO.setQualit_id(c.getQualit_id());  
        modformationDTO.setEtatactive(c.getEtatactive());
        return modformationDTO;
    }
     
     @GetMapping("/telechargement/{fileName}")
    public ResponseEntity telechargement(@PathVariable String fileName) {
         System.out.println("44444444444444444444");
         System.out.println(fileName);
        return modformationService.telechargement(fileName);
    }
        
}
    

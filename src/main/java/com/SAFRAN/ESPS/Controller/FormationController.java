package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.FormationDTO;
import com.SAFRAN.ESPS.DTO.ProcedeDTO;
import com.SAFRAN.ESPS.Model.Formation;
import com.SAFRAN.ESPS.Model.Procede;
import com.SAFRAN.ESPS.Service.FormationService;
import com.SAFRAN.ESPS.Service.HabilitationService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
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
@RequestMapping(value = "/formation")
public class FormationController {
    @Autowired
    HabilitationService habilitationService;
    @Autowired
    FormationService formationService;
    @Autowired
    private ModelMapper modelMapper;
    
         
    @RequestMapping(method = RequestMethod.POST)
    public FormationDTO ajouterFoamation( @RequestPart("formation")FormationDTO  formationDto,@RequestPart("files") MultipartFile[] files){
         Formation formationRequest=modelMapper.map(formationDto,Formation.class);
         Formation formation=formationService.ajouterFormation(formationRequest,files);
         FormationDTO formationResponse=modelMapper.map(formation,FormationDTO.class);
    return formationResponse;
}
    @RequestMapping(method = RequestMethod.PUT)
    public Formation modifierFoamation(@RequestPart("formation")Formation formation,@RequestPart("files") MultipartFile[] files){
        Formation newFormation=formationService.modifierFormation(formation,files);
        return newFormation;
    }

    @RequestMapping(value = "/supprimer/{id}",method = RequestMethod.PUT)
    public Formation supprimerFoamation(@PathVariable("id")Long id,@RequestBody Formation formation){
        Formation newFormation=formationService.supprimerFormation(formation);
        return newFormation;
    }
 

   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<FormationDTO> getFormationById(@PathVariable("id")Long id){
        Formation formation=formationService.getFormationById(id);
        FormationDTO formationDto=modelMapper.map(formation,FormationDTO.class);
        return ResponseEntity.ok().body(formationDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<FormationDTO>listFormation(){
            return formationService.listFormation().stream().map(formation -> modelMapper.map(formation,FormationDTO.class)).collect(Collectors.toList());
         }

    @GetMapping("/habilitation/{habilitationId}")
    public List<FormationDTO> getFormationByHabilitationId(@PathVariable Long habilitationId) {
        List<Formation> critere = formationService.listFormationByHabilitationId(habilitationId);
        return critere.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private FormationDTO mapToDTO(Formation c) {
        FormationDTO formationDTO  = new FormationDTO();
        formationDTO.setId(c.getId());
        formationDTO.setDate_fin(c.getDate_fin());
        formationDTO.setDate_init(c.getDate_init());
        formationDTO.setUtilisateur(c.getUtilisateur());
        formationDTO.setHabilitation(c.getHabilitation());
        formationDTO.setModformation(c.getModformation());
        formationDTO.setFiles(c.getFiles());
     //   formationDTO.setFiles(c.getFiles());
        formationDTO.setQualit_id(c.getQualit_id());  
        formationDTO.setEtatactive(c.getEtatactive());
        return formationDTO;
    }  
    
    @GetMapping("/telechargement/{fileName:.+}")
    public ResponseEntity telechargement(@PathVariable String fileName) {
        return formationService.telechargement(fileName);
    }
    
     @GetMapping("/denier_date/{habid}")
    public List<Formation> getFormationsByHabilitationId(@PathVariable Long habid) {
        return formationService.findByEtatactiveAndHabilitationId(habid);
    }
      @GetMapping("/accee/{habid}")
    public List<Formation> getFormationsByHabilitation(@PathVariable Long habid) {
        return formationService.findByEtatactiveAndHabilitationId(habid);
    }
   /* public Formation getFormationWithLastModFormation(@PathVariable Long id) {
        return formationService.getFormationWithLastModFormation(id);
    }*/
}
    

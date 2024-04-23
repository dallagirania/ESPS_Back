package com.SAFRAN.ESPS.controller;

import com.SAFRAN.ESPS.Service.ActiviteService;
import com.SAFRAN.ESPS.Service.AtelierService;
import com.SAFRAN.ESPS.Model.Atelier;
import com.SAFRAN.ESPS.DTO.AtelierDTO;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/atelier")
public class AtelierControllrer {
    @Autowired
    AtelierService atelierService;
    @Autowired
    ActiviteService activiteService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public AtelierDTO ajouterAtelier(@RequestBody AtelierDTO atelierDto){
        Atelier atelierRequest=modelMapper.map(atelierDto,Atelier.class);
        Atelier atelier=atelierService.ajouterAtelier(atelierRequest);
        AtelierDTO atelierResponse=modelMapper.map(atelier,AtelierDTO.class);
    return atelierResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Atelier modifierAtelier(@PathVariable("id")Long id,@RequestBody Atelier atelier){
        Atelier newAtelier=atelierService.modifierAtelier(atelier);
        return newAtelier;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerAtelier(@PathVariable("id")Long id){
        atelierService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<AtelierDTO> getAtelierById(@PathVariable("id")Long id){
        Atelier atelier=atelierService.getAtelierById(id);
        AtelierDTO atelierDto=modelMapper.map(atelier,AtelierDTO.class);
        return ResponseEntity.ok().body(atelierDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<AtelierDTO>listAtelier(){
            return atelierService.listAtelier().stream().map(atelier -> modelMapper.map(atelier,AtelierDTO.class)).collect(Collectors.toList());
         }

        
         //listActiviteByUniteId
        
    @GetMapping("/activite/{activiteId}")
    public List<AtelierDTO> getAtelierByActiviteId(@PathVariable Long activiteId) {
        List<Atelier> ateliers = atelierService.listAtelierByActiviteId(activiteId);
        return ateliers.stream()
                .map(atelier -> mapToDTO(atelier))
                .collect(Collectors.toList());
    }
     private AtelierDTO mapToDTO(Atelier atelier) {
        AtelierDTO atelierDTO = new AtelierDTO();
        atelierDTO.setId(atelier.getId());
        atelierDTO.setNom(atelier.getNom());
        atelierDTO.setRef(atelier.getRef());
        atelierDTO.setDesignation(atelier.getDesignation());
        atelierDTO.setEtatactive(atelier.getEtatactive());
        atelierDTO.setImage(atelier.getImage());
        atelierDTO.setActivite(atelier.getActivite());
        return atelierDTO;
    }
}
    


    

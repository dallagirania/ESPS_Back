package com.SAFRAN.ESPS.controller;

import com.SAFRAN.ESPS.Service.ActiviteService;
import com.SAFRAN.ESPS.Service.UniteService;
import com.SAFRAN.ESPS.Model.Activite;
import com.SAFRAN.ESPS.DTO.ActiviteDTO;
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
@RequestMapping(value = "/activite")
public class ActiviteController {
    @Autowired
    ActiviteService activiteService;
    @Autowired
    UniteService uniteService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public ActiviteDTO ajouterActivite(@RequestBody ActiviteDTO activiteDto){
        Activite activiteRequest=modelMapper.map(activiteDto,Activite.class);
        Activite activite=activiteService.ajouterActivite(activiteRequest);
        ActiviteDTO activiteResponse=modelMapper.map(activite,ActiviteDTO.class);
    return activiteResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Activite modifierActivite(@PathVariable("id")Long id,@RequestBody Activite activite){
        Activite newActivite=activiteService.modifierActivite(activite);
        return newActivite;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerActivite(@PathVariable("id")Long id){
        activiteService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<ActiviteDTO> getActiviteById(@PathVariable("id")Long id){
        Activite activite=activiteService.getActiviteById(id);
        ActiviteDTO activiteDto=modelMapper.map(activite,ActiviteDTO.class);
        return ResponseEntity.ok().body(activiteDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<ActiviteDTO>listActivite(){
            return activiteService.listActivite().stream().map(activite -> modelMapper.map(activite,ActiviteDTO.class)).collect(Collectors.toList());
         }
    //listActiviteByUniteId
        
    @GetMapping("/unite/{uniteId}")
    public List<ActiviteDTO> getActivitesByUniteId(@PathVariable Long uniteId) {
        List<Activite> activites = activiteService.listActiviteByUniteId(uniteId);
        return activites.stream()
                .map(activite -> mapToDTO(activite))
                .collect(Collectors.toList());
    }
     private ActiviteDTO mapToDTO(Activite activite) {
        ActiviteDTO activiteDTO = new ActiviteDTO();
        activiteDTO.setId(activite.getId());
        activiteDTO.setNom(activite.getNom());
        activiteDTO.setRef(activite.getRef());
        activiteDTO.setDesignation(activite.getDesignation());
        activiteDTO.setEtatactive(activite.getEtatactive());
        activiteDTO.setImage(activite.getImage());
        activiteDTO.setUnite(activite.getUnite());
        return activiteDTO;
    }

}
    


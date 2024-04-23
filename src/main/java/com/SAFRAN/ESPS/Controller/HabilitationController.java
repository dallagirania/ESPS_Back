package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.HabilitationDTO;
import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.Utilisateur;
import com.SAFRAN.ESPS.Service.HabilitationService;
import com.SAFRAN.ESPS.Service.ProcedeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping(value = "/habilitation")
public class HabilitationController {
     @Autowired
    ProcedeService procedeService;
    @Autowired
    HabilitationService habilitationService;
    @Autowired
    private ModelMapper modelMapper;
    
     @RequestMapping(method = RequestMethod.POST)
    public HabilitationDTO ajouterHabilitation(@RequestBody HabilitationDTO ccDto){
        Habilitation ccRequest=modelMapper.map(ccDto,Habilitation.class);
        Habilitation cc=habilitationService.ajouterHabilitation(ccRequest);
       HabilitationDTO  CCResponse=modelMapper.map(cc,HabilitationDTO.class);
    return CCResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Habilitation modifierCarteControle(@PathVariable("id")Long id,@RequestBody Habilitation cc){
        Habilitation newCarteControle=habilitationService.modifierHabilitation(cc);
        return newCarteControle;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerHabilitation(@PathVariable("id")Long id){
        habilitationService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<HabilitationDTO> getHabilitationById(@PathVariable("id")Long id){
        Habilitation cc=habilitationService.getHabilitationById(id);
        HabilitationDTO ccDto=modelMapper.map(cc,HabilitationDTO.class);
        return ResponseEntity.ok().body(ccDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<HabilitationDTO>listCarteControle(){
            return habilitationService.listHabilitation().stream().map(cc -> modelMapper.map(cc,HabilitationDTO.class)).collect(Collectors.toList());
         }

        
     @GetMapping("/procede/{procedeId}")
    public List<HabilitationDTO> getHabilitationByProcedeId(@PathVariable Long procedeId) {
        List<Habilitation> habilitation = habilitationService.listHabilitationByProcedeId(procedeId);
        return habilitation.stream()
                .map(cc -> mapToDTO(cc))
                .collect(Collectors.toList());
    }
     private HabilitationDTO mapToDTO(Habilitation cc) {
         HabilitationDTO ccDTO  = new HabilitationDTO();
        ccDTO.setId(cc.getId());
        ccDTO.setTitre(cc.getTitre());
        ccDTO.setRef(cc.getRef());
         ccDTO.setProcede(cc.getProcede());
        ccDTO.setEtatactive(cc.getEtatactive());
        return ccDTO;
    }  
     
     
    @GetMapping("/{habilitationId}/users")
    public List<Utilisateur> getUsersByHabilitationId(@PathVariable Long habilitationId) {
        return habilitationService.findUsersByHabilitationId(habilitationId);
    }
    @GetMapping("/{habilitationId}/allusers")
    public List<Utilisateur> findAllUsersByHabilitationId(@PathVariable Long habilitationId) {
        return habilitationService.findAllUsersByHabilitationId(habilitationId);
    }
}
    

package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.ValeurCDTO;
import com.SAFRAN.ESPS.Model.ValeurC;
import com.SAFRAN.ESPS.Service.MesureCCService;
import com.SAFRAN.ESPS.Service.ValeurCService;
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
@RequestMapping(value = "/valeurC")
public class ValeurCController {
    @Autowired
    MesureCCService mesureService;
    @Autowired
    ValeurCService valeurService;
    @Autowired
    private ModelMapper modelMapper;
    
    @RequestMapping(method = RequestMethod.POST)
    public ValeurCDTO ajouterMesureCC(@RequestBody ValeurCDTO valeurDto){
        ValeurC valeurRequest=modelMapper.map(valeurDto,ValeurC.class);
        ValeurC valeur=valeurService.ajouterValeurC(valeurRequest);
        ValeurCDTO critereResponse=modelMapper.map(valeur,ValeurCDTO.class);
    return critereResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ValeurC modifierValeurC(@PathVariable("id")Long id,@RequestBody ValeurC valeur){
        ValeurC newValeurC=valeurService.modifierValeurC(valeur);
        return newValeurC;
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<ValeurCDTO> getValeurCById(@PathVariable("id")Long id){
        ValeurC mesure=valeurService.getValeurCById(id);
        ValeurCDTO mesureDto=modelMapper.map(mesure,ValeurCDTO.class);
        return ResponseEntity.ok().body(mesureDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<ValeurCDTO>listMesureCC(){
            return valeurService.listValeurC().stream().map(mesure -> modelMapper.map(mesure,ValeurCDTO.class)).collect(Collectors.toList());
         }

        
    @GetMapping("/mesure/{id}")
    public List<ValeurCDTO> getMesureCCByCartedId(@PathVariable Long id) {
        List<ValeurC> mesure = valeurService.listValeurCByMesureCCId(id);
        return mesure.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private ValeurCDTO mapToDTO(ValeurC c) {
        ValeurCDTO valeurDTO  = new ValeurCDTO();
        valeurDTO.setId(c.getId());
        valeurDTO.setValeur(c.getValeur()); 
        return valeurDTO;
    }  
    
    
}

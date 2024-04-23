package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.CritereDTO;
import com.SAFRAN.ESPS.Model.Critere;
import com.SAFRAN.ESPS.Service.CritereService;
import com.SAFRAN.ESPS.Service.ProcedeService;
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
@RequestMapping(value = "/critere")
public class CritereContoller {
     @Autowired
    ProcedeService procedeService;
    @Autowired
    CritereService critereService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public CritereDTO ajouterCritere(@RequestBody CritereDTO critereDto){
        Critere CritereRequest=modelMapper.map(critereDto,Critere.class);
        Critere critere=critereService.ajouterCritere(CritereRequest);
        CritereDTO critereResponse=modelMapper.map(critere,CritereDTO.class);
    return critereResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Critere modifierCritere(@PathVariable("id")Long id,@RequestBody Critere critere){
        Critere newCritere=critereService.modifierCritere(critere);
        return newCritere;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerCritere(@PathVariable("id")Long id){
        critereService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<CritereDTO> getCritereById(@PathVariable("id")Long id){
        Critere critere=critereService.getCritereById(id);
        CritereDTO critereDto=modelMapper.map(critere,CritereDTO.class);
        return ResponseEntity.ok().body(critereDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<CritereDTO>listCritere(){
            return critereService.listCritere().stream().map(critere -> modelMapper.map(critere,CritereDTO.class)).collect(Collectors.toList());
         }

        
    @GetMapping("/okd/{okdId}")
    public List<CritereDTO> getCritereByOkdId(@PathVariable Long okdId) {
        List<Critere> critere = critereService.listCritereByOKDId(okdId);
        return critere.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private CritereDTO mapToDTO(Critere c) {
        CritereDTO critereDTO  = new CritereDTO();
        critereDTO.setId(c.getId());
        critereDTO.setNom(c.getNom());
        critereDTO.setType(c.getType());
        critereDTO.setMin(c.getMin());
        critereDTO.setMax(c.getMax());  
        critereDTO.setEtatactive(c.getEtatactive());
        return critereDTO;
    }  
}
    

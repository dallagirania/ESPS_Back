package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.ModFormationDTO;
import com.SAFRAN.ESPS.DTO.ModProcedeDTO;
import com.SAFRAN.ESPS.Model.ModFormation;
import com.SAFRAN.ESPS.Model.ModProcede;
import com.SAFRAN.ESPS.Service.FormationService;
import com.SAFRAN.ESPS.Service.ModFormationService;
import com.SAFRAN.ESPS.Service.ModProcedeService;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/modprocede")
public class ModProcedeController {
    @Autowired
    ModProcedeService modpormationService;
    @Autowired
    ProcedeService procedeService;
    @Autowired
    private ModelMapper modelMapper;
    
         
    @RequestMapping(method = RequestMethod.POST)
    public ModProcedeDTO ajouterModProcede( @RequestPart("modprocede")ModProcedeDTO  modprocedeDto,@RequestPart("files") MultipartFile[] files){
         ModProcede modprocedeRequest=modelMapper.map(modprocedeDto,ModProcede.class);
         ModProcede modprocede=modpormationService.ajouterModProcede(modprocedeRequest,files);
        ModProcedeDTO modprocedeResponse=modelMapper.map(modprocede,ModProcedeDTO.class);
    return modprocedeResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ModProcede modifierModProcede(@PathVariable("id")Long id,@RequestBody ModProcede modprocede){
        ModProcede newFormation=modpormationService.modifierModProcede(modprocede);
        return newFormation;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerModFormation(@PathVariable("id")Long id){
        modpormationService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<ModProcedeDTO> getModProcedeById(@PathVariable("id")Long id){
        ModProcede modprocede=modpormationService.getModProcedeById(id);
        ModProcedeDTO modprocedeDto=modelMapper.map(modprocede,ModProcedeDTO.class);
        return ResponseEntity.ok().body(modprocedeDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<ModProcedeDTO>listModProcede(){
            return modpormationService.listModProcede().stream().map(modprocede -> modelMapper.map(modprocede,ModProcedeDTO.class)).collect(Collectors.toList());
         }

    @GetMapping("/procede/{procedeId}")
    public List<ModProcedeDTO> getModProcedeByProcedeId(@PathVariable Long procedeId) {
        List<ModProcede> critere = modpormationService.listModProcedeByProcedeId(procedeId);
        return critere.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private ModProcedeDTO mapToDTO(ModProcede c) {
        ModProcedeDTO modprocedeDTO  = new ModProcedeDTO();
        modprocedeDTO.setId(c.getId());
        modprocedeDTO.setDate_fin(c.getDate_fin());
        modprocedeDTO.setDate_init(c.getDate_init());
        modprocedeDTO.setProcede(c.getProcede());
        modprocedeDTO.setFiles(c.getFiles());
        modprocedeDTO.setRev(c.getRev());
        modprocedeDTO.setRef(c.getRef());
        modprocedeDTO.setEtatactive(c.getEtatactive());
        return modprocedeDTO;
    }
     
     @GetMapping("/telechargement/{fileName}")
    public ResponseEntity telechargement(@PathVariable String fileName) {
         System.out.println("44444444444444444444");
         System.out.println(fileName);
        return modpormationService.telechargement(fileName);
    }
        
}
    

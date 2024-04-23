/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.MesureOKDDTO;
import com.SAFRAN.ESPS.Model.MesureOKD;
import com.SAFRAN.ESPS.Service.MesureOKDService;
import com.SAFRAN.ESPS.Service.OKDService;
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
@RequestMapping(value = "/mesureOKD")
public class MesureOKDController {
    @Autowired
    MesureOKDService mesureService;
        @Autowired
    OKDService okdService;
   
    @Autowired
    private ModelMapper modelMapper;
    
     @RequestMapping(method = RequestMethod.POST)
    public MesureOKDDTO ajouterMesureOKD(@RequestBody MesureOKDDTO mesureDto){
        MesureOKD mesureRequest=modelMapper.map(mesureDto,MesureOKD.class);
        MesureOKD mesure=mesureService.ajouterMesureOKD(mesureRequest);
        MesureOKDDTO critereResponse=modelMapper.map(mesure,MesureOKDDTO.class);
    return critereResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public MesureOKD modifierMesureOKD(@PathVariable("id")Long id,@RequestBody MesureOKD mesure){
        MesureOKD newMesureOKD=mesureService.modifierMesureOKD(mesure);
        return newMesureOKD;
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<MesureOKDDTO> getMesureOKDById(@PathVariable("id")Long id){
        MesureOKD mesure=mesureService.getMesureOKDById(id);
        MesureOKDDTO mesureDto=modelMapper.map(mesure,MesureOKDDTO.class);
        return ResponseEntity.ok().body(mesureDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<MesureOKDDTO>listMesureOKD(){
            return mesureService.listMesureOKD().stream().map(mesure -> modelMapper.map(mesure,MesureOKDDTO.class)).collect(Collectors.toList());
         }

        
    @GetMapping("/okd/{id}")
    public List<MesureOKDDTO> getMesureCCByOKDId(@PathVariable Long id) {
        List<MesureOKD> mesure = mesureService.listMesureOKDByOkdId(id);
        return mesure.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private MesureOKDDTO mapToDTO(MesureOKD c) {
        MesureOKDDTO mesureDTO  = new MesureOKDDTO();
        mesureDTO.setId(c.getId());
        mesureDTO.setOkd(c.getOkd());
        mesureDTO.setCommentaire(c.getCommentaire());
        mesureDTO.setDate_add(c.getDate_add());
        mesureDTO.setDate_modif(c.getDate_modif());
         mesureDTO.setVal(c.getVal());
        mesureDTO.setEquipe(c.getEquipe());  
        mesureDTO.setEtatactive(c.getEtatactive());
        mesureDTO.setEvenement(c.getEvenement());
        mesureDTO.setId_qualite(c.getId_qualite());
        mesureDTO.setOperateur(c.getOperateur());
        return mesureDTO;
    }  
}
    





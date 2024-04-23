package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.MesureCCDTO;
import com.SAFRAN.ESPS.DTO.MesureCDTO;
import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.Critere;
import com.SAFRAN.ESPS.Model.MesureCC;
import com.SAFRAN.ESPS.Service.CarteControleService;
import com.SAFRAN.ESPS.Service.MesureCCService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/mesureCC")
public class MesureCCController {
        @Autowired
    MesureCCService mesureService;
        @Autowired
    CarteControleService ccService;
   
    @Autowired
    private ModelMapper modelMapper;
    
     @RequestMapping(method = RequestMethod.POST)
    public MesureCCDTO ajouterMesureCC(@RequestBody MesureCCDTO mesureDto){
        MesureCC mesureRequest=modelMapper.map(mesureDto,MesureCC.class);
        MesureCC mesure=mesureService.ajouterMesureCC(mesureRequest);
        MesureCCDTO critereResponse=modelMapper.map(mesure,MesureCCDTO.class);
    return critereResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public MesureCC modifierMesureCC(@PathVariable("id")Long id,@RequestBody MesureCC mesure){
        MesureCC newMesureCC=mesureService.modifierMesureCC(mesure);
        return newMesureCC;
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<MesureCCDTO> getMesureCCById(@PathVariable("id")Long id){
        MesureCC mesure=mesureService.getMesureCCById(id);
        MesureCCDTO mesureDto=modelMapper.map(mesure,MesureCCDTO.class);
        return ResponseEntity.ok().body(mesureDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<MesureCCDTO>listMesureCC(){
            return mesureService.listMesureCC().stream().map(mesure -> modelMapper.map(mesure,MesureCCDTO.class)).collect(Collectors.toList());
         }

        
    @GetMapping("/carte/{id}")
    public List<MesureCCDTO> getMesureCCByCartedId(@PathVariable Long id) {
        List<MesureCC> mesure = mesureService.listMesureCCByCarteId(id);
        return mesure.stream()
                .map(c -> mapToDTO(c))
                .collect(Collectors.toList());
    }
     private MesureCCDTO mapToDTO(MesureCC c) {
        MesureCCDTO mesureDTO  = new MesureCCDTO();
        mesureDTO.setId(c.getId());
        mesureDTO.setCarte(c.getCarte());
        mesureDTO.setCommentaire(c.getCommentaire());
        mesureDTO.setDate(c.getDate());
         mesureDTO.setVal(c.getVal());
        
        mesureDTO.setMotif_saisie(c.getMotif_saisie());  
        mesureDTO.setEtatactive(c.getEtatactive());
         mesureDTO.setResultat(c.getResultat());
        return mesureDTO;
    }  
     
 
   @GetMapping("/valByCarteControle/{Id}")
    public ResponseEntity<List<Float>> getValByCarteControle(@PathVariable Long Id) {
        List<Float> vals = mesureService.getAllValByCarteControle(Id);
        
        if (vals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(vals, HttpStatus.OK);
    }
    
    @GetMapping("/valWithDateByCarteControle/{Id}")
public ResponseEntity<List<MesureCDTO>> getValWithDateByCarteControle(@PathVariable Long Id) {
    List<MesureCDTO> vals = mesureService.getAllValWithDateByCarteControle(Id);
    
    if (vals.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(vals, HttpStatus.OK);
}
@GetMapping("/valWithDateByCarteControle1/{Id}")
public ResponseEntity<List<Map<String, Object>>> getValWithDateByCarteControle1(@PathVariable Long Id) {
    List<Map<String, Object>> vals = mesureService.getAllValWithDateByCarteControle1(Id);
    
    if (vals.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(vals, HttpStatus.OK);
}
 @GetMapping("/fixed-values/{carteId}")
    public List<Map<String, Object>> getFixedValuesByCarteId(@PathVariable Long carteId) {
        return mesureService.generateFixedValuesByCarteId(carteId);
    }
}
    



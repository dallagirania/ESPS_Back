package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.ActiviteDTO;
import com.SAFRAN.ESPS.DTO.OkdDTO;
import com.SAFRAN.ESPS.Model.Activite;
import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Service.OKDService;
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
@RequestMapping(value = "/okd")
public class OKDController {
    
    @Autowired
    ProcedeService procedeService;
    @Autowired
    OKDService OKDService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public OkdDTO ajouterProcede(@RequestBody OkdDTO okdDto){
        OKD OKDRequest=modelMapper.map(okdDto,OKD.class);
        OKD okd=OKDService.ajouterOKD(OKDRequest);
        OkdDTO procedeResponse=modelMapper.map(okd,OkdDTO.class);
    return procedeResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public OKD modifierOKD(@PathVariable("id")Long id,@RequestBody OKD okd){
        OKD newOKD=OKDService.modifierOKD(okd);
        return newOKD;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerOKD(@PathVariable("id")Long id){
        OKDService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<OkdDTO> getOKDById(@PathVariable("id")Long id){
        OKD okd=OKDService.getOKDById(id);
        OkdDTO okdDto=modelMapper.map(okd,OkdDTO.class);
        return ResponseEntity.ok().body(okdDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<OkdDTO>listOKD(){
            return OKDService.listOKD().stream().map(okd -> modelMapper.map(okd,OkdDTO.class)).collect(Collectors.toList());
         }
        
        //listActiviteByUniteId
        
    @GetMapping("/procede/{procedeId}")
    public List<OkdDTO> getOKDByProcedeId(@PathVariable Long procedeId) {
        List<OKD> okds = OKDService.listOKDByProcedeId(procedeId);
        return okds.stream()
                .map(okd -> mapToDTO(okd))
                .collect(Collectors.toList());
    }
     private OkdDTO mapToDTO(OKD okd) {
        OkdDTO okdDTO = new OkdDTO();
        okdDTO.setId(okd.getId());
        okdDTO.setNom(okd.getNom());
        okdDTO.setRef(okd.getRef());
        okdDTO.setDesignation(okd.getDesignation());
        okdDTO.setDate_init(okd.getDate_init());
        okdDTO.setEtatactive(okd.getEtatactive());
        return okdDTO;
    }

}
    

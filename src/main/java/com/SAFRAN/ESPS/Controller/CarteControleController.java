package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.CarteControleDTO;
import com.SAFRAN.ESPS.DTO.OkdDTO;
import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Service.CarteControleService;
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
@RequestMapping(value = "/cc")
public class CarteControleController {
     @Autowired
    ProcedeService procedeService;
    @Autowired
    CarteControleService ccService;
    @Autowired
    private ModelMapper modelMapper;
    
      
     @RequestMapping(method = RequestMethod.POST)
    public CarteControleDTO ajouterCC(@RequestBody CarteControleDTO ccDto){
        CarteControle ccRequest=modelMapper.map(ccDto,CarteControle.class);
        CarteControle cc=ccService.ajouterCarteControle(ccRequest);
        CarteControleDTO  CCResponse=modelMapper.map(cc,CarteControleDTO.class);
    return CCResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public CarteControle modifierCarteControle(@PathVariable("id")Long id,@RequestBody CarteControle cc){
        CarteControle newCarteControle=ccService.modifierCarteControle(cc);
        return newCarteControle;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerCarteControle(@PathVariable("id")Long id){
        ccService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<CarteControleDTO> getCarteControleById(@PathVariable("id")Long id){
        CarteControle cc=ccService.getCarteControleById(id);
        CarteControleDTO ccDto=modelMapper.map(cc,CarteControleDTO.class);
        return ResponseEntity.ok().body(ccDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<CarteControleDTO>listCarteControle(){
            return ccService.listCarteControle().stream().map(cc -> modelMapper.map(cc,CarteControleDTO.class)).collect(Collectors.toList());
         }

        
     @GetMapping("/procede/{procedeId}")
    public List<CarteControleDTO> getCarteControleByProcedeId(@PathVariable Long procedeId) {
        List<CarteControle> Cartes = ccService.listCarteControleByProcedeId(procedeId);
        return Cartes.stream()
                .map(cc -> mapToDTO(cc))
                .collect(Collectors.toList());
    }
     private CarteControleDTO mapToDTO(CarteControle cc) {
         CarteControleDTO ccDTO  = new CarteControleDTO();
        ccDTO.setId(cc.getId());
        ccDTO.setNom(cc.getNom());
        ccDTO.setRef(cc.getRef());
        ccDTO.setFonction(cc.getFonction());
        ccDTO.setNb_valeur(cc.getNb_valeur());
        ccDTO.setMax(cc.getMax());
        ccDTO.setMin(cc.getMin());
        ccDTO.setEtatactive(cc.getEtatactive());
        return ccDTO;
    }   
}
    

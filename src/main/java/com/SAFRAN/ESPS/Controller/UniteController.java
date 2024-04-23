package com.SAFRAN.ESPS.controller;

import com.SAFRAN.ESPS.Service.SiteService;
import com.SAFRAN.ESPS.Service.UniteService;
import com.SAFRAN.ESPS.Model.Unite;
import com.SAFRAN.ESPS.DTO.UniteDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/unite")
public class UniteController {
    
    @Autowired
    UniteService uniteService;
    @Autowired
    SiteService siteService;
    @Autowired
    private ModelMapper modelMapper;
    
      
    @RequestMapping(method = RequestMethod.POST)
    public UniteDTO ajouterUnite(@RequestBody UniteDTO uniteDto){
        Unite uniteRequest=modelMapper.map(uniteDto,Unite.class);
        Unite unite=uniteService.ajouterUnite(uniteRequest);
        UniteDTO uniteResponse=modelMapper.map(unite,UniteDTO.class);
    return uniteResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Unite modifierUnite(@PathVariable("id")Long id,@RequestBody Unite unite){
        Unite newUnite=uniteService.modifierUnite(unite);
        return newUnite;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerUnite(@PathVariable("id")Long id){
        uniteService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<UniteDTO> getUniteById(@PathVariable("id")Long id){
        Unite unite=uniteService.getUniteById(id);
        UniteDTO offresDto=modelMapper.map(unite,UniteDTO.class);
        return ResponseEntity.ok().body(offresDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<UniteDTO>listUnite(){
            return uniteService.listUnite().stream().map(unite -> modelMapper.map(unite,UniteDTO.class)).collect(Collectors.toList());
         }

}
    


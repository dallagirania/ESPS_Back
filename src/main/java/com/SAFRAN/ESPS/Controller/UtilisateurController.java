package com.SAFRAN.ESPS.Controller;

import com.SAFRAN.ESPS.DTO.UtilisateurDTO;
import com.SAFRAN.ESPS.Model.Utilisateur;
import com.SAFRAN.ESPS.Repository.UtilisateurRepository;
import com.SAFRAN.ESPS.Service.UniteService;
import com.SAFRAN.ESPS.Service.UtilisateurService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
public class UtilisateurController {
    
    @Autowired
    public UtilisateurController(UtilisateurRepository candidatRepository) {this.proprietaireRepository= candidatRepository;}
    @Autowired
    private UtilisateurRepository proprietaireRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
       @PostMapping(path = "loginUser")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Utilisateur user) {
    HashMap<String, Object> response = new HashMap<>();

    Utilisateur userFromDB = proprietaireRepository.findIdByMatricule(user.getMatricule());

    if (userFromDB == null) {
        response.put("message", "User not found !");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    } else {
        // Vérifier si le mot de passe saisi correspond au mot de passe enregistré
        if (bCryptPasswordEncoder.matches(user.getMdp(), userFromDB.getMdp())) {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("message", "Mot de passe incorrect !");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}


    
      @PostMapping(path = "registerUser")
    public ResponseEntity<?> registerUser(@RequestBody Utilisateur user) {
        Map<String, Object> response = new HashMap<>();

        if (proprietaireRepository.existsByMatricule(user.getMatricule())) {
            response.put("message", "Matricule déjà existant !");
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }

        user.setMdp(this.bCryptPasswordEncoder.encode(user.getMdp()));
        Utilisateur savedUser = proprietaireRepository.save(user);
        response.put("message", "Utilisateur enregistré avec succès !");
        response.put("user", savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    
    @Autowired
    UtilisateurService userService;
    @Autowired
    UniteService uniteService;
    @Autowired
    private ModelMapper modelMapper;
    
      
    @RequestMapping(method = RequestMethod.POST)
    public UtilisateurDTO ajouterUser(@RequestBody UtilisateurDTO userDto){
        Utilisateur userRequest=modelMapper.map(userDto,Utilisateur.class);
        Utilisateur user=userService.ajouterUser(userRequest);
        UtilisateurDTO userResponse=modelMapper.map(user,UtilisateurDTO.class);
    return userResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Utilisateur modifierUtilisateur(@PathVariable("id")Long id,@RequestBody Utilisateur user){
        Utilisateur newUser=userService.modifierUser(user);
        return newUser;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerActivite(@PathVariable("id")Long id){
        userService.supprimerById(id);
    }


   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public ResponseEntity<UtilisateurDTO> getUserById(@PathVariable("id")Long id){
        Utilisateur user=userService.getUserById(id);
        UtilisateurDTO userDto=modelMapper.map(user,UtilisateurDTO.class);
        return ResponseEntity.ok().body(userDto);
}
    
    
    @RequestMapping(method = RequestMethod.GET)
        public List<UtilisateurDTO>listUser(){
            return userService.listUser().stream().map(user -> modelMapper.map(user,UtilisateurDTO.class)).collect(Collectors.toList());
         }
   
     
    @RequestMapping(value = "/mod",method = RequestMethod.GET)
     public List<UtilisateurDTO>listUserMOD(){
            return userService.listUserMOD().stream().map(user -> modelMapper.map(user,UtilisateurDTO.class)).collect(Collectors.toList());
         }
    
    @RequestMapping(value = "/RUO",method = RequestMethod.GET)
     public List<UtilisateurDTO>listUserRUO(){
            return userService.listUserRUO().stream().map(user -> modelMapper.map(user,UtilisateurDTO.class)).collect(Collectors.toList());
         }

}
 

package com.SAFRAN.ESPS.controller;

import com.SAFRAN.ESPS.Service.RoleService;
import com.SAFRAN.ESPS.Model.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.POST)
    public Role ajouterRole(@RequestBody Role role){
        return roleService.ajouterRole(role);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Role modifierRole(@PathVariable("id")Long id,@RequestBody Role role){
        Role newRole=roleService.modifierRole(role);
        return newRole;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Role>getSiteById(@PathVariable("id")Long id){
        Optional<Role>role=roleService.getRoleById(id);
        return role;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerRole(@PathVariable("id")Long id){
        roleService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Role> listRole(){
        return roleService.listRole();
    }

}
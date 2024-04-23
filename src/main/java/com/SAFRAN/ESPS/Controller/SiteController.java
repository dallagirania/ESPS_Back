package com.SAFRAN.ESPS.controller;

import com.SAFRAN.ESPS.Service.SiteService;
import com.SAFRAN.ESPS.Model.Site;
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
@RequestMapping(value = "/site")

public class SiteController {
    @Autowired
    SiteService siteService;

    @RequestMapping(method = RequestMethod.POST)
    public Site ajouterSite(@RequestBody Site site){
        return siteService.ajouterSite(site);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Site modifierSite(@PathVariable("id")Long id,@RequestBody Site site){
        Site newSite=siteService.modifierSite(site);
        return newSite;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Site>getSiteById(@PathVariable("id")Long id){
        Optional<Site>site=siteService.getSiteById(id);
        return site;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerSite(@PathVariable("id")Long id){
        siteService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Site> listSite(){
        return siteService.listSite();
    }

}
package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Site;
import com.SAFRAN.ESPS.Repository.SiteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    SiteRepository siteRepository;
    
    @Override
    public Site ajouterSite(Site site) {
        System.out.println(site.getImage());
        return siteRepository.save(site);
    }

    @Override
    public Site modifierSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public List<Site> listSite() {
        return siteRepository.findByEtatactive(true);
    }

    @Override
    public void supprimerById(Long id) {
        siteRepository.deleteById(id);
        
    }
    @Override
     public Optional<Site> getSiteById(Long id) {
        return siteRepository.findById(id);
    }
    

    
 
}

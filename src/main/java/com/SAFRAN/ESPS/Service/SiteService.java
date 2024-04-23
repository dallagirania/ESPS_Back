package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Site;
import java.util.List;
import java.util.Optional;


public interface SiteService {
    Site ajouterSite(Site site);
    Site modifierSite(Site site);
    List<Site> listSite();
    void supprimerById(Long id);
    Optional<Site> getSiteById(Long id);
}

package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Site;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
  
    public List<Site> findByEtatactive(Boolean actif);
}

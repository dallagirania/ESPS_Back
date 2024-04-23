package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Unite;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Long> {
   
    Unite findById(long id);
    boolean existsById(long id);
    public List<Unite> findByEtatactive(Boolean actif);
    
}


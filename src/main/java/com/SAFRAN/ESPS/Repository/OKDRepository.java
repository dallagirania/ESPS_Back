package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Activite;
import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Model.Procede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OKDRepository extends JpaRepository<OKD, Long> {
   
    OKD findIdByRef(String ref);
    boolean existsByRef(String ref);
    
    public List<OKD> findByEtatactive(Boolean actif);
    
    public List<OKD> findByProcedeId(long id);
    
}

package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Critere;
import com.SAFRAN.ESPS.Model.OKD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Long> {
   
    Critere findIdById(long id);
    boolean existsById(long id);
    public List<Critere> findByEtatactive(Boolean actif);
    public List<Critere> findByOkdId(long id);
       
    
}

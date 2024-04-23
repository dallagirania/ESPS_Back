package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Formation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository  extends JpaRepository <Formation, Long> {
   
    Formation findIdById(long id);
    boolean existsById(long id);
    public List<Formation> findByEtatactive(Boolean actif);
    public List<Formation> findByEtatactiveAndHabilitationId(Boolean actif,long id);
    public List<Formation> findByHabilitationId(long id);
}


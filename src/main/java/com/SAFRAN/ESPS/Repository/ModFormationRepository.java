package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Formation;
import com.SAFRAN.ESPS.Model.ModFormation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModFormationRepository extends JpaRepository <ModFormation, Long> {
   
    ModFormation findIdById(long id);
    boolean existsById(long id);
    public List<ModFormation> findByEtatactive(Boolean actif);
    public List<ModFormation> findByFormationId(long id);
    List<ModFormation> findByFormation(Formation formation);
}
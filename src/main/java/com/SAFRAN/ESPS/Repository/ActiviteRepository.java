
package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Activite;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
   
    Activite findIdById(long id);
    boolean existsById(long id);
    public List<Activite> findByEtatactive(Boolean actif);
    public List<Activite> findByEtatactiveAndUniteId(Boolean actif,long id);
}
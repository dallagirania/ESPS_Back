package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Atelier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
   
    Atelier findIdById(long id);
    boolean existsById(long id);
    
    public List<Atelier> findByEtatactive(Boolean actif);
    public List<Atelier> findByEtatactiveAndActiviteId(Boolean actif,long id);
    
}

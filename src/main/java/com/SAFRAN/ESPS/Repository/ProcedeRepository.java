package com.SAFRAN.ESPS.Repository;
import com.SAFRAN.ESPS.Model.Procede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedeRepository extends JpaRepository<Procede, Long> {
   
    Procede findIdByRef(String ref);
    boolean existsByRef(String ref);
    
    public List<Procede> findByEtatactive(Boolean actif);
    
}

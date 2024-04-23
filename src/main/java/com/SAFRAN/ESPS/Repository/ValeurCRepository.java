package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.ValeurC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValeurCRepository extends JpaRepository <ValeurC, Long> {
     ValeurC findIdById(long id);
     boolean existsById(long id);
     public List<ValeurC> findByMesureC(long id);
}

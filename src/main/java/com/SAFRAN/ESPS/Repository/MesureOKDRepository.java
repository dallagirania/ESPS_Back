package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.MesureOKD;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesureOKDRepository extends JpaRepository <MesureOKD, Long> {
     MesureOKD findIdById(long id);
     boolean existsById(long id);
     public List<MesureOKD> findByEtatactive(Boolean actif);
     public List<MesureOKD> findByOkdId(long id);
}

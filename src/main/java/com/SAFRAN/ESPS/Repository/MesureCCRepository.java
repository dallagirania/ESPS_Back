package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.MesureCC;
import com.SAFRAN.ESPS.Model.ModFormation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MesureCCRepository extends JpaRepository <MesureCC, Long> {
     MesureCC findIdById(long id);
     boolean existsById(long id);
     public List<MesureCC> findByEtatactive(Boolean actif);
     public List<MesureCC> findByCarteId(long id);
  //  public List<Float> findByCarteId(long id);
   /* @Query(value = "SELECT m.val FROM mesureCC m WHERE m.carte_id = :carteId", nativeQuery = true)
    List<Float> findValByCarteId(@Param("carteId") Long carteId);*/
     @Query("SELECT DISTINCT m.date FROM MesureCC m WHERE m.carte.id = :carteId")
    List<String> findDatesByCarteId(@Param("carteId") Long carteId);
    @Query("SELECT c.min FROM CarteControle c WHERE c.id = :carteId")
    String findMinValueByCarteId(@Param("carteId") Long carteId);


}

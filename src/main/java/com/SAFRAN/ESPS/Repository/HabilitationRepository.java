package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.Habilitation;
import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Model.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilitationRepository extends JpaRepository<Habilitation, Long> {
   
    Habilitation findIdById(long id);
    boolean existsById(long id);
    public List<Habilitation> findByEtatactive(Boolean actif);
    public List<Habilitation> findByProcedeId(long id);
    
    @Query("SELECT f.utilisateur FROM Formation f WHERE f.habilitation.id = :habilitationId AND f.etatactive = true ")
    List<Utilisateur> findUsersByHabilitationId(@Param("habilitationId") Long habilitationId);

    
    @Query("SELECT f.utilisateur FROM Formation f WHERE f.habilitation.id = :habilitationId")
    List<Utilisateur> findAllUsersByHabilitationId(@Param("habilitationId") Long habilitationId);

}
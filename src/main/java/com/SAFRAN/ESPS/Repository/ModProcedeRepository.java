/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.ModProcede;
import com.SAFRAN.ESPS.Model.Procede;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModProcedeRepository extends JpaRepository <ModProcede, Long> {
   
    ModProcede findIdById(long id);
    boolean existsById(long id);
    public List<ModProcede> findByEtatactive(Boolean actif);
    public List<ModProcede> findByProcedeId(long id);
     List<ModProcede> findByProcede(Procede procede);
}

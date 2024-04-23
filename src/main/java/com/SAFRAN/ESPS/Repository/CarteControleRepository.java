/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.Repository;

import com.SAFRAN.ESPS.Model.CarteControle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteControleRepository extends JpaRepository<CarteControle, Long> {
   
    CarteControle findIdByRef(String ref);
    boolean existsByRef(String ref);
    
    public List<CarteControle> findByEtatactive(Boolean actif);
       public List<CarteControle> findByProcedeId(long id);
    
}


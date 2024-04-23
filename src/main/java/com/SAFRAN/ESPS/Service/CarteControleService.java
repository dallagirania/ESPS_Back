package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.CarteControle;
import java.util.List;


public interface CarteControleService {
     CarteControle ajouterCarteControle(CarteControle cc);
    CarteControle modifierCarteControle(CarteControle cc);
    List<CarteControle> listCarteControle();
    List<CarteControle> listCarteControleByProcedeId(long id);
    void supprimerById(Long id);
    CarteControle getCarteControleById(Long id); 
}


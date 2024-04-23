package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Repository.CarteControleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteControleServiceImpl implements CarteControleService{
     @Autowired
    CarteControleRepository ccRepository;

    @Override
    public CarteControle ajouterCarteControle(CarteControle cc) {
        return ccRepository.save(cc);
    }

    @Override
    public CarteControle modifierCarteControle(CarteControle cc) {
        return ccRepository.save(cc);
    }

    @Override
    public List<CarteControle> listCarteControle() {
        return ccRepository.findByEtatactive(true);
    }
      @Override
    public List<CarteControle> listCarteControleByProcedeId(long id) {
        return ccRepository.findByProcedeId(id);
    }
 

 
    

    @Override
    public void supprimerById(Long id) {
        ccRepository.deleteById(id);

    }
    
     @Override
    public CarteControle getCarteControleById(Long id) {
        Optional<CarteControle> cc = ccRepository.findById(id);

        if(cc.isPresent()) {
            return cc.get();
        }
        return null;
    }

    
}



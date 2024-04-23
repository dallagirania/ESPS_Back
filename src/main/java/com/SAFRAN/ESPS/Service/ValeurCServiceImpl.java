package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.ValeurC;
import com.SAFRAN.ESPS.Repository.ValeurCRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValeurCServiceImpl implements ValeurCService {
     @Autowired
    ValeurCRepository    valeurRepository;

    public  ValeurC ajouterValeurC(ValeurC valeur) {
        return valeurRepository.save(valeur);
    }

    @Override
    public ValeurC modifierValeurC(ValeurC valeur) {
        return valeurRepository.save(valeur);
    }

    @Override
    public List<ValeurC> listValeurC() {
        return valeurRepository.findAll();
    }

 
     @Override
    public List<ValeurC> listValeurCByMesureCCId(long id) {
        return valeurRepository.findByMesureC(id);
    }
 
    

    
     @Override
    public ValeurC getValeurCById(Long id) {
        Optional<ValeurC> valeur = valeurRepository.findById(id);

        if(valeur.isPresent()) {
            return valeur.get();
        }
        return null;
    }

}

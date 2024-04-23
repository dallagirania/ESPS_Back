package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.Unite;
import com.SAFRAN.ESPS.Repository.UniteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniteServiceImpl implements UniteService{

    @Autowired
    UniteRepository uniteRepository;

    @Override
    public Unite ajouterUnite(Unite unite) {
        return uniteRepository.save(unite);
    }

    @Override
    public Unite modifierUnite(Unite unite) {
        return uniteRepository.save(unite);
    }

    @Override
    public List<Unite> listUnite() {
        return uniteRepository.findByEtatactive(true);
    }

  //@Override
    // public Optional<Unite> getUniteById(Long id) {
      //  return uniteRepository.findById(id);
    //}
    

    @Override
    public void supprimerById(Long id) {
        uniteRepository.deleteById(id);

    }
    
     @Override
    public Unite getUniteById(Long id) {
        Optional<Unite> unite = uniteRepository.findById(id);

        if(unite.isPresent()) {
            return unite.get();
        }
        return null;
    }
    
}

package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.OKD;
import com.SAFRAN.ESPS.Model.Procede;
import com.SAFRAN.ESPS.Repository.OKDRepository;
import com.SAFRAN.ESPS.Repository.ProcedeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OKDServiceImpl implements OKDService{

    @Autowired
    OKDRepository okdRepository;

    @Override
    public OKD ajouterOKD(OKD okd) {
        return okdRepository.save(okd);
    }

    @Override
    public OKD modifierOKD(OKD okd) {
        return okdRepository.save(okd);
    }

    @Override
    public List<OKD> listOKD() {
        return okdRepository.findByEtatactive(true);
    }

  @Override
    public List<OKD> listOKDByProcedeId(long id) {
        return okdRepository.findByProcedeId(id);
    }
 
    

    @Override
    public void supprimerById(Long id) {
        okdRepository.deleteById(id);

    }
    
     @Override
    public OKD getOKDById(Long id) {
        Optional<OKD> okd = okdRepository.findById(id);

        if(okd.isPresent()) {
            return okd.get();
        }
        return null;
    }

    
}


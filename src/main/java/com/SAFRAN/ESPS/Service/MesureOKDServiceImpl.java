package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.MesureOKD;
import com.SAFRAN.ESPS.Repository.MesureOKDRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesureOKDServiceImpl implements MesureOKDService{
     @Autowired
    MesureOKDRepository    mesureRepository;

    @Override
    public MesureOKD ajouterMesureOKD(MesureOKD mesure) {
        return mesureRepository.save(mesure);
    }

    @Override
    public MesureOKD modifierMesureOKD(MesureOKD mesure) {
        return mesureRepository.save(mesure);
    }

    @Override
    public List<MesureOKD> listMesureOKD() {
        return mesureRepository.findByEtatactive(true);
    }

 
     @Override
    public List<MesureOKD> listMesureOKDByOkdId(long id) {
        return mesureRepository.findByOkdId(id);
    }
 
    

    
     @Override
    public MesureOKD getMesureOKDById(Long id) {
        Optional<MesureOKD> mesure = mesureRepository.findById(id);

        if(mesure.isPresent()) {
            return mesure.get();
        }
        return null;
    }
}

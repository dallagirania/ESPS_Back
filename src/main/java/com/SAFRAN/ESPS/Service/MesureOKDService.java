package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.MesureOKD;
import java.util.List;

public interface MesureOKDService {
    MesureOKD ajouterMesureOKD(MesureOKD okd);
    MesureOKD modifierMesureOKD(MesureOKD okd);
    List<MesureOKD> listMesureOKD();
    List<MesureOKD> listMesureOKDByOkdId(long id);
    MesureOKD getMesureOKDById(Long id);  
}

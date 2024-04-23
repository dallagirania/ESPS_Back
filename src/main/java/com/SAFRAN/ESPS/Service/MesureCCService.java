package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.DTO.MesureCCDTO;
import com.SAFRAN.ESPS.DTO.MesureCDTO;
import com.SAFRAN.ESPS.Model.CarteControle;
import com.SAFRAN.ESPS.Model.MesureCC;
import java.util.List;
import java.util.Map;


public interface MesureCCService {
    MesureCC ajouterMesureCC(MesureCC cc);
    MesureCC modifierMesureCC(MesureCC cc);
    List<MesureCC> listMesureCC();
    List<MesureCC> listMesureCCByCarteId(long id);
    MesureCC getMesureCCById(Long id);  
    List<Float> getAllValByCarteControle(long id) ;
    List<MesureCDTO> getAllValWithDateByCarteControle(long id);
    List<Map<String, Object>> getAllValWithDateByCarteControle1(long id);
    List<Map<String, Object>> generateFixedValuesByCarteId(Long carteId);
   // List<Float> getValByCarteId(Long id);
}

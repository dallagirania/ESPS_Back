package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.DTO.MesureCCDTO;
import com.SAFRAN.ESPS.DTO.MesureCDTO;
import com.SAFRAN.ESPS.Model.MesureCC;
import com.SAFRAN.ESPS.Repository.MesureCCRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesureCCServiceImpl implements MesureCCService {
     @Autowired
    MesureCCRepository    mesureRepository;

    @Override
    public MesureCC ajouterMesureCC(MesureCC mesure) {
        return mesureRepository.save(mesure);
    }

    @Override
    public MesureCC modifierMesureCC(MesureCC mesure) {
        return mesureRepository.save(mesure);
    }

    @Override
    public List<MesureCC> listMesureCC() {
        return mesureRepository.findByEtatactive(true);
    }

 
     @Override
    public List<MesureCC> listMesureCCByCarteId(long id) {
        return mesureRepository.findByCarteId(id);
    }   
     @Override
    public MesureCC getMesureCCById(Long id) {
        Optional<MesureCC> mesure = mesureRepository.findById(id);

        if(mesure.isPresent()) {
            return mesure.get();
        }
        return null;
    }
@Override
   public List<Float> getAllValByCarteControle(long id) {
        List<MesureCC> mesures = mesureRepository.findByCarteId(id);
        
        List<Float> result = new ArrayList<>();
        
        for (MesureCC mesure : mesures) {
            result.addAll(mesure.getVal());
        }
        
        return result;
    }
  /* @Override
   public List<MesureCDTO> getAllValWithDateByCarteControle(long id) {
    List<MesureCC> mesures = mesureRepository.findByCarteId(id);
    
    List<MesureCDTO> result = new ArrayList<>();
    
    for (MesureCC mesure : mesures) {
        MesureCDTO dto = new MesureCDTO();
        dto.setDate(mesure.getDate());
        dto.setVal(mesure.getVal());
        result.add(dto);
    }
    
    return result;
}*/
  /* @Override
public List<MesureCDTO> getAllValWithDateByCarteControle(long id) {
    List<MesureCC> mesures = mesureRepository.findByCarteId(id);
    
    List<MesureCDTO> result = new ArrayList<>();
    
    for (MesureCC mesure : mesures) {
        List<Float> values = mesure.getVal();
        for (Float value : values) {
            MesureCDTO dto = new MesureCDTO();
            dto.setDate(mesure.getDate());
            dto.setVal(Collections.singletonList(value));
            result.add(dto);
        }
    }
    
    return result;
}*/
@Override
public List<MesureCDTO> getAllValWithDateByCarteControle(long id) {
    List<MesureCC> mesures = mesureRepository.findByCarteId(id);
    
    List<MesureCDTO> result = new ArrayList<>();
    
    for (MesureCC mesure : mesures) {
        MesureCDTO dto = new MesureCDTO();
        
        List<MesureCDTO.MeasureValueDTO> measureValues = mesure.getVal().stream()
                .map(value -> {
                    MesureCDTO.MeasureValueDTO measureValueDTO = new MesureCDTO.MeasureValueDTO();
                    measureValueDTO.setValue(value);
                    measureValueDTO.setDate(mesure.getDate());
                    return measureValueDTO;
                })
                .collect(Collectors.toList());
        
        dto.setMeasures(measureValues);
        result.add(dto);
    }
    
    return result;
}
@Override
public List<Map<String, Object>> getAllValWithDateByCarteControle1(long id) {
    List<MesureCC> mesures = mesureRepository.findByCarteId(id);
    
    List<Map<String, Object>> result = new ArrayList<>();
    
    for (MesureCC mesure : mesures) {
        for (int i = 0; i < mesure.getVal().size(); i++) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("value", mesure.getVal().get(i));
            entry.put("date", mesure.getDate());
            result.add(entry);
        }
    }
    
    return result;
}
@Override
 public List<Map<String, Object>> generateFixedValuesByCarteId(Long carteId) {
        List<String> dates = mesureRepository.findDatesByCarteId(carteId);
        String minValueStr = mesureRepository.findMinValueByCarteId(carteId);
        Float minValue = Float.parseFloat(minValueStr);
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (String date : dates) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("date", date);
            dataMap.put("value", minValue);
            resultList.add(dataMap);
        }

        return resultList;
    } 
 
}





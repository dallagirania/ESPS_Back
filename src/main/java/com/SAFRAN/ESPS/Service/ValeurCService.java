
package com.SAFRAN.ESPS.Service;

import com.SAFRAN.ESPS.Model.ValeurC;
import java.util.List;

public interface ValeurCService {
    
    ValeurC ajouterValeurC(ValeurC cc);
    ValeurC modifierValeurC(ValeurC cc);
    List<ValeurC> listValeurC();
    List<ValeurC> listValeurCByMesureCCId(long id);
    ValeurC getValeurCById(Long id);  
}

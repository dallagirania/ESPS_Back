/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAFRAN.ESPS.DTO;

import com.SAFRAN.ESPS.Model.CarteControle;
import java.util.List;
import lombok.Data;

@Data
public class MesureCDTO {
   
 //   private String date; 
  //  private List<Float> val;
   
private List<MeasureValueDTO> measures;
    
    @Data
    public static class MeasureValueDTO {
        private Float value;
        private String date;
    }
}


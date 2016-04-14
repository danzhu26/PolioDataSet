/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danielproject;

import com.google.gson.Gson;
import java.net.URL;

/**
 *
 * @author csstudent
 */
public class Dataset {
  private Immunizations[] dimension;
    private Info[] fact;
    
    public Immunizations[] getDimension() {
        return dimension;
    }
    public Info[] getFact(){
        return fact;
    }
    
    @ Override
    public String toString(){
        String var = null;
        for(int i=0; i= fact.length; i++){
            System.out.println(fact[i].toString());
            var i = fact[i].getValue();
        }
        return var;
    }
}  


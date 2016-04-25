/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danielproject;

/**
 *
 * @author csstudent
 */
public class DataSet {
     private Immunizations[] dimension;
    private Info[] fact;
    
    public Immunizations[] getDimension() {
        return dimension;
    }
    public Info[] getInfo(){
        return fact;
    }
    
    @ Override
    public String toString(){
        int var = 0;
        for(int i=0; i< fact.length; i++){
            System.out.println(fact[i].toString());
            var = fact[i].getValue();
        }
        return var + "";
    }

    Iterable<Info> returnInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

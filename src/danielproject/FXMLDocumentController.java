/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danielproject;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author csstudent
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private BarChart barChart;
    
    //@FXML
    //private void handleButtonAction(ActionEvent event) {
        //System.out.println("You clicked me!");
        //barChart.setText("Hello World!");
    //}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL myurl = null;
        try {
            myurl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(myurl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson gson = new Gson();
        DataSet dS = gson.fromJson(str, DataSet.class);
        
        System.out.println("Polio Immunizations in 1980");
        System.out.println(dS);
        
        
        Info[] infos = dS.getInfo();
         
        XYChart.Series<String, Number> countries = new XYChart.Series();
        countries.setName("Countries of the World");
       
    
    
      for (Info test : infos) {
            if(test.getDim().getCOUNTRY() != null){
                countries.getData().add(new XYChart.Data(test.getDim().getCOUNTRY(), test.getValue()));
            }
         
        }
         barChart.getData().add(countries);
         
    
    }
}

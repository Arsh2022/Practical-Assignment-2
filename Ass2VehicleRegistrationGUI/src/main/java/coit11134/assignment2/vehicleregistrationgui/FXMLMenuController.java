/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

/**
 *
 * @author salah
 */

//Controller class for the menu scene 
public class FXMLMenuController {
    
    
    final static int REG_OWNER = 1;
    final static int REG_VEHICLE = 2;
    final static int SEARCH_OWNER = 3;
    final static int SEARCH_VEHICLE = 4;
    
     
    //Action event handler for the Enter Owner Details button 
    @FXML
    private void handleButtonOwnerRecAction(ActionEvent event) throws Exception {
        System.out.println("You clicked on Owner Registration!");
        // Switch to the Owner Registration scene 
        try {
            App.setRoot("FXMLOwnerRecord");
        } catch (IOException e){
           System.out.println(e); 
        }
            
    }
    
    //Action event handler for the Enter Vehicle Details button 
    @FXML
    private void handleButtonVehicleRecAction(ActionEvent event) throws Exception {
        System.out.println("You clicked on Vehicle Registration!");
        // Switch to the Vehicle Registration scene 
        try {
           App.setRoot("FXMLVehicleRecord");
        } catch (IOException e){
            System.out.println(e); 
        }
    }
    
    //Action event handler for the Search Owner button 
    @FXML
    private void handleButtonOwnerSrchAction(ActionEvent event) throws Exception {
        System.out.println("You clicked on Search Owner!");
        // Switch to the Search Owner scene 
        try {
            App.setRoot("FXMLOwnerSearch");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    //Action event handler for the Search Vehicle button 
    @FXML
    private void handleButtonVehicleSrchAction(ActionEvent event) throws Exception {
        System.out.println("You clicked on Search Vehicle!");
         //Switch to the Search Vehicle scene 
         try {
            App.setRoot("FXMLVehicleSearch");
         } catch (IOException e){
           System.out.println(e); 
         }
        
    }
    
    //Action event handler for the Exit button
    @FXML
    private void handleButtonExitAction(ActionEvent event) {
        System.out.println("You clicked on Exit!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
       
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
               
                App.exit();
            }
        });
        
    }
    
}


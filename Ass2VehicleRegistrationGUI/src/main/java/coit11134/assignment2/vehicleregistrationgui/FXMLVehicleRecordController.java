/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arsh kataria  <arsh.kataria@cqumail.com>
 */
public class FXMLVehicleRecordController implements Initializable {

    @FXML
    private TextField txtPlateNo;
    @FXML
    private TextField txtOwnerID;
    @FXML
    private TextField txtOwnerABN;
    @FXML
    private TextField txtMake;
    @FXML
    private TextField txtModel;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtLoadCapacity;
    @FXML
    private TextField txtPlateNo1;
    @FXML
    private TextField txtOwnerID1;
    @FXML
    private TextField txtOwnerABN1;
    @FXML
    private TextField txtMake1;
    @FXML
    private TextField txtModel1;
    @FXML
    private TextField txtYear1;
    @FXML
    private TextField txtNoofSeat;

    DataHandler data; //Instance variable to hold a reference to the DataHandler object

    private void clearAllFields()
    {
        //heavy vehicle
        txtPlateNo.clear();
        txtOwnerID.clear();
        txtOwnerABN.clear();
        txtMake.clear();
        txtModel.clear();
        txtYear.clear();
        txtLoadCapacity.clear();
        
        //Light Vehicle
        txtPlateNo1.clear();
        txtOwnerID1.clear();
        txtMake1.clear();
        txtModel1.clear();
        txtYear1.clear();
        txtOwnerABN1.clear();
        txtNoofSeat.clear();
    }    
    
    //Method to validate the input values. returns an error message
    private String validationMessage(boolean isHeavy)
    {
        String strOutput = ""; //The message remains empty if all inputs are valid 
        
        if (isHeavy)
        {    
            if (txtPlateNo.getText().equals(""))
                strOutput += "Plate number is a mandatory field.\n";   
            
            if (txtOwnerID.getText().equals("")) 
                strOutput += "Owner ID is a mandatory field.\n";
            
            if (txtOwnerABN.getText().equals("") || !Validation.isNumeric(txtOwnerABN.getText())) 
                strOutput += "Owner ABN is a mandatory field and must be numeric.\n";

            if (txtMake.getText().equals(""))
                strOutput += "Make is a mandatory field.\n";   

            if (txtModel.getText().equals(""))
                strOutput += "Model of vehicle is a mandatory field.\n";   

            if (txtYear.getText().equals(""))
                strOutput += "Year is a mandatory field.\n";
            
            if (txtLoadCapacity.getText().equals(""))
                strOutput += "Load capacity is a mandatory field.\n";
        }
        else
        {    
            if (txtPlateNo1.getText().equals(""))
                strOutput += "Plate number is a mandatory field.\n";
            
            if (txtOwnerID1.getText().equals("")) 
                strOutput += "Owner ID is a mandatory field.\n";
            
            if (txtMake1.getText().equals(""))
                strOutput += "Make is a mandatory field.\n";
            
            if (txtModel1.getText().equals(""))
                strOutput += "Model of light vehicle is a mandatory field.\n";
            
            if (txtOwnerABN1.getText().equals("") || !Validation.isNumeric(txtOwnerABN.getText()))
                strOutput += "Owner ABN is a mandatory field and must be numeric.\n";    

            if (txtYear1.getText().equals(""))
                strOutput += "Year is a mandatory field.\n";   

            if (txtNoofSeat.getText().equals(""))
                strOutput += "No of seats is a mandatory field.\n";
        }
                
        return strOutput;
    }

    //Action event handler for the Submit button on the Heavy Vehicle tab 
    @FXML
    private void handleButtonHeavyVehicleSubmitAction(ActionEvent event) throws Exception{
        
        System.out.println("Heavy Vehicle details are submitted sucessfully!");
       
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }    
        else if (data.findVehicleRecord(true, Integer.parseInt(txtOwnerID.getText())) != null)
        {   
            Alert alert = new Alert(Alert.AlertType.ERROR, "Owner with this ID already exists!!!");
            alert.showAndWait();
            clearAllFields();    
        }
        else
        {            
            HeavyVehicle hVehicle =  new HeavyVehicle(Integer.parseInt(txtPlateNo.getText()), txtOwnerID.getText(), txtOwnerABN.getText(), txtMake.getText(), txtModel.getText(), txtYear.getText(), txtLoadCapacity.getText());
            data.addVehicleRecord(hVehicle);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Heavy Vehicle record inserted!");
            alert.showAndWait();
            clearAllFields();
        }   
    }
    
    
    //Action event handler for the Exit button on the heavy Vehicle tab
    @FXML
    private void handleButtonHeavyVehicleExitAction(ActionEvent event) throws Exception{
        System.out.println("You have pressed the exit button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }

    //Action event handler for the Submit button on the Light Vehicle tab 
    @FXML
    private void handleButtonLightVehicleSubmitAction(ActionEvent event) throws Exception{
        System.out.println("Light Vehicle details are submitted sucessfully!");
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }    
        else if (data.findVehicleRecord(true, Integer.parseInt(txtOwnerID1.getText())) != null)
        {   
            Alert alert = new Alert(Alert.AlertType.ERROR, "Owner with this ID already exists!!!");
            alert.showAndWait();
            clearAllFields();    
        }
        else
        {            
            LightVehicle lVehicle =  new LightVehicle(Integer.parseInt(txtPlateNo1.getText()), txtOwnerID1.getText(), txtOwnerABN1.getText(), txtMake1.getText(), txtModel1.getText(), txtYear1.getText(), txtNoofSeat.getText());
            data.addVehicleRecord(lVehicle);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Light Vehicle record inserted!");
            alert.showAndWait();
            clearAllFields();
        }
    }

    //Action event handler for the Exit button on the Light Vehicle tab
    @FXML
    private void handleButtonLightVehicleExitAction(ActionEvent event) throws Exception{
        System.out.println("You have pressed the exit button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        data = App.getDataHandler(); //Assigns the Data Handler object reference to an instance variable
    }
    
}

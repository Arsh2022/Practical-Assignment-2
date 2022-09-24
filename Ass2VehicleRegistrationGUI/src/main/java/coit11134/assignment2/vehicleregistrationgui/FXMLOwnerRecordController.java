/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author salah
 * 
 * 
 */
public class FXMLOwnerRecordController implements Initializable {

    //Instance variables for the UI controls 
    @FXML
    private TextField txtNamePrivate;
    
    @FXML
    private TextField txtIDPrivate;
    
    @FXML
    private TextField txtDOBPrivate;
    
    @FXML
    private TextField txtAddressPrivate;
    
    @FXML
    private TextField txtPhoneNoPrivate;
            
    @FXML
    private TextField txtNameCorporate;
    
    @FXML
    private TextField txtABNCorporate;
    
    @FXML
    private TextField txtAddressCorporate;
    
    @FXML
    private TextField txtPhoneNoCorporate;
    
    DataHandler data; //Instance variable to hold a reference to the DataHandler object
    
    //Method to clear all fields on the scene
    private void clearAllFields()
    {
        txtIDPrivate.clear();
        txtDOBPrivate.clear();
        txtNamePrivate.clear();
        txtAddressPrivate.clear();
        txtPhoneNoPrivate.clear();
        
        txtABNCorporate.clear();
        txtNameCorporate.clear();
        txtAddressCorporate.clear();
        txtPhoneNoCorporate.clear();
   
    }     
    
    //Method to validate the input values. returns an error message
    private String validationMessage(boolean isPrivate)
    {
        String strOutput = ""; //The message remains empty if all inputs are valid 
        
        if (isPrivate)
        {    
            if (txtIDPrivate.getText().equals("") || !Validation.isNumeric(txtIDPrivate.getText()))
                strOutput += "Owner ID is a mandatory field and must be numeric.\n";    

            if (txtDOBPrivate.getText().equals(""))
                strOutput += "Date of Birth is a mandatory field.\n";   

            if (txtNamePrivate.getText().equals(""))
                strOutput += "Name is a mandatory field.\n";   

            if (txtAddressPrivate.getText().equals(""))
                strOutput += "Address is a mandatory field.\n";
        }
        else
        {    
            if (txtABNCorporate.getText().equals("") || !Validation.isNumeric(txtIDPrivate.getText()))
                strOutput += "ABN is a mandatory field and must be numeric.\n";    

            if (txtNameCorporate.getText().equals(""))
                strOutput += "Name is a mandatory field.\n";   

            if (txtAddressCorporate.getText().equals(""))
                strOutput += "Address is a mandatory field.\n";
        }
                
        return strOutput;
    }        
    
    //Action event handler for the Submit button on the Private Owner tab 
    @FXML
    private void handleButtonOwnerPrivateSubmitAction (ActionEvent event) throws Exception  {
        System.out.println("You submitted private owner details!");
       
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }    
        else if (data.findOwnerRecord(true, Integer.parseInt(txtIDPrivate.getText())) != null)
        {   
            Alert alert = new Alert(Alert.AlertType.ERROR, "Owner with this ID already exists!!!");
            alert.showAndWait();
            clearAllFields();    
        }
        else
        {            
            PrivateOwner pvtOwner =  new PrivateOwner(Integer.parseInt(txtIDPrivate.getText()), txtDOBPrivate.getText(), txtNamePrivate.getText(), txtAddressPrivate.getText(), txtPhoneNoPrivate.getText());
            data.addOwnerRecord(pvtOwner);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Owner record inserted!");
            alert.showAndWait();
            clearAllFields();
        }
    }
    
    //Action event handler for the Exit button on the Private Owner tab 
    @FXML
    private void handleButtonOwnerPrivateExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        }

    }
    
    //Action event handler for the Submit button on the Corporate Owner tab 
    @FXML
    private void handleButtonOwnerCorpSubmitAction (ActionEvent event) throws Exception {
        System.out.println("You submitted corporate owner details!");
        
        //TODO
        //Write your code using the above example
               
    }
    
    //Action event handler for the Exit button on the Corporate Owner tab 
    @FXML
    private void handleButtonOwnerCorpExitAction (ActionEvent event) throws Exception {
        System.out.println("You pressed the Cancel button");
        //TODO
        //Write your code using the above example
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        data = App.getDataHandler(); //Assigns the Data Handler object reference to an instance variable
    }    
    
}




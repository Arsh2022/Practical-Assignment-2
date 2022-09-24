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
import java.util.*;

/**
 * FXML Controller class
 *
 * @author salah
 */
public class FXMLOwnerSearchController implements Initializable {

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
    
    DataHandler data; //Instance ariable to hold a reference to the DataHandler object
    
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
        String strOutput = "";
        
        if (isPrivate)
        {    
            if (txtIDPrivate.getText().equals("") || !Validation.isNumeric(txtIDPrivate.getText()))
               strOutput += "No owner ID specified.\n";
        }
        else
        {    
            if (txtABNCorporate.getText().equals("") || !Validation.isNumeric(txtIDPrivate.getText()))
                strOutput += "No Owner ABN specified.\n"; 
        }
        
         return strOutput;
        
    }
        
    //Action event handler for the Search button on the Private Owner tab 
    @FXML
    private void handleButtonOwnerPrivateSearchAction (ActionEvent event) throws Exception  {
        System.out.println("You submitted private owner ID!");
        
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }
        else 
        {
            Owner owner = data.findOwnerRecord(true, Integer.parseInt(txtIDPrivate.getText()));

            if (owner == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No record found!!!");
                alert.showAndWait();
                clearAllFields();
            } 
            else
            {
               PrivateOwner pvtOwner= ((PrivateOwner)owner);

               txtDOBPrivate.setText(pvtOwner.getDateofBirth());
               txtNamePrivate.setText(pvtOwner.getName());
               txtAddressPrivate.setText(pvtOwner.getAdress());
               txtPhoneNoPrivate.setText(pvtOwner.getPhoneNumber());
            }
        }
        
    }
    
    //Action event handler for the Exit button on the Private Owner tab     
    @FXML
    private void handleButtonOwnerPrivateExitAction (ActionEvent event) throws Exception {
        System.out.println("You have pressed the Exit button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        }
        
    }
    
    //Action event handler for the Search button on the Corporate Owner tab 
    @FXML
    private void handleButtonOwnerCorpSearchAction (ActionEvent event) throws Exception {
        System.out.println("You submitted corporate owner ABN!");
        
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }
        else 
        {
            Owner owner = data.findOwnerRecord(true, Integer.parseInt(txtIDPrivate.getText()));

            if (owner == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No record found!!!");
                alert.showAndWait();
                clearAllFields();
            } 
            else
            {
               CorporateOwner corpOwner= ((CorporateOwner)owner);

               txtNamePrivate.setText(corpOwner.getName());
               txtAddressPrivate.setText(corpOwner.getAdress());
               txtPhoneNoPrivate.setText(corpOwner.getPhoneNumber());
            }
        }
               
        
    }
    
    //Action event handler for the Exit button on the Corporate Owner tab 
    @FXML
    private void handleButtonOwnerCorpExitAction (ActionEvent event) throws Exception {
        System.out.println("You have pressed the Exit button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        }
               
    }   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Make the display only fields noneditable
        txtNamePrivate.setEditable(false);
        txtDOBPrivate.setEditable(false);
        txtAddressPrivate.setEditable(false);
        txtPhoneNoPrivate.setEditable(false);
        
        txtNameCorporate.setEditable(false);
        txtAddressCorporate.setEditable(false);
        txtPhoneNoCorporate.setEditable(false);
        
        data = App.getDataHandler(); //Assigns the Data Handler object reference to an instance variable
    }    
    
}


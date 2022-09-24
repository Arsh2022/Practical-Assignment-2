package coit11134.assignment2.vehicleregistrationgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Arsh kataria  <arsh.kataria@cqumail.com>
 */
public class FXMLVehicleSearchController implements Initializable {

    @FXML
    private Label label4;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private TextField txtPlateNumber;
    @FXML
    private TextField txtOwnerType;
    @FXML
    private TextField txtOwnerIDORABN;
    @FXML
    private Button buttonHeavyVehicleExit;
    @FXML
    private Label label10;
    @FXML
    private TextField txtMake;
    @FXML
    private Label label91;
    @FXML
    private TextField txtYear;
    @FXML
    private Button buttonHeavyVehicleSearch;
    @FXML
    private TextField txtModel;
    @FXML
    private TextField txtLoadCapacity;
    @FXML
    private TextField txtMake1;
    @FXML
    private Label label;
    @FXML
    private TextField txtPlateNumber1;
    @FXML
    private TextField txtModel1;
    @FXML
    private Label label1;
    @FXML
    private Button buttonLightVehicleSearch;
    @FXML
    private Label label8;
    @FXML
    private Label label71;
    @FXML
    private TextField txtOwnerType1;
    @FXML
    private Button buttonLightVehicleExit;
    @FXML
    private TextField txtYear1;
    @FXML
    private TextField txtOwnerIDORABN1;
    @FXML
    private TextField txtNoOfSeats;

    DataHandler data; //Instance ariable to hold a reference to the DataHandler object

    //Method to clear all fields on the scene
    private void clearAllFields()
    {
        //Heavy Vehicle
        txtPlateNumber.clear();
        txtYear.clear();
        txtModel.clear();
        txtMake.clear();
        txtLoadCapacity.clear();
        txtOwnerIDORABN.clear();
        txtOwnerType.clear();
        
        //Light Vehicle
        txtPlateNumber1.clear();
        txtYear1.clear();
        txtModel1.clear();
        txtMake1.clear();
        txtOwnerIDORABN1.clear();
        txtNoOfSeats.clear();
        txtOwnerType1.clear();  
    }

    //Method to validate the input values. returns an error message
    private String validationMessage(boolean isPrivate)
    {
        String strOutput = "";
        
        if (isPrivate)
        {    
            if (txtPlateNumber.getText().equals("") || !Validation.isNumeric(txtPlateNumber.getText()))
               strOutput += "No owner ID specified for Heavy Vehicle.\n";
            if (txtPlateNumber1.getText().equals("") || !Validation.isNumeric(txtPlateNumber1.getText()))
               strOutput += "No owner ID specified Light Vehicle.\n";
        }
        else
        {    
            if (txtOwnerIDORABN.getText().equals("") || !Validation.isNumeric(txtOwnerIDORABN.getText()))
                strOutput += "No Owner ID or ABN specified.\n"; 
        }
        
         return strOutput;
        
    }
    
    //Action event handler for the Exit button on the Heavy Vehicle  tab     
    @FXML
    private void handleButtonVehicleHeavyExitAction(ActionEvent event) throws Exception{
       System.out.println("You have pressed the Exit button!");
        
        clearAllFields();
        
        try {
            App.setRoot("FXMLMenu");
        } catch (IOException e){
           System.out.println(e); 
        } 
    }

    //Action event handler for the Search button on the heavy Vehicle tab 
    @FXML
    private void handleButtonVehicleHeavySearchAction(ActionEvent event) throws Exception{
        System.out.println("You submitted Heavy Vehicle ID!");
        
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }
        else 
        {
            Vehicle veh = data.findvehicleRecord(true, Integer.parseInt(txtOwnerIDORABN.getText()));

            if (veh == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No record found!!!");
                alert.showAndWait();
                clearAllFields();
            } 
            else
            {
               HeavyVehicle hVehicle = ((HeavyVehicle)veh);

               txtPlateNumber.setText(hVehicle.getPlateNumber());
               txtMake.setText(hVehicle.getMake());
               txtModel.setText(hVehicle.getModel());
               txtOwnerType.setText(hVehicle.setIsPrivate());
            }
        }
    }

    //Action event handler for the Search button on the Light Vehicle tab 
    @FXML
    private void handleButtonVehicleLightSearchAction(ActionEvent event) throws Exception{
        System.out.println("You submitted Light Vehicle ID!");
        
        String message = validationMessage(true);
        
        if (!message.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }
        else 
        {
            Vehicle veh = data.findvehicleRecord(true, Integer.parseInt(txtOwnerIDORABN.getText()));

            if (veh == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No record found!!!");
                alert.showAndWait();
                clearAllFields();
            } 
            else
            {
               LightVehicle lVehicle = ((LightVehicle)veh);

               txtPlateNumber.setText(lVehicle.getPlateNumber());
               txtMake.setText(lVehicle.getMake());
               txtModel.setText(lVehicle.getModel());
               txtOwnerType.setText(lVehicle.setIsPrivate());
            }
        }
    }

    //Action event handler for the Exit button on the Heavy Vehicle  tab         
    @FXML
    private void handleButtonVehicleLightExitAction(ActionEvent event) throws Exception{
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Make the display only fields noneditable
        
        //Heavy Vehicle
        txtPlateNumber.setEditable(false);
        txtMake.setEditable(false);
        txtYear.setEditable(false);
        txtModel.setEditable(false);
        txtOwnerType.setEditable(false);
        txtOwnerIDORABN.setEditable(false);
        txtLoadCapacity.setEditable(false);
        
        //Light Vehicle
        txtPlateNumber1.setEditable(false);
        txtMake1.setEditable(false);
        txtYear1.setEditable(false);
        txtModel1.setEditable(false);
        txtOwnerType1.setEditable(false);
        txtOwnerIDORABN1.setEditable(false);
        txtNoOfSeats.setEditable(false);

        
        data = App.getDataHandler(); //Assigns the Data Handler object reference to an instance variable
    } 
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author salah
 */

import java.util.ArrayList;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class DataHandler {
    
    final int PRIVATE_OWNER = 1;//Constants for owners here
    final int CORPORATE_OWNER = 2;

    final int HEAVY_VEHICLE = 3; //Constants for vehicles here
    final int LIGHT_VEHICLE = 4;
   
    
    private String ownerFileName, vehicleFileName;
    private ArrayList<Owner> ownerList; //ArrayList for Owners    
    private ArrayList<Vehicle> vehicleList; //ArrayList for vehicles

    //Constructor method
    public DataHandler() {    
    }
    
    public DataHandler(String ownerFileName, String vehicleFileName)
    {
        this.ownerFileName = ownerFileName;
        this.vehicleFileName = vehicleFileName;
        //Initialises ArrayLists for owners and vehicles
        this.ownerList = new ArrayList<>();
        //Initialise an ArrayList for vehicles here
        this.vehicleList = new ArrayList<>();
        //Reading all saved owner and vehicle records
        readDataFiles();        
    }

    //This method processes owner records from a String Tokenizer
    private Owner readOwnerRecord(StringTokenizer st)
    {
        int ownerType = Integer.parseInt(st.nextToken());
        
        int ownerID = 0;
        int ownerABN = 0;
        String ownerDateofBirth = null;
        
        if (ownerType == PRIVATE_OWNER)
        {
            ownerID = Integer.parseInt(st.nextToken());
            ownerDateofBirth = st.nextToken();
        }
        else if (ownerType == CORPORATE_OWNER)
            ownerABN = Integer.parseInt(st.nextToken());
        else
            System.out.println("Found corrupted data in " + ownerFileName);
        
        String ownerName = st.nextToken();
    
        String ownerAddress = st.nextToken();
        
        String ownerPhoneNumber = st.nextToken();
        
        
        if (ownerType == 1)
        {   PrivateOwner privateOwner =  new PrivateOwner(ownerID, ownerDateofBirth, ownerName, ownerAddress, ownerPhoneNumber);
            System.out.println("Private owner: " + privateOwner.toString());
            return privateOwner;
        }
        else
        {
            CorporateOwner corporateOwner =  new CorporateOwner(ownerABN, ownerName, ownerAddress, ownerPhoneNumber);
            System.out.println("Corporate owner: " + corporateOwner.toString());
            return corporateOwner;
        }
       
    }
    
    //This method processes vehicle records from a String Tokenizer
    
    private Vehicle readVehicleRecord(StringTokenizer st)
    {
        int vehicleType = Integer.parseInt(st.nextToken());
        
        int vehicleLoadingCapacity = 0;
        int vehicleNumberOfSeats = 0;
        
        if (vehicleType == LIGHT_VEHICLE)
        {
            vehicleNumberOfSeats = Integer.parseInt(st.nextToken());
        }
        else if (vehicleType == HEAVY_VEHICLE)
            vehicleLoadingCapacity = Integer.parseInt(st.nextToken());
        else
            System.out.println("Found corrupted data in " + vehicleFileName);
        
        String vehiclePlateNumber = st.nextToken();
    
        String vehicleMake = st.nextToken();
        
        String vehicleModel = st.nextToken();
        
        
        if (vehicleType == 3)
        {   HeavyVehicle heavyVehicle =  new HeavyVehicle(vehiclePlateNumber, vehicleMake, vehicleModel, vehicleLoadingCapacity);
            System.out.println("Heavy vehicle: " + heavyVehicle.toString());
            return heavyVehicle;
        }
        else if (vehicleType == 4)
        {
            LightVehicle lightVehicle =  new LightVehicle(vehiclePlateNumber, vehicleMake, vehicleModel, vehicleNumberOfSeats);
            System.out.println("Light vehicle : " + lightVehicle.toString());
            return lightVehicle;
        }
        return null;    
    }
    
    //This method read owner ands vehicle record from text files
    private void readDataFiles()
    {
	   System.out.println("Retrieving records from files...");
           //Read owner records from the data file
           try
	        {
                Scanner in = new Scanner(new FileReader(ownerFileName)); //open file
                
                while(in.hasNextLine())
                {
                    String myEntry = in.nextLine();
                    StringTokenizer st = new StringTokenizer(myEntry,",");

                    while(st.hasMoreTokens())
                    {                
                        ownerList.add(readOwnerRecord(st)); //Adds a private or corporate owner record to the Owner ArrayList
                    }
                }// end of while loop
                in.close();//close file
                
                int totalOwnerNumber = ownerList.size();
                System.out.println("Total number of owner records retrieved: " + totalOwnerNumber);
                
           } catch(ArrayIndexOutOfBoundsException ex)  {
                
               JOptionPane.showMessageDialog(null,"ArrayOutOfBoundsException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
               
           }  catch(FileNotFoundException ex)   {
               
               JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
                 
           }
           
           //Read vehicle records from the data file
           try
	        {
                Scanner in = new Scanner(new FileReader(vehicleFileName)); //open file
                
                while(in.hasNextLine())
                {
                    String myEntry = in.nextLine();
                    StringTokenizer st = new StringTokenizer(myEntry,",");

                    while(st.hasMoreTokens())
                    {                
                        vehicleList.add(readVehicleRecord(st)); //Adds a heavy or light vehicle record to the vehicle ArrayList
                    }
                }// end of while loop
                in.close();//close file
                
                int totalVehicleNumber = vehicleList.size();
                System.out.println("Total number of Vehicle records retrieved: " + totalVehicleNumber);
                
           } catch(ArrayIndexOutOfBoundsException ex)  {
                
               JOptionPane.showMessageDialog(null,"ArrayOutOfBoundsException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
               
           }  catch(FileNotFoundException ex)   {
               
               JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
                 
           }
                      
    }//end of the readDataFiles method
    
    
   //Method for saving all owner and vehicle records to the text files
   public void saveDatatoFiles()
   {
        System.out.println("Saving records to files...");
        
        //Save owner records to the data file
        try
        {
            Formatter out = new Formatter(ownerFileName);    //open file
       
            int totalOwnerNumber = ownerList.size();
        
               
            for (Owner curOwner:ownerList)
            {   
                if (curOwner instanceof PrivateOwner)
                {    
                   out.format(PRIVATE_OWNER + ",%s\n", ((PrivateOwner)curOwner).toString());
                   System.out.println("Private owner: " + ((PrivateOwner)curOwner).toString());
                }
                else if (curOwner instanceof CorporateOwner)
                {
                    out.format(CORPORATE_OWNER + ",%s\n", ((CorporateOwner)curOwner).toString());
                    System.out.println("Corporate owner: " + ((CorporateOwner)curOwner).toString());
                }    
            }
            
            System.out.println("Total number of owner records saved: " + totalOwnerNumber);

            out.close();//close file
           } catch(SecurityException ex)  {
                 JOptionPane.showMessageDialog(null,"SecurityException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
           }  catch(FileNotFoundException ex)   {
                 JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
      }
      
      try
        {
            Formatter out = new Formatter(vehicleFileName);    //open file
       
            int totalOwnerNumber = vehicleList.size();
        
               
            for (Vehicle curVehicle:vehicleList)
            {   
                if (curVehicle instanceof HeavyVehicle)
                {    
                   out.format(HEAVY_VEHICLE + ",%s\n", ((HeavyVehicle)curVehicle).toString());
                   System.out.println("Heavy Vehicle: " + ((HeavyVehicle)curVehicle).toString());
                }
                else if (curVehicle instanceof LightVehicle)
                {
                    out.format(LIGHT_VEHICLE + ",%s\n", ((LightVehicle)curVehicle).toString());
                    System.out.println("Light Vehicle: " + ((LightVehicle)curVehicle).toString());
                }    
            }
            
            System.out.println("Total number of vehicle records saved: " + totalOwnerNumber);

            out.close();//close file
           } catch(SecurityException ex)  {
                 JOptionPane.showMessageDialog(null,"SecurityException: "+ ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
           }  catch(FileNotFoundException ex)   {
                 JOptionPane.showMessageDialog(null,"FileNotFoundException: " + ex.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);
      }      
   }
    //Save vehicle records to the data file
    //end of the SaveDatatoFiles method 
    
    
   //Method to add a single owner record to the owner ArrayList
    public void addOwnerRecord(Owner owner)
    {
           
        if (owner instanceof PrivateOwner) 
        {
            System.out.println("Private owner record added : " + ((PrivateOwner)owner).toString());        
        }    
        else if (owner instanceof CorporateOwner)
        {    
            System.out.println("Corporate owner record added : " + ((CorporateOwner)owner).toString()); 
        }
        
        ownerList.add(owner); 
    }    
    
    //Method to add single vehicle record to the vehicle ArrayList
    public void addVehicleRecord(Vehicle vehicle)
    {           
        if (vehicle instanceof HeavyVehicle) 
        {
            System.out.println("Heavy Vehicle record added : " + ((HeavyVehicle)vehicle).toString());        
        }    
        else if (vehicle instanceof LightVehicle)
        {    
            System.out.println("Light vehicle record added : " + ((LightVehicle)vehicle).toString()); 
        }
        
        vehicleList.add(vehicle);  
        
    }
    
    //Method to find a owner record from the owner ArrayList using ID/ABN as the key    
    public Owner findOwnerRecord(boolean isPrivate, int ownerInfo)
    {         
        if (ownerList==null)
            
            return null;
        
        for (Owner curOwner:ownerList)
        {
            if (isPrivate)
            {    
                if (curOwner instanceof PrivateOwner)
                {
                    if (((PrivateOwner) curOwner).getID() == ownerInfo)
                    {
                        return curOwner;
                    }    
                }
            }
            else
            {    
                if (curOwner instanceof CorporateOwner)
                {
                    if (((CorporateOwner) curOwner).getABN() == ownerInfo)
                    {
                        return curOwner;
                    }    
                }
            }
        }
        return null; 
    }   
    
    
    //Method ro find a vehicle record from the vehicle ArrayList using plate number as the key 
    public Vehicle findVehicleRecord(String plateNumber)
    {         
        
        if (vehicleList==null)
            
            return null;
        
        for (Vehicle curVehicle:vehicleList)
        {         
                if (curVehicle instanceof HeavyVehicle)
                {
                    {
                        return curVehicle;
                    }    
                }
            
            else
            {    
                if (curVehicle instanceof LightVehicle)
                {
                    {
                        return curVehicle;
                    }    
                }
            }
        }
        return null; 
    }   

    Vehicle findvehicleRecord(boolean b, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object findVehicleRecord(boolean b, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       
}


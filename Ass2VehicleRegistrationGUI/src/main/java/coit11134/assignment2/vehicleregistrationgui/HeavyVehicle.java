/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author Arsh kataria  <arsh.kataria@cqumail.com>
 */
public class HeavyVehicle extends Vehicle{
    
    private int loadCapacity;

    public HeavyVehicle() {
        this("Undefined", "Undefined", "Undefined",0 ,0, 0, true, 0);
    }
    
    public HeavyVehicle(String plateNumber, String make, String model, int year, int ownerId, int ownerABN, boolean isPrivate, int loadCapacity) {
        super(plateNumber, make, model, year, ownerId, ownerABN, isPrivate);
        setLoadCapacity(loadCapacity);
    }

    
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "HeavyVehicle{" + "loadCapacity=" + loadCapacity + '}';
    }

    HeavyVehicle(int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    HeavyVehicle(String vehiclePlateNumber, String vehicleMake, String vehicleModel, int vehicleLoadingCapacity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}

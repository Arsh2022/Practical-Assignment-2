/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author Arsh kataria  <arsh.kataria@cqumail.com>
 */
public class LightVehicle extends Vehicle{
    
    private int numberofSeats;

    public LightVehicle() {
        this("Undefined", "Undefined", "Undefined",0 ,0, 0, true, 0);
    }

    public LightVehicle(String plateNumber, String make, String model, int year, int ownerId, int ownerABN, boolean isPrivate, int numberofSeats) {
        super(plateNumber, make, model, year, ownerId, ownerABN, isPrivate);
        setNumberofSeats(numberofSeats);
    }

    LightVehicle(String vehiclePlateNumber, String vehicleMake, String vehicleModel, int vehicleNumberOfSeats) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    @Override
    public String toString() {
        return "LightVehicle{" + "numberofSeats=" + numberofSeats + '}';
    }
    
    LightVehicle(int parseInt, String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author Arsh kataria  <arsh.kataria@cqumail.com>
 */
public abstract class Vehicle {
    
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private int ownerId;
    private int ownerABN;
    private boolean isPrivate;

    public Vehicle() {
        this("Undefined", "Undefined", "Undefined",0 ,0, 0, true);
    }

    public Vehicle(String plateNumber, String make, String model, int year, int ownerId, int ownerABN, boolean isPrivate) {
        setPlateNumber(plateNumber);
        setMake(make);
        setModel(model);
        setYear(year);
        setOwnerId(ownerId);
        setOwnerABN(ownerABN);
        setIsPrivate(isPrivate);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerABN() {
        return ownerABN;
    }

    public void setOwnerABN(int ownerABN) {
        this.ownerABN = ownerABN;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "plateNumber=" + plateNumber + ", make=" + make + ", model=" + model + ", year=" + year + ", ownerId=" + ownerId + ", ownerABN=" + ownerABN + ", isPrivate=" + isPrivate + '}';
    }

    String setIsPrivate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

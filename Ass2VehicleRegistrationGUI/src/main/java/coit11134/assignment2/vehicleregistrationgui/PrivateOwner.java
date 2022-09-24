/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author salah
 */

public class PrivateOwner extends Owner{
    
    private int id;
    private String dateofBirth;
    
    PrivateOwner(int id, String dateofBirth, String name, String address, String phoneNumber)
    {
	super(name, address, phoneNumber);
	this.id = id;
        this.dateofBirth = dateofBirth;
    }
    
    public int getID()
    {
	return this.id;
    }

    public String getDateofBirth()
    {
	return this.dateofBirth;
    }
    
    public void setID(int id)
    {
	this.id = id;
    }
    
    public void setDateofBirth(String dateofBirth)
    {
	this.dateofBirth = dateofBirth;
    }
    
    @Override
    public String toString()
    {
	return id+","+dateofBirth+","+super.toString();
    }
}


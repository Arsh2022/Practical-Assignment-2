/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author salah
 */

public abstract class Owner {

    private String name;
    private String address;
    private String phoneNumber;
    
    Owner(String name, String address, String phoneNumber)
    {
	this.name = name;
        this.address = address;
	this.phoneNumber = phoneNumber;
    }
            
    public String getName()
    {
	return this.name;
    }

    public String getPhoneNumber()
    {
	return this.phoneNumber;
    }

    public String getAdress()
    {
	return this.address;
    }

    public void setName(String name)
    {
    	this.name = name;
    }

    public void setPhoneNumber(String phoneNumber)
    {
	this.phoneNumber = phoneNumber;
    }
    
    public void setAddress(String address)
    {
	this.address = address;
    }
    
    @Override
    public String toString()
    {
	return name+","+address+","+phoneNumber;
    }
}

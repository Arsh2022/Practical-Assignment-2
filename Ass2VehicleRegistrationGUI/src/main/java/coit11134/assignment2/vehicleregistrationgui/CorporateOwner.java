/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.assignment2.vehicleregistrationgui;

/**
 *
 * @author salah
 */

public class CorporateOwner extends Owner{
    
    private int ABN;
       
    CorporateOwner(int ABN, String name, String address, String phoneNumber)
    {
	super(name, address, phoneNumber);
	this.ABN = ABN;
    }
    
    public int getABN()
    {
	return this.ABN;
    }

    public void setABN(int ABN)
    {
	this.ABN = ABN;
    }
    
    @Override
    public String toString()
    {
	return ABN+","+super.toString();
    }
    
}
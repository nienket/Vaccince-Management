/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author A715-41G
 */
abstract class Data{
    String ID;
    String name;
}
public class Vaccine extends Data{

    public Vaccine(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
    public String getVaccineID() {
        return ID;
    }
    public void setVaccineID(String ID) {
        this.ID = ID;
    }
    public String getVaccineName() {
        return name;
    }
    public void setVaccineName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.ID + "," + this.name;
    }
    
}

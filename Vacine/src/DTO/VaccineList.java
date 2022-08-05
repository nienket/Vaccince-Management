/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class VaccineList extends ArrayList<Vaccine>{
    public VaccineList(String filename){
        try {
            File f = new File(filename);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] split = data.split(";");
            String ID = split[0];
            String name = split[1];     
            this.add(new Vaccine(ID, name));
            }
        } catch (Exception e) {
                System.out.println(e);
        }         
    }
    public void printList(){
        this.forEach((x) -> {
            System.out.println(x.toString());
        });
            System.out.println("Total: " + this.size() + " item(s).");
    }
    public boolean isIDExist(String ID){
        return search(ID) != null;
    }
    public boolean isNameinList(String name){
        return searchName(name) != null;
    }    
    public Vaccine search(String ID) {
        for (Vaccine x : this) {
            if (x.getVaccineID().equals(ID)) {
                return x;
            }
        }
        return null;
    }     
    public Vaccine searchName(String name) {
        for (Vaccine x : this) {
            if (x.getVaccineName().equals(name)) {
                return x;
            }
        }
        return null;
    }              
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author A715-41G
 */
public class Injection {
    String ID;
    LocalDate injDate1;
    String injPlace1;
    LocalDate injDate2;
    String injPlace2;
    String stuID;
    String vacID;
    public Injection() {
        super();
    }
    public Injection(String ID, LocalDate injDate1, String injPlace1, LocalDate injDate2, String injPlace2, String stuID, String vacID) {
        this.ID = ID;
        this.injDate1 = injDate1;
        this.injPlace1 = injPlace1;
        this.injDate2 = injDate2;
        this.injPlace2 = injPlace2;
        this.stuID = stuID;
        this.vacID = vacID;
    } 
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDate getInjDate1() {
        return injDate1;
    }

    public void setInjDate1(LocalDate injDate1) {
        this.injDate1 = injDate1;
    }

    public String getInjPlace1() {
        return injPlace1;
    }

    public void setInjPlace1(String injPlace1) {
        this.injPlace1 = injPlace1;
    }

    public LocalDate getInjDate2() {
        return injDate2;
    }

    public void setInjDate2(LocalDate injDate2) {
        this.injDate2 = injDate2;
    }

    public String getInjPlace2() {
        return injPlace2;
    }

    public void setInjPlace2(String injPlace2) {
        this.injPlace2 = injPlace2;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getVacID() {
        return vacID;
    }

    public void setVacID(String vacID) {
        this.vacID = vacID;
    }

    @Override
    public String toString() {
        return ID + "," + injDate1 + "," + injPlace1 + "," + injDate2 + "," + injPlace2 + "," + stuID + "," + vacID ;
    }
    
}

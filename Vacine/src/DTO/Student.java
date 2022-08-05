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
public class Student extends Data implements Comparable<Student>{
    public int injNum = 0;
    public Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getInjNum() {
        return injNum;
    }

    public void setInjNum(int injNum) {
        this.injNum = injNum;
    }
    
    public String getStudentID() {
        return ID;
    }
    public void setStudentID(String ID) {
        this.ID = ID;
    }
    public String getStudentName() {
        return name;
    }
    public void setStudentName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.ID + "," + this.name + "," + this.injNum;
    }

    @Override
    public int compareTo(Student t) {
        return getStudentID().compareTo(t.getStudentID());
    }
    
}

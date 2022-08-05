/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacine;

import DTO.InjectionList;
import DTO.Menu;
import DTO.StudentList;
import DTO.VaccineList;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class test {
    public static void main(String[] args) {
        String StudentDataFile = "student.txt";
        String VaccineDataFile = "vaccine.txt";
        String InjectionDataFile = "injection2.txt";
        StudentList stulist = new StudentList(StudentDataFile);
        VaccineList vaclist = new VaccineList(VaccineDataFile);
        InjectionList injlist = new InjectionList(vaclist, stulist);
        injlist.loadfromFile(InjectionDataFile);        
        stulist.printList();
        vaclist.printList();

        injlist.printAll();
        injlist.searchByVaccineName();
    }
    
}


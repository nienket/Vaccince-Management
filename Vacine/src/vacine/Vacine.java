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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class Vacine {

    /**
     * @param args the command line arguments
     */
    public static void viewFile (String filename){
        System.out.println("INJECTION INFOMATION");
        System.out.println("---------------------------------");
        System.out.println(String.format("%-5s | %-9s| %-20s | %-15s | %-15s | %-15s | %-15s",
                                                "ID","StuID","Vaccine ID","1st InjDate", "1st InjPlace", "2nd InjDate", "2st InjPlace"));
        try {
            File f = new File(filename);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] split = data.split(",");
            String ID = split[0];
            LocalDate injDate1 = LocalDate.parse(split[1],DateTimeFormatter.ISO_LOCAL_DATE);
            String injPlace1 = split[2];
            LocalDate injDate2 = split[3].equals("null") ? null : LocalDate.parse(split[3],DateTimeFormatter.ISO_LOCAL_DATE);
            String injPlace2 = split[4].equals("null") ? null : split[4];
            String stuID = split[5];
            String vacID = split[6];
            System.out.println(String.format("%-5s | %-9s| %-20s | %-15s | %-15s | %-15s | %-15s",
                                                ID,stuID,vacID,injDate1, injPlace1, injDate2, injPlace2));    
            }
        } catch (Exception e) {
                System.out.println(e);
            }

    }        
    public static void main(String[] args) {
        String StudentDataFile = "student.txt";
        String VaccineDataFile = "vaccine.txt";
        String InjectionDataFile = "injection.txt"; 
        StudentList stulist = new StudentList(StudentDataFile);
        VaccineList vaclist = new VaccineList(VaccineDataFile);
        InjectionList injlist = new InjectionList(vaclist, stulist);
        injlist.loadfromFile(InjectionDataFile);
        stulist.printList();
        vaclist.printList();        
        ArrayList<String> options = new ArrayList<>();
        options.add("Show all injection infomation from file " + InjectionDataFile);
        options.add("Add new injection");
        options.add("Remove an injection");
        options.add("Update an injection");
        options.add("Search injection by studentID");
        options.add("Save to file");
        options.add("Load from file");
        options.add("Show all working injection infomation ");
        options.add("Search by vaccine name");
        options.add("Quit");
        Menu menu = new Menu();
        int userChoice;
        do{
        userChoice = menu.getChoice(options);
        switch (userChoice){
            case 1: viewFile(InjectionDataFile);break;
            case 2: injlist.addInjection(); break;
            case 3: injlist.removeInjection();break;
            case 4: injlist.updateInjection();break;
            case 5: injlist.searchByStuID();break;
            case 6: injlist.savetoFile();break;
            case 7: injlist.loadfromFile(InjectionDataFile);break;
            case 8: injlist.printAll();break;
            case 9: injlist.searchByVaccineName();break;
        }
        } while(userChoice >= 1 && userChoice < options.size());
    }
    
}

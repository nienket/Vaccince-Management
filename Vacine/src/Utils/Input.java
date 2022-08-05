/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DTO.StudentList;
import DTO.VaccineList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 *
 * @author A715-41G
 */
public class Input {
    public static Scanner sc = new Scanner(System.in);
    public Input() {
    }
    public static String inputPStr(String msg, String pat){
        String data;
        do{
            System.out.print(msg);
            data= sc.nextLine().trim();
        }while(!data.matches(pat));
        return data;
    }
    public static int inputInt(String msg, int min, int max){
        int data;
        do{
            System.out.print(msg);
            data= Integer.parseInt(sc.nextLine());
        } while (data<min || data >max);
        return data;
    }
    public static String inputNonBlankStr(String msg){
        String data;
        do{
            System.out.print(msg);
            data= sc.nextLine().trim();
        }while(data.length() < 1);
        return data;
    }
    public static LocalDate inputNonBlankValidDate(String msg){
        String data;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           if (!isValidDate(data)) System.out.println("Invalid Date");
        }while (!isValidDate(data));
        return LocalDate.parse(data,DateTimeFormatter.ISO_LOCAL_DATE);
    }
    public static LocalDate inputSecondValidDate(String msg, LocalDate date1){
        String data;
        LocalDate date2 = null;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           if (data.length() > 0){
               if (!isValidDate(data)) System.out.println("Invalid Date");
               else {
                   date2 = LocalDate.parse(data,DateTimeFormatter.ISO_LOCAL_DATE);
                   if (date2.isAfter(date1.plusWeeks(12)) || date2.isBefore(date1.plusWeeks(4)))
                       System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection");
               }
           }       
        }while (data.length() > 0 && (!isValidDate(data) || date2.isAfter(date1.plusWeeks(12)) || date2.isBefore(date1.plusWeeks(4))));
        return date2;
    }
    public static String inputStudentID(String msg, StudentList stulist){
        String data;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim().toUpperCase();
           if (!stulist.isIDExist(data)) System.out.println("Student not exist");
           else if (stulist.search(data).getInjNum() >= 1) System.out.println("This student has injected the maximum number of injection or waiting for second dose ");
        }while (!stulist.isIDExist(data) || stulist.search(data).getInjNum() >= 1);
        return data; 
    }
    public static String inputVaccineName(String msg, VaccineList vaclist){
        String data;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           
           if (!vaclist.isNameinList(data)) System.out.println("Vaccine name not exist");
        }while (!vaclist.isNameinList(data));
        return data; 
    }
    public static String inputStudentIDToSearch(String msg, StudentList stulist){
        String data;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           if (!stulist.isIDExist(data)) System.out.println("Student not exist");
        }while (!stulist.isIDExist(data));
        return data; 
    }    
    public static String inputVaccineID(String msg, VaccineList vaclist){
        String data;
        do{
           System.out.print(msg);
           data= sc.nextLine().trim();
           if (!vaclist.isIDExist(data)) System.out.println("Vaccine not exist");
        }while (!vaclist.isIDExist(data));
        return data; 
    }
    private static boolean isValidDate(String date) {
        boolean valid;
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date,DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT)
            );
            valid = true;
        } catch (DateTimeParseException e) {
            //e.printStackTrace();
            valid = false;
        }
        return valid;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Utils.Input;
import java.util.ArrayList;

/**
 *
 * @author A715-41G
 */
public class Menu {
    public int getChoice(ArrayList options){
        System.out.println("\nWelcome to Food Management - @2021 <SE160148 - Trinh Tuan Kiet>"); 
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
        
        int choice = Input.inputInt("Input your choice: ", 1, options.size());
        return choice;
    }
}

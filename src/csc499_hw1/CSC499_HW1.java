/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
This program is to sort a list of names from a file. First by the length of the 
the name then alphabetically.
*/

package csc499_hw1;

import java.io.File;
import java.util.Scanner;

public class CSC499_HW1 {

    public static void main(String[] args) throws Exception {
        // get file from location and set up scanner 
        File nameFile = new File("src/Sort Me.txt");
        Scanner nameReader = new Scanner(nameFile);
        
        //set up and count the length for array
        int arrayLength=0;
        
        while(nameReader.hasNextLine()){
            nameReader.nextLine();
            arrayLength++;
        }
        
        //set up name array
        String[] nameArray=new String[arrayLength];
        
        //reset scanner to read from again
        nameReader = new Scanner(nameFile);
        
        //get the names and put them in list
        for (int i = 0; i < arrayLength; i++) {
            String name = nameReader.nextLine();
            //remove the beginning and trailing blank spaces
            nameArray[i]=name.trim();
        }
        
        
        //sort list by length(bubble)
        for (int i = 0; i < arrayLength-1; i++)    
            for (int j = 0; j < arrayLength-i-1; j++){  
                if (nameArray[j].length() > nameArray[j+1].length()){
                    String temp = nameArray[j];
                    nameArray[j] = nameArray[j+1];
                    nameArray[j+1] = temp;
                }  
        }
        
        
        //sort list alphabetically(bubble)
        for (int i = 0; i < arrayLength-1; i++){      
            for (int j = 0; j < arrayLength-i-1; j++){
                //skips if lengths are not equal
                if(nameArray[j].length() == nameArray[j+1].length())
                    if (nameArray[j].compareToIgnoreCase(nameArray[j+1]) > 0){
                        String temp = nameArray[j];
                        nameArray[j] = nameArray[j+1];
                        nameArray[j+1] = temp;
                    }   
            }
        }
        
        //print out array
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(nameArray[i]);
        }
    }
    
}

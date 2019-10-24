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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSC499_HW1 {
    
    public static void main(String[] args) throws Exception {
        // get file from location and set up scanner 
        File nameFile = new File("sort Me.txt");
        Scanner nameReader = new Scanner(nameFile);
        
        //set up and count the length for array
        int nameCount=0;
        
        while(nameReader.hasNextLine()){
            if(nameReader.nextLine().length() > 0)
                nameCount++;
        }
        
        //set up name array
        String[] nameArray=new String[nameCount];
        
        //reset scanner to read from again and the counter to put names in 
        nameReader = new Scanner(nameFile);
        nameCount=0;
        
        //get the names and put them in list
        while(nameReader.hasNextLine()){
            String name = nameReader.nextLine();
            
            if(name.length() > 0){
                //remove the beginning and trailing blank spaces
                nameArray[nameCount]=name.trim();
                nameCount++;
            }
        }
        
        //sort array
        sortArray(nameArray);
        
        //print list
        printArray(nameArray);
    }
    
    
    //print array contents
    public static void printArray(Object[] array) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i < array.length; i++) {
            writer.write(""+array[i]);
            
            if(i<array.length-1)
                writer.write("\n");
        }
        writer.close();
    }
    
    
    //sort array contents
    public static void sortArray(String[] array){
        //sort list by length(bubble)
        for (int i = 0; i < array.length-1; i++)    
            for (int j = 0; j < array.length-i-1; j++){  
                if (array[j].length() > array[j+1].length()){
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }  
        }
        
        
        //sort list alphabetically(bubble)
        for (int i = 0; i < array.length-1; i++){      
            for (int j = 0; j < array.length-i-1; j++){
                //skips if lengths are not equal
                if(array[j].length() == array[j+1].length())
                    if (array[j].compareToIgnoreCase(array[j+1]) > 0){
                        String temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }   
            }
        }
    }
    
}

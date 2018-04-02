package com.mycompany.assignment2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Alif Haikal
 */

public class count {
    
    public static void count() throws IOException {
        FileInputStream fin = new FileInputStream("F:\\folder uum\\SEM5\\RealTime\\PracticumStudentSupervisorList.xlsx");
        Scanner fileinput = new Scanner(fin);
        
        int lines = 0;
        int words = 0;
        int chars = 0;
        while (fileinput.hasNextLine()) {
            lines++;
            String line = fileinput.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != ' ' && line.charAt(i) != '\n') {
                    chars++;
                }
            }
            words += new StringTokenizer(line, " ,").countTokens();
        }

        System.out.println("Number of lines: " + lines);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + chars);
      
        fileinput.close();
        fin.close();

        String fileName = "C:\\Users\\Alif Haikal\\243126-STIW3054-A172-A2.wiki\\cuba.md";

        try {
           
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           
            bufferedWriter.write("Number of lines: " + lines);
            bufferedWriter.write("\n");
            bufferedWriter.write("Number of words: " + words);
            bufferedWriter.write("\n");
            bufferedWriter.write("Number of characters: " + chars);

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
        }
    }
}

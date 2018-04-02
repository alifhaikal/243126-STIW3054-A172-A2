package com.mycompany.assignment2;

import java.io.BufferedReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Alif Haikal
 */

public class readExcel {

    private static final String FILE_IN = "F:\\folder uum\\SEM5\\RealTime\\PracticumStudentSupervisorList.xlsx";
    private static final String FILE_OUT = "F:\\folder uum\\SEM5\\RealTime\\PracticumStudentSupervisorList.xlsx";

    public static void run() {

        Writer w = null;

        boolean lbreak = true;

        try {

            DataFormatter date = new DataFormatter();

            FileInputStream excelFile = new FileInputStream(new File(FILE_IN));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            File f = new File(FILE_OUT);
            w = new BufferedWriter(new FileWriter(f));

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    String d = date.formatCellValue(currentCell);
                    w.write(d + " ");
                }
                w.write("\r\n");
                if (lbreak == true) {

                    lbreak = false;
                }

            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        try {
            if (w != null) {
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {

        count c = new count();
        c.count();
   
        github g = new github();
        g.githubpush();
        
        c.count();
    }
}

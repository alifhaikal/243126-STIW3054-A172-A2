package com.mycompany.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;

/**
 *
 * @author Alif Haikal
 */

public class github {

    public void githubpush() throws IOException {
        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd && cd \"C:\\Users\\Alif Haikal\\243126-STIW3054-A172-A2.wiki\" && git add * && git commit -m \"Test\" && git pull && git push");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("\nUpload result : \n");
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            sleep(3000);
        } catch (Exception e) {
            System.out.println("Terminal cannot open!");
        }
        double startTime = System.nanoTime();
        double stopTime = System.nanoTime();
        double elapsedTime = stopTime - startTime;
        double seconds = (double) elapsedTime / 1000000000.0;
        System.out.printf("\nUpload to Github ended at %.9f seconds", seconds);
    }
}
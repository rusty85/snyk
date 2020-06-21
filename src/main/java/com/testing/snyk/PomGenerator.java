package com.testing.snyk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.format;

/**
 *
 * @author vgolembo
 */
public class PomGenerator {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/vgolembo/NetBeansProjects/snyk/src/test/resources/dependencies"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dependency = line.split(":");
                System.out.println("<dependency>");
                System.out.println(format("    <groupId>%s</groupId>", dependency[0]));
                System.out.println(format("    <artifactId>%s</artifactId>", dependency[1]));
                System.out.println(format("    <version>%s</version>", dependency[3]));
                System.out.println(format("    <scope>%s</scope>", dependency[4]));
                System.out.println(format("    <type>>%s</type>", dependency[2]));
                System.out.println("</dependency>");
            }
        }
    }
}

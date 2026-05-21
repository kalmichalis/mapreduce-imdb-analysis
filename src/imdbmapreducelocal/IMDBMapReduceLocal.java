/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imdbmapreducelocal;

import java.io.*;
import java.util.*;

public class IMDBMapReduceLocal {

    public static void main(String[] args) throws Exception {

        String inputFile = "movies.csv"; 

        // Συνολική διάρκεια ανά χώρα για το πρώτο ερώτημα

        Map<String, Integer> countryDurations = new HashMap<>();
        RuntimeByCountryMapper mapper1 = new RuntimeByCountryMapper();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                mapper1.mapLine(line, countryDurations);
            }
        }

        System.out.println("=== Total time movie per country ===");
        for (Map.Entry<String, Integer> entry : countryDurations.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }


        // Ταινίες με imdbRating > 8 ανά έτος και είδος, για το δεύτερο ερώτημα

        Map<String, Integer> yearGenreCounts = new HashMap<>();
        MoviesByYearGenreMapper mapper2 = new MoviesByYearGenreMapper();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                mapper2.mapLine(line, yearGenreCounts);
            }
        }

        System.out.println("\n=== Movies with imdbRating>8 per year and genre ===");
        for (Map.Entry<String, Integer> entry : yearGenreCounts.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
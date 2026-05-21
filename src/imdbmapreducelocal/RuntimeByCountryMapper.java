/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imdbmapreducelocal;

import java.util.Map;

public class RuntimeByCountryMapper {


    public void mapLine(String line, Map<String, Integer> countryDurations) {

        // Αγνοούμε το header
        if (line.startsWith("imdbID")) return;

        // Σπάμε τη γραμμή σε στήλες
        String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (columns.length < 9) return; // αγνοούμε κακές γραμμές

        // Παίρνουμε το runtime της ταινίας και κρατάμε μόνο αριθμούς
        String runtimeStr = columns[3].replaceAll("[^0-9]", "");
        int runtime;
        try { 
            runtime = Integer.parseInt(runtimeStr); 
        } catch (NumberFormatException e) { 
            return; // αν δεν είναι αριθμός, αγνοούμε
        }

        // Παίρνουμε όλες τις χώρες διαχωρισμένες με κόμμα
        String[] countries = columns[8].split(",");
        for (String key : countries) { // χρησιμοποιούμε key
            key = key.strip(); // αφαιρούμε κενά πριν και μετά
            key = key.replaceAll("^\"|\"$", ""); // αφαιρούμε αρχικάκαι τελικά quotes
            if (!key.isEmpty()) {
                // Προσθέτουμε την διάρκεια στη χώρα (άθροισμα για τον Reducer)
                countryDurations.put(key, countryDurations.getOrDefault(key, 0) + runtime);
            }
        }
    }
}
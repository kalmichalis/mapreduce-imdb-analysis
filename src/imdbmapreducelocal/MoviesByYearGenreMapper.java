/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imdbmapreducelocal;

import java.util.Map;

public class MoviesByYearGenreMapper {

    public void mapLine(String line, Map<String, Integer> yearGenreCounts) {

        // Αγνοούμε το header
        if (line.startsWith("imdbID")) return;

        // Σπάμε τη γραμμή σε στήλες
        String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (columns.length < 9) return;

        String year = columns[2].strip(); // έτος ταινίας
        String genreStr = columns[4].replaceAll("\"", ""); // αφαιρούμε τα quotes
        String ratingStr = columns[6].strip(); // παίρνουμε το imdbRating

        double rating;
        try { 
            rating = Double.parseDouble(ratingStr); 
        } catch (NumberFormatException e) { 
            return; 
        }

        // Μόνο ταινίες με rating > 8 αλλάζοντας τον αριθμό αυτο αλλάζει και το ρατινγκ που θέλουμε να παρουμε
        if (rating > 8) {
            String[] genres = genreStr.split(","); 
            for (String genre : genres) {
                String key = year + "_" + genre.strip(); // key = year_genre
                // Προσθέτουμε count = +1, για τον Reducer 
                yearGenreCounts.put(key, yearGenreCounts.getOrDefault(key, 0) + 1);
            }
        }
    }
}
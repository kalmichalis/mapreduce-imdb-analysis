/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imdbmapreducelocal;

import java.util.Map;

public class MoviesByYearGenreReducer {

    //τυπώνει τον αριθμό ταινιών ανά έτος και είδος
     
    public void reduce(Map<String, Integer> yearGenreCounts) {
        for (Map.Entry<String, Integer> entry : yearGenreCounts.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imdbmapreducelocal;


import java.util.Map;

public class RuntimeByCountryReducer {

    //τυπώνει τη συνολική διάρκεια ανά χώρα

    public void reduce(Map<String, Integer> countryDurations) {
        for (Map.Entry<String, Integer> entry : countryDurations.entrySet()) {
            // key = χώρα, value = συνολική διάρκεια
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
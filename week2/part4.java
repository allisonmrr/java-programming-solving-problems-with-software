
/**
 * Write a description of Part4 here.
 * 
 * @author (Allison Maurer) 
 * @version (8/25/2021)
 */

import edu.duke.*;
import java.io.File;

public class Part4 {
    public void checkURL () {
        URLResource URL = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : URL.words()) {
            int youTubeIndex = word.toLowerCase().indexOf("youtube.com");
            if (youTubeIndex != -1) {
                int leftSide = word.lastIndexOf("\"", youTubeIndex);
                int rightSide = word.indexOf("\"", youTubeIndex + 1); 
                System.out.println(word.substring(leftSide + 1, rightSide));
            }
        }
    }
    
    public static void main (String[] args) {
        Part4 checkURL = new Part4();
        checkURL.checkURL();
    }

}

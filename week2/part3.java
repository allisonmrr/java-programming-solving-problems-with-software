
/**
 * Write a description of Part3 here.
 * 
 * @author (Allison Maurer) 
 * @version (8/25/2021)
 */
public class Part3 {
    public boolean twoOccurrences (String stringA, String stringB) {
        int test1 = stringB.indexOf(stringA);
        if (test1 != -1) {
            int test2 = stringB.indexOf(stringA, test1 + 1);
            if (test2 != -1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void testTwoOccurrences () {
        //test strings
        boolean case1 = twoOccurrences("by","A story by Abby Long");
        System.out.println("Are there two occurrences (true/false)?: " + case1);
        
        boolean case2 = twoOccurrences("a", "banana");
        System.out.println("Are there two occurrences (true/false)?: " + case2);
        
        boolean case3 = twoOccurrences("b", "Allison");
        System.out.println("Are there two occurrences (true/false)?: " + case3);
        
        boolean case4 = twoOccurrences ("cd" ,"ef");
        System.out.println("Are there two occurrences (true/false)?: " + case4);
    }
    
    public String lastPart (String stringA, String stringB) { 
        int firstOcc = stringB.indexOf(stringA);
      
        if(firstOcc != -1) {
            String restOfString = stringB.substring(firstOcc + stringA.length());
            return restOfString;
        } else {
            return stringB;
        }
    }
    
    public void testLastPart () {
        String case1 = lastPart("an", "banana");
        System.out.println("The part of the string after an in banana is " + case1);
        
        String case2 = lastPart("zoo", "forest");
        System.out.println("The part of the string after zoo in forest is " + case2);
        
        String case3 = lastPart("is","Mississippi");
        System.out.println("the part of the after is in Mississippi is " + case3);
    }
    
    public static void main (String[] args) {
        Part3 numOfOccurrences = new Part3();
        numOfOccurrences.testTwoOccurrences();
        numOfOccurrences.testLastPart();
    }
}

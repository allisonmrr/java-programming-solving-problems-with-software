
/**
 * Write a description of Part2 here.
 * 
 * @author (Allison Maurer) 
 * @version (8/24/2021)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        //Set result to null
        String result = "";
        //Set start codon of ATG and coverts to uppercase
        int startIndex = dna.toUpperCase().indexOf(startCodon);
        //Checks if there is no ATG 
        if (startIndex == -1) {
            return "";
        }
        // Set end codon of TAA and converts to uppercase
        int stopIndex = dna.toUpperCase().indexOf(stopCodon, startIndex + 3);
        // Checks if there is no TAA
        if (stopIndex == -1) {
            return "";
        } 
        
        if((startIndex - stopIndex+3) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3); 
        }  else {
            return "";
        }
    }
  
    public void testFindGeneSimple() {
        //test strings
        String dna = "ATTGCCTAA";
        System.out.println("First DNA strand is " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATGGCCTAA";
        System.out.println("First DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATGGCCTGA";
        System.out.println("Second DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATCGCCTGA";
        System.out.println("Third DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "AAAATGGCCTTGTAAGAA";
        System.out.println("Fourth DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "aacatggccttgtaattg";
        System.out.println("Fifth DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
      } 
      
    
    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testFindGeneSimple();
    }
}

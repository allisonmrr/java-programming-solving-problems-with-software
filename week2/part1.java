
/**
 * Finding a Gene - Using the Simplified Algorithm
 * 
 * @author (Allison Maurer) 
 * @version (8/24/2021)
 */

public class Part1 {
    public String findSimpleGene(String dna) {
        //Set result to null
        String result = "";
        //Set start codon of ATG
        int startIndex = dna.indexOf("ATG");
        //Checks if there is no ATG
        if (startIndex == -1) {
            return "";
        }
        // Set end codon of TAA
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        // Checks if there is no TAA
        if (stopIndex == -1) {
            return "";
        } 
        
        if((startIndex - stopIndex + 3) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3); 
        }  else {
            return "";
        }
    }
  
    public void testFindGeneSimple() {
        String dna = "AATGCGATAATATGGT";
        System.out.println("Gene is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
          
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("Gene is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
          
        dna = "ATCCTAGCTTCGGCTGCTCTAATATGGT";
        System.out.println("Gene is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
      } 
    
    public static void main (String[] args) {
        Part1 gene = new Part1();
        gene.testFindGeneSimple();
      }
}

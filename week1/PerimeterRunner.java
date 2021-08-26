import edu.duke.*;
import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public double getNumPoints (Shape s) {
        // Start with count = 0
        int count = 0;
        // Iterate over the points  
        for (Point currPt : s.getPoints()) {
            // Add to the point count
            count = count +1; 
        }
        // totalPt is the answer 
        return count;
    }
    
    public double getAverageLength(Shape s) {
        double totalLength = getPerimeter(s);
        double numOfSides = (double) getNumPoints(s);
        double avgLength = totalLength / numOfSides;
        return avgLength;
    }
    
    public double getLongestSide (Shape s) {
        //Start with longest side = 0
        double longestSideYet = 0.0;
        Point lastPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = lastPt.distance(currPt);
            if (currDist>longestSideYet) {
                longestSideYet = currDist;
            }
            lastPt = currPt;
        }
        return longestSideYet;
    }
    
    public double getLargestX (Shape s) {
        //Start at last point 
        Point lastPt = s.getLastPoint();
        //Get first X 
        int lastPointX = lastPt.getX();
        double largestX = (double) lastPointX;
        //Loop through points
        for (Point currPt : s.getPoints()) {
            int newX = currPt.getX();
            if (newX > largestX) {
                largestX = (double) newX;
            }
        }
        return largestX;
    }
    
    public double getLargestPerimeterMultipleFiles() {
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        FileResource largestFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if(currPerim > largestPerim) {
                largestPerim = currPerim;
            }
        }
        return largestPerim; 
    }
    
    
    public void testPerimeterMultipleFiles() { 
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimter = " + largestPerimeter);
    }
    
   public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double points = getNumPoints(s);
        double longestSide = getLongestSide(s);
        double largestX = getLargestX(s);
        double averageLength = getAverageLength(s);
        System.out.println("perimeter = " + length);
        System.out.println("total points = " + points);
        System.out.println("longest side = " + longestSide);
        System.out.println("largest x = " + largestX);
        System.out.println("average length = " + averageLength);
        
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeterMultipleFiles();
    }
}

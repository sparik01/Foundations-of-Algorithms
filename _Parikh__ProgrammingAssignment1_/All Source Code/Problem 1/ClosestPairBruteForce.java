/* Sheetal Parikh
 * Programming Assignment 1 - Question 1b
 * Brute Force Closest Pairs Distance Calculation
 */
package closestpairbruteforce;

/**
 *
 * @author SheetalParikh
 */
public class ClosestPairBruteForce {

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();    //start time calculating elapsed time
        final int A = 0;
        final int B = 1;
        double[] startingPoint = {4,41};                 //point 1 = starting comparison point 
                                                          //all points used as (a,b)
        
        //test points for 2D Array
        double[][] points = {{6,2},                    // point 2
                             {7,93},                   // point 3
                             {13,176},                 // point 4
                             {14,87},                  // point 5
                             {22,39},                  // point 6
                             {25,90},                  // point 7
                             {28,169},                 // point 8
                             {35,111},                 // point 9
                             {47,148},                 // point 10
                             {48,17},                  // point 11
                             {54,99},                  // point 12
                             {55,86},                  // point 13
                             {56,29},                  // point 14
                             {67,104},                 // point 15
                             {73,97},                  // point 16
                             {74,147},                 // point 17
                             {76,127},                 // point 18
                             {77,195},                 // point 19
                             {84,125},                 // point 20
                             {97,32},                  // point 21
                             {110,7},                  // point 22
                             {118,13},                 // point 23
                             {129,49},                 // point 24
                             {132,71},                 // point 25
                             {134,141},                // point 26
                             {146,143},                // point 27
                             {147,74},                 // point 28
                             {159,120},                // point 29
                             {161,76},                 // point 30
                             {162,118},                // point 31
                             {174,145},                // point 32
                             {181,54},                 // point 33
                             {190,88},                 // point 34
                             {191,73},                 // point 35
                             {195,19},                 // point 36
                             {198,110},                // point 37
                             {199,130},                // point 38
                             {200,67},                 // point 39
                             {94,172},                 // point 40
                                                            
                            };
        
        double[] nearest = ClosestPoint(startingPoint, points);                             //method for determining closest point
        
        System.out.println("Number of Test Points: 40 ");                                   //printing # of test points
        //System.out.println("Number of Test Points: 20 ");                                 //change the # of test points printed depending on what's testing
        //System.out.println("Number of Test Points: 40 ");
        System.out.println("Starting Point: " + "(4,41)");   
        System.out.println("Closest Point: " + "(" +nearest[A]+","+nearest[B]+ ")");        //printing closest point
        double d = Distance(startingPoint[A], startingPoint[B], nearest[A], nearest[B]);    //calculating distance of closest pair
        System.out.println("Distance from Starting Point to Closest Point: " +d);
        long elapsedTime = System.currentTimeMillis();                                      //ending time for elapsed time calculation
        float sec = (elapsedTime - startTime) /  1000F;                                     //calculating total elapsed time in sec
        System.out.println("Brute Force Elapsed Time: " + sec + " seconds");
        System.out.println("");
        
        }
    
        //Calculating the distance using the Euclidean distance formula for point (a,b)
    public static double Distance(double a1, double b1, double a2, double b2){
        double a = Math.pow(a2-a1, 2);                                                  //difference between x
        double b = Math.pow(b2-b1, 2);
        return Math.sqrt(a+b);                                                          //square root formula
        }
        
    public static double[] ClosestPoint(double[]startingPoint, double[][]points){       //calculating closest point
        final int A = 0;
        final int B = 1;
        double[] closestPoint = points[0];
        double closestDistance = Distance(startingPoint[A], startingPoint[B], closestPoint[A], closestPoint[B]);
          
        //going through the elements in the array
        for (double[] point : points) {
            double dist = Distance(startingPoint[A], startingPoint[B], point[A], point[B]);
            if (dist < closestDistance && dist != 0.0)                                      // making sure that the closest distance is not the distance from         
                {                                                                      //the starting point to the starting point  
                closestDistance = dist;
                closestPoint = point;
            }
        }
  
     return closestPoint;
    }
    
} // end of program
       

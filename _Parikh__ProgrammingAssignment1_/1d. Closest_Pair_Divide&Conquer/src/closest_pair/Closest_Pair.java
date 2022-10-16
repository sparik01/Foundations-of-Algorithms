/* Sheetal Parikh
 * Programming Assignment 1 - Question 1d
 * Closest Pairs Distance Calculation
 */
package closest_pair;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author SheetalParikh
 */
        
public class Closest_Pair {
    
    public static Comparator <Point> compX = (p1, p2) -> {   //sorting points by x 
	if (p1.x <p2.x) {
            return -1;
	} else if (p1.x> p2.x) {
            return 1;
	} else {
            return 0;
	}
    };

    public static Comparator <Point> compY = (p1, p2) -> {   //sorting points by y
	if (p1.y <p2.y) {
            return -1;
	} else if (p1.y> p2.y) {
            return 1;
	} else {
            return 0;
        }
    };

    public static double distance (Point p, Point q) {            //calculating the distance between two points
	double a = p.x - q.x;
	double b = p.y - q.y;
	return Math.sqrt ((a * a) + (b * b));
    }

    public static double BruteForce(ArrayList <Point> byX) {      //calculates the minimum distance of all points                                                             
	double minDist = Double.POSITIVE_INFINITY;
            for (Point p: byX) {
		for (Point q: byX) {
                    if ((p.x != q.x) && (p.y != q.y) && (distance (p,q) <minDist)) {
			minDist = distance (p, q);
                }
            }
        }
	return minDist;
    }

    // calculates minimum distance using divide and conquer 
    public static double DivideandConquer(ArrayList <Point> byX, ArrayList <Point> byY, int n) {  
	if (n <= 3) {                               //use Brute Force method if have 3 or less points                   
            return BruteForce(byX);
	}
	                          
	int mid = ((int) Math.ceil (n / 2)) -1;      //calculating midpoint of where to "draw" vertical line

        // after calculating midpoint we split the points into a left and right side sorted by x and y
        // each section is put into a list
	ArrayList <Point> xL = new ArrayList <> (); //sorted by x left side
	ArrayList <Point> xR = new ArrayList <> (); //sorted by x right side
	ArrayList <Point> yL = new ArrayList <> (); //sorted by y left side
	ArrayList <Point> yR = new ArrayList <> (); //sorted by y right side

	for (int i = 0; i <= mid; i ++) {
            xL.add (byX.get (i));
            yL.add (byY.get (i));
	}

	for (int i = mid + 1; i <n; i ++) {
            xR.add (byX.get (i));
            yR.add (byY.get (i));
	}


	// find the minimum distance from left side and minimum distance from right 
	double dLeft = DivideandConquer (xL, yL, ((int) Math.ceil (n / 2)));
	double dRight = DivideandConquer(xR, yR, ((int) Math.floor (n / 2)));

	double dzone = Math.min(dLeft, dRight);                             //min distance right and left
                        
        Point midP = byX.get(mid);

			
	ArrayList <Point> dStrip = new ArrayList <> ();                     //for any points in the strip the distance between the x and midpoint is the smallest
	for (Point p: byY) {
            if (Math.abs(p.x - midP.x) < dzone) {
		dStrip.add(p);
            }
	}

	double minDist = dzone;                                             //calculating minimum distance of any remaining points within strip
	for (int i = 0; i <dStrip.size () - 2; i ++) {
				
            for (int j = i + 1; j <= dStrip.size () - 1; j ++) {
		double d = distance (dStrip.get (i), dStrip.get (j));
		if (d <dzone) {
                    minDist = Math.min(minDist, d);
                    }
                }
            }
            return minDist;
	}


    public static void main (String [] args) {

			
        long startTime = System.currentTimeMillis();                //start time calculating elapsed time
	ArrayList <Integer> X = new ArrayList <> ();
	ArrayList <Integer> Y = new ArrayList <> ();
        
        
        //Generating random points
	Random rand = new Random ();

	while (X.size () <100) {                                     //the x can be updated here to change size
            int x = rand.nextInt (200) +1;
            if (!X.contains(x)) {
                X.add (x);
            }
	}

	while (Y.size () <100) {                                     //the y can be updated here to change size
	int y = rand.nextInt (200) +1;
	if (! Y.contains (y)) {
            Y.add (y);
	}
    }

    Point [] byX = new Point [100];                                  //the x will also need to be updated here
    Point [] byY = new Point [100];                                  //the y will also need to be updated here

    for (int i = 0; i <100; i ++) {                                  //the i value will also need to be updated here
	Point b = new Point(X.get (i), Y.get (i));
	byX [i] = b;
	byY [i] = b;
    }
    Arrays.sort (byX, compX);                                       //sorted by x
    Arrays.sort (byY, compY);                                       //sorted by y

    ArrayList <Point> setX = new ArrayList <> ();
    ArrayList <Point> setY = new ArrayList <> ();

    for (int i = 0; i <byX.length; i ++) {
	setX.add (byX [i]);
	setY.add (byY [i]);
    }
    
    System.out.println("Number of Points Generated: 100");                               //input of random values also updated here
    System.out.println ("Closest distance: " + DivideandConquer(setX, setY, 100));      //input of random values also updated here
    // System.out.println ("The closest pair: ");
    //System.out.println ("");
    long elapsedTime = System.currentTimeMillis();
    float sec = (elapsedTime - startTime) /  1000F;
    System.out.println("Divide and Conquer Elapsed Time: " + sec + " seconds");
    System.out.println(setX);
                                              
    }
    
} // end of program

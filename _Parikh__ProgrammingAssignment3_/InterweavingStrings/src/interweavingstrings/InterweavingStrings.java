/* Sheetal Parikh
 * Programming Assignment 3
 * Interweaving Strings
 */
package interweavingstrings;

/**
 *
 * @author SheetalParikh
 */
public class InterweavingStrings {
    
    static int Comparisons = 0;                                              //initializing comparison counter

    public static void main(String[] args){
            String x = "101";
           // String x = "1010101010";
           // String x = "11111111111111111111111111111111111111111111111111";
           // String x = "1010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010";
         
            String y = "00";
           // String y = "00000";
           // String y = "00000000000000000000000000000000000000000000000000";
           // String y = "00000000000000000000";
                      
            String s = "100010101";
            // String s = "1111111111111111111111111111111111111111111111111";
            // String s = "1010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010";
            // String s = "100010101100010101100010101100010101100010101100010101100010101100010101100010101100010101100010101100010101100010101100010101";

            System.out.println("String X: " + x);
            System.out.println("String Y: " + y);
            System.out.println("String S: " + s);
            System.out.println("");
            
            if (CheckifInterweaving(x, y, s)) {
		System.out.print("S is an interweaving of X and Y\n");
            } else {
		System.out.print("s is not an interweaving of x and y\n");
            }
            
            System.out.println("Number of Comparisons: " + Comparisons);
            System.out.println("");
	}
    
    public static boolean CheckifInterweaving(String x, String y, String s) {
        
        if (x == null || y == null || s == null) {                      //return false if any of the strings are undefined
            return false;
        }
         
        if (x.length() == 0 && y.length() == 0 && s.length() == 0) {    //return true if x, y, & s are empty - empty strings are interweaving of eachother
            Comparisons += 3;
            return true;
        }
         
        boolean[][] A = new boolean[x.length() + 1][y.length() + 1];    //creating array that is size of length of x and length of y
        A[0][0] = true;                                                 //intializing array
         
        for (int i = 1; i <= x.length(); i++) {                         // string y is empty ; return true if the x character at i-1 matches the i-1 character of string s 
            if (x.charAt(i - 1) == s.charAt(i - 1)) {
                Comparisons ++;
                A[i][0] = true;
            } else break;
        }
         
        for (int i = 1; i <= y.length(); i++) {                         // string x is empty ; return true if the y character at i-1 matches the i-1 character of string s 
            if (y.charAt(i - 1) == s.charAt(i - 1)) {
                Comparisons ++;
                A[0][i] = true;
            } else break;
        }
         
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (s.charAt(i + j - 1) == x.charAt(i - 1)) {          //current character of s matches x
                    A[i][j] = A[i - 1][j];
                    Comparisons ++;
                }
                 
                if (s.charAt(i + j - 1) == y.charAt(j - 1)) {          //current character of s matches y
                    A[i][j] = A[i][j] || A[i][j - 1];
                    Comparisons ++;
                }
            }
        }
         
        return A[x.length()][y.length()];                            //returning final boolean value
    }
}
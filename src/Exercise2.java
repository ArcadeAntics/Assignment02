
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simma1980
 */
public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer plz: "); //asks for a number
        int n = in.nextInt(); //stores number
        System.out.println(sumDigits(n)); //goes to method sumDigits

        System.out.print("Enter a positive integer plz: "); //asks for a number
        n = in.nextInt(); //overwrites older number
        System.out.println(triangle(n)); //goes to method triangle

        System.out.print("Enter a positive integer plz: ");
        n = in.nextInt();
        System.out.println(binaryConvert(n));

        System.out.print("Enter a positive integer plz: ");
        n = in.nextInt();
        System.out.print("Enter a base between 2-16 plz: ");
        int b = in.nextInt();
        System.out.println(convert(n, b));

        in.nextLine();
        System.out.print("Enter a word plz: ");
        String s = in.nextLine();
        System.out.println(isPalindrome(s, s.length()));

        System.out.print("Enter the number of bags plz: ");
        n = in.nextInt();
        int[] bags = new int[n];
        System.out.print("Enter the max num of marbles plz: ");
        int max = in.nextInt();
        System.out.print("Enter num of sorted marbles plz: ");
        for (int i = 0; i < bags.length; i++) {
            bags[i] = in.nextInt();
        }
        System.out.println(marbles(bags, max));
    }

    static int sumDigits(int n) {
        if (n <= 9 && n >= 0) {
            return n; //returns the number once it is a single digit
        }
        return n % 10 + sumDigits(n / 10); //returns the ones column and the number without the last digit  
    }

    static int triangle(int n) {
        if (n == 1 || n == 0) { //should the triangle be only one or zero levels tall
            return n;  //the triangle must only contain the level number of blocks so return the level number
        }
        return triangle(n - 1) + n; //returns current level num of blocks and the level before its num of blocks
    }

    static String binaryConvert(int n) {
        if (n == 1 || n == 0) {
            return "" + n; //if the entered number gets to 1 or 0, return itself
            //0 will only be returned when the original entered number is 0
        }
        return binaryConvert(n / 2) + n % 2; //
    }

    static String letters(int n, int b) {
        if (n >= 0 && n <= 9) {
            return "" + n;
        } else if (b > 10 && n == 10) {
            return "A";
        } else if (b > 11 && n == 11) {
            return "B";
        } else if (b > 12 && n == 12) {
            return "C";
        } else if (b > 13 && n == 13) {
            return "D";
        } else if (b > 14 && n == 14) {
            return "E";
        } else {
            return "F";
        }
    }

    static String convert(int n, int b) {
        if (n >= 0 && n <= 9) {
            return "" + n;
        } else if (b > 10 && n == 10) {
            return "A";
        } else if (b > 11 && n == 11) {
            return "B";
        } else if (b > 12 && n == 12) {
            return "C";
        } else if (b > 13 && n == 13) {
            return "D";
        } else if (b > 14 && n == 14) {
            return "E";
        } else if (b > 15 && n == 15) {
            return "F";
        }
        return convert(n / b, b) + letters(n % b, b);
    }

    static boolean isPalindrome(String s, int length) {
        if (length == 1 || length == 0) {
            return true;
        }
        if (s.charAt(0) == s.charAt(length - 1)) {
            return isPalindrome(s.substring(1, length - 1), length - 2);
        } else {
            return false;
        }

    }

    static int marbles(int[] bags, int max) {
        if (bags.length == 0) {
            return 0;
        }
        int[] leftOvers = new int[bags.length - 1];
        int aBag = bags[0];
        for (int i = 0; i < leftOvers.length; i++) {
            leftOvers[i] = bags[i + 1];
        }
        int with = aBag + marbles(leftOvers, max - aBag);
        int without = marbles(leftOvers, max);
        if (with > without && with <= max) {
            return with;
        } else if (without <= max) {
            return without;
        } else {
            return 0;
        }
    }
}

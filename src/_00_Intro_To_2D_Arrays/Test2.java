package _00_Intro_To_2D_Arrays;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
	 Scanner scan = new Scanner( System.in );
	    System.out.println("This program tells you the product and remainder when dividing 2 integers");
	    System.out.println("This program uses integers only");
	    System.out.print("Enter a numerator: ");
	    int num = scan.nextInt();
	    System.out.print("Enter a denominator: ");
	    int den = scan.nextInt();
	    int rem= num%den;
	    int values= num/den;

	    System.out.print(num+" divided by "+den+" is " + values+ " with a remainder of " + rem );
	   
	  }
}

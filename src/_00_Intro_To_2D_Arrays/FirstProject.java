package _00_Intro_To_2D_Arrays;

import java.util.Scanner;

public class FirstProject {
/* Author: Jessie Shen
 * Period: B5
 * This program is a quadratic formula calculator.
 * It asks the user to enter the a, b, and c, of a quadratic equation.
 */
public static void main(String[] args) {
	Scanner scan= new Scanner(System.in);
	
	System.out.println("This program calculates the sin of an angle in a triangle");
	System.out.println("It asks the user to enter values for the opposite of the angle, and the hypotenuse of the triangle");
	

	System.out.println("Please enter a value for the length of the opposite of the triangle");
	int opp= scan.nextInt();
	
	System.out.println("Please enter a value for the length hypotenuse of the traingle");
	int hyp= scan.nextInt();
	
	double sin;
	sin= (double)opp/hyp;

System.out.println("The sin of an angle in a triangle is "+ sin);
System.out.println("Thank you for using the sin calculator. Please give us a good review!");
}	
	
}

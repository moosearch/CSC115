/**
 * Part1.java
 * Author: Jason Curt
 * Student ID: V00761884
 * CSC115 - A02
 */

import java.util.Random;
import java.util.Arrays;

public class Part1
{
	/**
	 * There are 6 numbers in each lottery ticket
	 */
	public static final int	TOTAL_NUMBERS = 6;

	/**
	 * The smallest number on the ticket is assumed to be 1
	 */

	/**
	 * The largest number on the ticket is 49
	 */
	public static final int MAX_NUMBER	= 49;

	/**
	 * This method populates the array a with numbers
	 * between MIN_NUMBER and MAX_NUMBER
	 *
	 * At present, it does not check for duplicates.
	 */
	public static void generate (int[] a) {
		Random r = new Random();
		for (int s = 0; s < TOTAL_NUMBERS;s++) {
			int tempNum = r.nextInt(MAX_NUMBER) + 1;
			for(int t = 0; t < TOTAL_NUMBERS; t++) {
				if(a[t] == tempNum) {
					s--;
					break;
				} else if(t==(TOTAL_NUMBERS - 1)) {
					a[s] = tempNum;
				}
			}
		}
	}

	/**
	 * This method prints all the elements of an array
	 * on one line enclosed in {}.
	 */
	public static void display (int[] n)
	{
		System.out.print("{");
		for(int i=0;i<n.length;i++)
		{
			System.out.print(n[i]);
			if (i!=n.length-1)
			{
				System.out.print(",");
			}
		}
		System.out.println("}");
	}

	/**
	 * This method is where the program starts.  It
	 * allocates an array, populates the array
	 * with random numbers, sorts those numbers
	 * and finally displays the contents of the array.
	 */
	public static void main (String[] args)
	{
		int[] theNums = new int[TOTAL_NUMBERS];

		generate(theNums);

		/* This is a utility function from java.util.Arrays
		 * that sorts the contents of the array in
		 * ascending order.
		 */
		Arrays.sort(theNums);

		display(theNums);

	}
}

/**
 *LotteryTicket.java
 *Author: Jason Curt
 *Student ID: V00761884
 *CSC115 - A02
 */

import java.util.Random;
import java.util.Arrays;

public class LotteryTicket
{
    /**
	 * There are 6 numbers in each lottery ticket
	 */
	private final int TOTAL_NUMBERS	= 6;

	/**
	 * The smallest number on the ticket is assumed to be 1
	 * The largest number on the ticket is 49
	 */
	private final int MAX_NUMBER = 49;


	private int [] a = new int [TOTAL_NUMBERS];

	/**
	 * This is the General Constructor. It should initialize and populate the
	 * lottery number into the array.
	 */

	public LotteryTicket()
	{
		generate(a);
		Arrays.sort(a);
	}

	/**
	 * This method populates the array a with numbers
	 * between MIN_NUMBER and MAX_NUMBER and ensures there are no duplicate numbers.
	 */
	private void generate (int[] a) {
		Random r = new Random();
		for (int s = 0; s < this.TOTAL_NUMBERS;s++) {
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
	 * This method should return the numbers in the lottery ticket as a printable String,
	 * in the same format as the one used by the display method in Part 1.
	 */
	public String toString() {
		String numbers = "{";
		for(int i=0;i<a.length;i++) {
			numbers += a[i];
			if (i!=a.length-1) {
				numbers += ",";
			}
		}
		return numbers + "}";
	}

	/**
	 * This method compares two sets of LotteryTicket and returns a boolean (true or false)
	 * indicating whether they match. LotteryDraw uses this method to determine if it has found a
	 * winning ticket, so it is very important that it function properly.
	 */
	public boolean matches(LotteryTicket other) {
		/*
		 * Based on the logic of this lottery program we know that for each Lottery Ticket:
		 * 1) all numbers are sorted lowest to highest
		 * 2) No numbers are the same
		 *
		 */
		 boolean check = Arrays.equals(a, other.a);
		return check;
	}
}

// ListTester.java
import java.util.Arrays;


public class ListTesterR
{
	private final static int LIST_SIZE = 100000;

	private static int runTheTest(IntListRecursive list, boolean which ) {
		String whichName = "";
		boolean passed = true;
		if (which)
			whichName = "binary";
		else
			whichName = "linear";

		System.out.println("Testing " + whichName + " search... ");

		for( int i=0; i<list.getCapacity(); i++ ) {

			if (list.find(i, which) != i)
			{
				System.out.println("failed to find "+ i);
				passed = false;
				break;
			}
		}
		if (passed)
			System.out.println("passed.");
		return list.getNumberofComparisons();
	}

	/*
	 * Fill the list with the values from 0 to count-1.
	 */
	private static void fill(IntListRecursive list, int count) {
		for( int i=0; i<count; i++ )
		{
			list.insertElement(i);
		}
	}

	public static void main(String args[]) {
		int newSize = 1;
		for(int i = 1; i < 6; i++) {
			newSize *= 10;
			IntListRecursive l1 = new IntListRecursive(newSize);
			fill(l1, newSize);
			int LS = runTheTest(l1, false);
			int BS = runTheTest(l1, true) - LS;
			System.out.print("Length = " + newSize);
			System.out.print(", LS: " + LS + " comparisons, ");
			System.out.println("BS: " + BS + " comparisons");
		}
	}
}

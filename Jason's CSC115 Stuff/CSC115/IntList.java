/*Jason Curt - V00761884 - CSC115 - A02*/

public class IntList
{
	private	int [] storage;
	private int count;  // number of values stored into the array
	private int BScompare = 0; //counts number of comparisons made in binary search
	private int LScompare = 0; //counts number of comparisons made in linear search

	public IntList(){
		storage = new int[100000];
		count = 0;
	}

	public IntList(int size) {
		if (size <= 0)
			throw new IndexOutOfBoundsException("invalid capacity for an IntList");
		storage = new int[size];
		count = 0;
	}

	// Returns number of values in the IntList
	public int count() {
		return count;
	}

	// Returns the element at position pos in the IntList
	public int getElement( int pos ) {
		if (pos < 0 || pos >= count)
			throw new IndexOutOfBoundsException("non-existent element");
		return storage[pos];
	}

	// Inserts a new value into the IntList
	// The list of values is supposed to be in ascending order ...
	// however the code to put the values into order is not yet implemented
	public void insertElement( int val ) {
		if (count >= storage.length)
			throw new IndexOutOfBoundsException("IntList has no space for a new element");
		storage[count++] = val;
		// We may need to swap elements until they are in sorted order again.
		boolean check = true;
		int temp;
		while(check)
		{
			check = false;
			for(int i = count-1; i > 0; i--)
			{
				if(storage[i] < storage[i-1])
				{
					temp = storage[i];
					storage[i] = storage[i-1];
					storage[i-1]=temp;
					check = false;
				}
			}
		}
	}

	/**
	 * Searches the list using binary search.
	 *
	 * Returns the position in the list where the value occurs.
	 * The list must be in sorted order.
	 * If the value is not found, the result is -1
	 */
	public int binarySearch( int value ) {
		int	low = 0;
		int	high = count-1;

		while (low <= high) {
			BScompare++;
			int mid = (low+high) / 2;

			if (storage[mid] == value)
				return mid;
			else if (value < storage[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	/**
	 * Searches the list using linear search.
	 *
	 * Returns the position in the list where value occurs.
	 * Does NOT require the list to be in sorted order.
	 * If the value is not found, the result is -1
	 */
	public int linearSearch (int value)
	{
		for( int i=0; i<count; i++ )
		{
			LScompare++;
			if (storage[i] == value)
				return i;
		}
		return -1;
	}

	// Invokes binary search if binary is true, otherwise it
	// invokes linear search
	public int find(int value, boolean binary)
	{
		if (binary)
			return binarySearch(value);
		else
			return linearSearch(value);
	}

	//Returns size of the storage array
	public int getCapacity(){
		return storage.length;
	}

   //Expands or contracts the storage array by allocating a new array of the
   //desired size and copying the elements over.  Do not allow it
   // to contract the array to less than the count value.
   public void setCapacity(int newCapacity) {
	   if(newCapacity > count) {
	   		int [] newArray = new int [newCapacity];
	  		for(int i = 0; i < storage.length; i++) {
		   		 newArray[i] = storage[i];
	   		}
	 		storage = newArray;
	   }
   }

   // Returns the numbers in the IntList as a String.
   public String toString()
   {
	   String result = "[";
	   for(int i = 0; i < count; i++) {
		   if(i == 0) {
			   result += storage[i];
		   } else {
			   result += ", " + storage[i];
		   }
	   }
	   return result + "]";
   }

   //returns the total number of comparisons made by both searches
   public int getNumberofComparisons() {
	   return BScompare + LScompare;
   }

	// a unit tester that tests the methods in this class.
	public static void main(String[] args)
	{
		IntList x = new IntList(10);
		for(int i = 0; i < 9; i++) {
			x.insertElement(i);
		}
		x.insertElement(5);
		System.out.println(x.find(4, true));
		System.out.println(x.find(4, false));
		x.setCapacity(11);
		System.out.println(x.getNumberofComparisons());
		System.out.println(x);
		// Create an IntList object and test all of its methods,
		// make sure they work before moving on to Part 2.
	}
}
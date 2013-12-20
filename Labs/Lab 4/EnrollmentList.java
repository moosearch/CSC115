public interface EnrollmentList{
	/**
	 * Adds a person to the end of the list.
	 * @param the person being added to the list
	 */
	public void addPerson(Person addition);

	/**
	 * Removes the first person with the specified name from the list, does
	 * not need to maintain the order of the list, so you can remove the element
	 * by replacing it with the one at the end of the array.
	 * @param the name of the person to be removed from the list.
	 */
	public void removePerson(String name);

	/**
	 * Returns the first person in the list with the specified name.
	 * @param the name of the person to find in the list.
	 * @return the Person with the specified name, or null if there is
	 * no such Person in the list.
	 */
	public Person find(String name);

	/**
	 * Return all Students in the list as a String.
     * Note that you can check the class of an object using the instanceof command, like so:
     * if (object instanceof Student)
	 * @return a String containing the printable form of all students in the list.
	 */
	public String listStudents();

	/**
	 * Return all Employees in the list as a String.
	 * Note that you can check the class of an object using the instanceof command, similar
	 * to listStudents().
	 * @return a String containing the printable form of all employees in the list.
	 */
	public String listTAs();

	/**
	 * Sorts the list using Arrays.sort from the Java API.
	 * LEAVE THIS METHOD EMPTY UNTIL YOU GET TO PART 3 OF THE LAB!
	 */
	public void sort();
}
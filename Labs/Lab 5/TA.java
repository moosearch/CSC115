public class TA extends Person{
    private int employeeNumber;
	private int salary;
	private int studentNumber;
	
	public TA(String taName, String taEmail, int taEmployeeNumber, int taSalary, int taStudentNumber){
		setName(taName);
		setEmail(taEmail);
		employeeNumber = taEmployeeNumber;
		salary = taSalary;
		studentNumber = taStudentNumber;
	}

	public int getSalary(){
		return salary;
	}

	public void setEmployeeNumber(int newEmployeeNumber){
		employeeNumber = newEmployeeNumber;
	}

	public int getStudentNumber(){
		return studentNumber;
	}
	
	public void setSalary(int newSalary){
		salary = newSalary;
	}
	
	public String toString(){
		return "TA: " + super.toString() + ", Employee#: " + employeeNumber + ", Salary: " + salary + ", Student#: " +studentNumber;
	}

	public static void main(String[] args){
		TA test = new TA("Luke", "luke@skywalker.ca", 999956, 50, 86);
		System.out.println(test);
	}
}
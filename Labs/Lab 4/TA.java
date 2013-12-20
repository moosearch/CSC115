public class TA extends Person{
    private int employeeNumber;
    private int salary;
    private int studentNumber;

    //constructor
    public TA(String taName, String taEmail, int
    taEmployeeNumber, int taSalary, int taStudentNumber){
        setName(taName);
        setEmail(taEmail);
        employeeNumber=taEmployeeNumber;
        salary = taSalary;
        studentNumber = taStudentNumber;
    }

    //getter
    public int getEmployeeNumber(){
        return employeeNumber;
    }
    public int getSalary(){
        return salary;
    }
    public int getStudentNumber(){
        return studentNumber;
    }
    //setter
    public void setEmployeeNumber(int taEmployeeNumber){
        employeeNumber = taEmployeeNumber;
    }
    public void setSalary(int taSalary){
        salary = taSalary;
    }
    public void setStudentNumber(int taStudentNumber){
        studentNumber = taStudentNumber;
    }
    //toString method
    public String toString(){
        return "TA: "+super.toString()+", Employee#: "
        +employeeNumber+",Salary: "+salary+",\nStudent#: "+studentNumber;
    }

    public static void main(String [] args){
        TA tester = new TA("Name", "email@hotmail.com", 1234567,26000,00727646);
        System.out.println(tester);
    }
}
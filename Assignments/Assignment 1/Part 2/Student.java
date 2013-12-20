// Assumption:  For simplification, the programmer has assumed that all courses have the same weight
//                    (A future improvement(??)!)


public class Student {

  private String name;  //Name of the student.
  private long id; // (integer portiont of) student's identification number.
  private String[][] course;  // Course code of Courses completed by student, organized by term.
  private String[][] courseLetter; //The letter grades achieved in each course.
  private double cumulativeGPA; // the student's cumulative GPA

  // Default Constructor
  public Student() {
    this.name = "";
    this.id = 0;
    this.course = new String[1][1];
    this.courseLetter = new String [1][1];
    this.cumulativeGPA = -1; // Indicates no courses have been included in GPA calculation
  }
  // Constructor with useful values for a new student, no courses completed yet
  public Student(String name, long id) {
    this.name = name;
    if (id > 0) this.id = id;
    else {
      System.err.println("ERROR: Incorrect ID number: default ID used for " + this.name);
      this.id = 0;
    }
    this.course = new String[1][1];
    this.courseLetter = new String [1][1];
    this.cumulativeGPA = -1; // Indicates no courses have been included in GPA calculation
  }
  // Constructor with useful values for a new student, with completed courses
  public Student(String name, long id, String[][] course, String[][] courseLetter) {
    this.name = name;
    this.id = id;
    this.course = course;
    this.courseLetter = courseLetter;
    this.cumulativeGPA = calculateGPAs();
  }

  private double calculateGPAs() {
    int counter = 0;
    double sum = 0.0;
    for (int term = 0; term < this.courseLetter.length; term++) {
      for (int index = 0; index < this.courseLetter[term].length; index++) {
        int gradePoint;
        if (this.courseLetter[term][index].equals("A+")) gradePoint= 9;
        else if (this.courseLetter[term][index].equals("A")) gradePoint = 8;
        else if (this.courseLetter[term][index].equals("A-")) gradePoint = 7;
        else if (this.courseLetter[term][index].equals("B+")) gradePoint = 6;
        else if (this.courseLetter[term][index].equals("B")) gradePoint = 5;
        else if (this.courseLetter[term][index].equals("B-")) gradePoint = 4;
        else if (this.courseLetter[term][index].equals("C+")) gradePoint = 3;
        else if (this.courseLetter[term][index].equals("C")) gradePoint = 2;
        else if (this.courseLetter[term][index].equals("D")) gradePoint = 1;
        else gradePoint = 0;
        sum += gradePoint;
        counter++;
      }
    }
    return sum/counter;
  }

  // Getter and Setter for the name attribute
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  // Getter and Setter for height attribute
  public long getId() {
    return this.id;
  }
  public void setId(long id) {
    if (id > 0)
      this.id = id;
    else System.err.println("ERROR: Incorrect ID number: attribute not updated");
  }

  // Getters and Setter for course attribute
  public String[][] getCourseReference() {  // returns a reference to the array of course names
    return this.course;
  }
  public String getCourse() {  // returns a String showing all course names
    String result = "";
    for (int term = 0; term < this.course.length; term++) {
      for (int index = 0; index < this.course[term].length; index++) {
        result += course[term][index] + " ";
      }
      result += "\n";
    }
    return result;
  }
  public void setCourse(int term, int whichCourse, String courseName) {  // returns a String showing all course names
      this.course[term][whichCourse] = courseName;
  }
  //


  // Getter and Setter for courseLetter attribute
  public String[][] getCourseLetterReference() {  // returns a reference to the array of course letter grades
    return this.courseLetter;
  }
  public String getCourseLetter() {  // returns a String showing all course letter grades
    String result = "";
    for (int term = 0; term < this.courseLetter.length; term++) {
      for (int index = 0; index < this.courseLetter[term].length; index++) {
        result += this.courseLetter[term][index] + " ";
      }
      result += "\n";
    }
    return result;
  }
  //only allows changing one course grade.  Multiples, requires multiple calls
  //Expects termId in the form of <year><start month>.  For example Fall 2012 is termId=201209
  public void setCourseLetter(int term, int whichCourse, String newLetter) {
    this.courseLetter[term][whichCourse] = newLetter;
  }

  //Setter method for the cumulativeGPA
  public double getCumulativeGPA() {
      return this.cumulativeGPA;
  }

  public String toString() {
    String result = this.name + this.id +":\n________________________\n";
    for (int term = 0; term < this.course.length; term++) {
      for (int index = 0; index < this.course[term].length; index++) {
        result += this.course[term][index] + ":" + this.courseLetter[term][index] + "\t";
      }
      result += "\n";
    }
    return result;
  }

  public boolean equals(Student other) {
    boolean samePerson = false;
    if (this.name.equals(other.name) && this.id == other.id ) {
      samePerson = true;
    }
    return samePerson;
  }

  public static void main(String[] args) {
    // a place for testing methods of this class
    Student [] mrArray = new Student[2];
    String [][] courses = new String[1][1];
    String [][] grades = new String[1][1];
    mrArray[0] = new Student("name",1234,courses,grades);
    mrArray[1] = new Student("dyourmome",1234);

    boolean tester = mrArray[0].equals(mrArray[1]);
    System.out.println(tester);
  }

}
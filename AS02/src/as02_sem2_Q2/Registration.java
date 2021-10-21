package as02_sem2_Q2;

/**
 * Registration is the main class for Question 2
 * @author Anthony Nadeau
 */
public class Registration {
    private String studentID;
    private int noOfCourses;
    
    /**
     * Default Constructor
     */
    public Registration() {
        this.studentID = null;
        this.noOfCourses = 3;
    }
    
    /**
     * Parameterized Constructor
     * @param studentID Id of the student registering
     * @param noOfCourses number of courses being registered 
     */
    public Registration(String studentID, int noOfCourses) {
        this.studentID = studentID;
        this.noOfCourses = noOfCourses;
    }
    
    /**
     * Copy Constructor
     * @param register registration object being copied
     */
    public Registration(Registration register) {
        this.studentID = register.studentID;
        this.noOfCourses = register.noOfCourses;
    }
    
    /**
     * Converts the object into a string
     * @return the object as a string
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("Student ID is: %s\n", studentID);
        str += String.format("Number of Courses is: %d\n", noOfCourses);
        return str;
    }
    
    /**
     * Registers courses (adds to noOfCourses)
     * @param num the amount of courses to add
     * @throws CourseRegisterException if the number of courses being added doesn't
     * follow the restrictions (if the total number of courses exceeds 6 or if num is negative)
     */
    public void registerCourse(int num) throws CourseRegisterException {
        if (noOfCourses + num > 6)
            throw new CourseRegisterException("Exceeding course registration limit");
        else if (num < 0)
            throw new CourseRegisterException("Invalid option.");
        else
            noOfCourses += num;             
    }
    
    /**
     * Withdraws from courses (subtracts from noOfCourses)
     * @param num the amount of courses to subtract
     * @throws CourseWithdrawException if the number of courses being subtracted doesn't
     * follow the restrictions (if the total number of courses is less than 2 or if num is negative)
     */
    public void withdrawCourse(int num) throws CourseWithdrawException {
        if (noOfCourses - num < 2)
            throw new CourseWithdrawException("Insufficient courses. Must be "
                    + "registered for atleast 2");
        else if (num < 0)
            throw new CourseWithdrawException("Invalid option.");
        else
            noOfCourses -= num;
    }
    
    /**
     * Verifies that the student ID follows the format of Letter and 4 numbers (e.g. 'A1000')
     * @param studentID ID being verified
     * @throws InvalidStudentIdException if the ID doesn't follow the proper format
     */
    public void checkStudentID(String studentID) throws InvalidStudentIdException {
        if (studentID.length() == 5 && Character.isLetter(studentID.charAt(0)) 
                && Character.isDigit(studentID.charAt(1))
                && Character.isDigit(studentID.charAt(2)) 
                && Character.isDigit(studentID.charAt(3))
                && Character.isDigit(studentID.charAt(4)))
            this.studentID = studentID;
        else
            throw new InvalidStudentIdException("Invalid Student ID");   
    }

    public String getStudentID() {
        return studentID;
    }

    public int getNoOfCourses() {
        return noOfCourses;
    }
    
    
}
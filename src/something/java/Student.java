package something.java;
/**
 * Student
 * Stores student information
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class Student {

	
	String student;
	int id;
    /**
     * Student constructor
     * @param id
     * @param student
     */
    public Student(int id, String student)
    {
    	super();
    	this.student = student;
    	this.id = id;
    }
    /**
     * gets id
     * @return id
     */
    public int getId()
    {
    	return id;
    }
    /**
     * Sets id
     * @param id
     */
    public void setId(int id)
    {
    	this.id=id;
    }
    /**
     * Gets student
     * @return student
     */
    public String getStudent()
    {
    	return student;
    }
    /**
     * sets Student
     * @param student
     */
    public void setStudent(String student)
    {
    	this.student=student;
    }
}

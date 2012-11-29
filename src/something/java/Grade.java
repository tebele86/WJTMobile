package something.java;
/**
 * Grade
 * Stores grade information
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class Grade 
{
	
	int id;
    String assignment;
    String grade;

   /**
    * Grade constructor
    * @param id
    * @param assignment
    * @param grade
    */
    public Grade(int id, String assignment, String grade)
    {
    	super();
    	this.id = id;
    	this.assignment = assignment;
    	this.grade = grade;
    	
    }
    /**
     * gets Id
     * @return id
     */
    public int getId()
    {
    	return id;
    }
    /**
     * sets id
     * @param id
     */
    public void setId(int id)
    {
    	this.id=id;
    }
    /**
     * gets assignment
     * @return assignment
     */
    public String getAssignment()
    {
    	return assignment;
    }
    /**
     * sets assignment
     * @param assignment
     */
    public void setAssignment(String assignment)
    {
    	this.assignment = assignment;
    }
    /**
     * gets grade
     * @return grade
     */
    public String getGrade()
    {
    	return grade;
    }
    /**
     * sets grade
     * @param grade
     */
    public void setGrade(String grade)
    {
    	this.grade = grade;
    }

}

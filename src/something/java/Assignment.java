package something.java;

/**
 * Assignment
 * Class stores assignment information
 * @author Joseph Beckner and Tyrel Ebele
 * 
 */
/*
* From http://code.google.com/p/myandroidwidgets/source/browse/trunk/Phonebook/src/com/abeanie/Phonebook.java
* description found at http://techdroid.kbeanie.com/2009/07/custom-listview-for-android.html
*/
//Creates Assignment class to store assignments
public class Assignment {
        int id;
        String course;
        String assignmentName;
        String description;
        String dueDate;
       //Constructor
        public Assignment(int id, String course, String assignmentName, String description, String dueDate)
        {
        	super();
        	this.id = id;
        	this.course = course;
        	this.assignmentName = assignmentName;
        	this.description = description;
        	this.dueDate = dueDate;
        }
        /**
         * Gets id
         * @return int id
         */
        public int getId()
        {
        	return id;
        }
        /**
         * Sets ID
         * @param id
         */
        public void setId(int id)
        {
        	this.id=id;
        }
        /**
         * Gets Course
         * @return string course
         */
        public String getCourse()
        {
        	return course;
        }
        /**
         * sets course
         * @param course
         */
        public void setCourse(String course)
        {
        	this.course = course;
        }
        /**
         * gets assignment
         * @return string assignmentName
         */
        public String getAssignmentName()
        {
        	return assignmentName;
        }
        /**
         * sets assignment name
         * @param assignmentName
         */
        public void setAssignmentName(String assignmentName)
        {
        	this.assignmentName = assignmentName;
        }
        /**
         * gets description
         * @return string description
         */
        public String getDescription()
        {
        	return description;
        }
        /**
         * sets description
         * @param description
         */
        public void setDescription(String description)
        {
        	this.description = description;
        }
        /**
         * Gets dueDate
         * @return string duedate
         */
        public String getDueDate()
        {
        	return dueDate;
        }
        /**
         * sets dueDate
         * @param dueDate
         */
        public void setDueDate(String dueDate)
        {
        	this.dueDate = dueDate;
        }
     
}
package something.java;

/*
* From http://code.google.com/p/myandroidwidgets/source/browse/trunk/Phonebook/src/com/abeanie/Phonebook.java
* description found at http://techdroid.kbeanie.com/2009/07/custom-listview-for-android.html
*/
/**
 * Course
 * Stores data for course
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
//Creates Courses class
public class Course {
        int id;
        String course;
        String prof;
        String grade;
       /**
        * Course constructor
        * @param id
        * @param course
        * @param prof
        * @param grade
        */
        public Course(int id, String course, String prof, String grade)
        {
        	super();
        	this.id = id;
        	this.course = course;
        	this.prof = prof;
        	this.grade = grade;
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
         * sets id
         * @param id
         */
        public void setId(int id)
        {
        	this.id=id;
        }
        /**
         * gets course
         * @return course
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
         * gets professor
         * @return prof
         */
        public String getProf()
        {
        	return prof;
        }
        /**
         * sets professor
         * @param prof
         */
        public void setProf(String prof)
        {
        	this.prof = prof;
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
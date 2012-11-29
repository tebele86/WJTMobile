package something.java;

/*
* From http://code.google.com/p/myandroidwidgets/source/browse/trunk/Phonebook/src/com/abeanie/Phonebook.java
* description found at http://techdroid.kbeanie.com/2009/07/custom-listview-for-android.html
*/
/**
 * Attendance
 * Creates class for storing attendance
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
//Creates Assignment class
public class Attendance 
{
        int id;
        String course;
        String tardy;
        String absent;
        String totalDays;
       /**
        * Attendance constructor
        * @param id
        * @param course
        * @param tardy
        * @param absent
        * @param totalDays
        */
        public Attendance(int id, String course, String tardy, String absent, String totalDays)
        {
        	super();
        	this.id = id;
        	this.course = course;
        	this.tardy = tardy;
        	this.absent = absent;
        	this.totalDays = totalDays;
        }
        /**
         * Get Id
         * @return id
         */
        public int getId()
        {
        	return id;
        }
        /**
         * Set id
         * @param id
         */
        public void setId(int id)
        {
        	this.id=id;
        }
        /**
         * get course
         * @return course
         */
        public String getCourse()
        {
        	return course;
        }
        /**
         * set Course
         * @param course
         */
        public void setCourse(String course)
        {
        	this.course = course;
        }
        /**
         * get Tardies
         * @return tardy
         */
        public String getTardy()
        {
        	return tardy;
        }
        /**
         * setTardy
         * @param tardy
         */
        public void setTardy(String tardy)
        {
        	this.tardy = tardy;
        }
        /**
         * getAbsent
         * @return absent
         */
        public String getAbsent()
        {
        	return absent;
        }
        /**
         * setAbsent
         * @param absent
         */
        public void setAbsent(String absent)
        {
        	this.absent = absent;
        }
        /**
         * get totalDays
         * @return totalDays
         */
        public String getTotalDays()
        {
        	return totalDays;
        }
        /**
         * setTotalDays
         * @param totalDays
         */
        public void setTotalDays(String totalDays)
        {
        	this.totalDays = totalDays;
        }
     
}
package something.java;

import android.app.Application;
//Help moving data between tabs found from
//http://www.jameselsey.co.uk/blogs/techblog/android-implementing-global-state-share-data-between-activities-and-across-your-application/

/**
 * GlobalState
 * Class used as object to transfer data 
 * between tabs easily
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class GlobalState extends Application
{
private String student;
 /**
  * Gets student
  * @return student
  */
public String getGlobalStudent() {
return student;
}
/**
 * sets student
 * @param student
 */
public void setGlobalStudent(String student) {
this.student = student;
}
}
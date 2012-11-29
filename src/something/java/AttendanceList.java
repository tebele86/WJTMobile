package something.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
/**
 * AttendanceList
 * Creates list of all attendance
 * calls adapter to fill view
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class AttendanceList extends Activity
{
	Intent intent;
	int id;
	DataPhp myData;
	int index =0;
	String student;
	List<Attendance> listOfAttendance;
	AttendanceAdapter adapter;
	ListView list;
	
	/**
	 * Checks what data to request
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.attendance_list);        
       list = (ListView) findViewById(R.id.lvAttendanceList);
       list.setClickable(false);
       
       Tabs.globalStudent = (GlobalState) getApplication();
       student = Tabs.globalStudent.getGlobalStudent();
       index = Integer.parseInt(student);
       
       try {
			if(Tabs.username.equalsIgnoreCase("Joe"))
			{			
				myData = new DataPhp("7");
			}
			else if(Tabs.username.equalsIgnoreCase("Tyrel"))
			{				
				myData = new DataPhp("8");
			}
			else
			{				
				myData = new DataPhp("-1");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		createLists();
       
    
        
        
	}
	
	/**
	 * Sets onResume to get student state and create Lists
	 */
	protected void onResume()
    {
    	super.onResume();
		// Get values
    	
        Tabs.globalStudent = (GlobalState) getApplication();
        student = Tabs.globalStudent.getGlobalStudent();
        index = Integer.parseInt(student);
        //System.out.println("If this works I'll be blown away!  " + s);
        createLists();
    }
	/**
	 * Creates lists off attendance
	 */
	private void createLists()
	{
			listOfAttendance = new ArrayList<Attendance>();
	       if(Tabs.username.equalsIgnoreCase("Joe"))
	       {
	    	   listOfAttendance.add(new Attendance(myData.getAttendanceUserOneIndex(), 
	    			   myData.getAttendanceUserOneClassOneName(),
	    			   myData.getAttendanceUserOneClassOneTardies(),
	    			   myData.getAttendanceUserOneClassOneAbsence(),
	    			   myData.getAttendanceUserOneClassOneDays()));
	    	   listOfAttendance.add(new Attendance(myData.getAttendanceUserOneClassTwoIndex(), 
	    			   myData.getAttendanceUserOneClassTwoName(),
	    			   myData.getAttendanceUserOneClassTwoTardies(),
	    			   myData.getAttendanceUserOneClassTwoAbsence(),
	    			   myData.getAttendanceUserOneClassTwoDays()));
	       }
	       else
	       {
	    	     // 0 is Mike, 1 is Sally, 2 is John
	    	   if(index == 0)
	    	   {
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoClassPositionOneClassOneIndex(), 
	    				   myData.getAttendanceUserTwoPositionOneClassOneName(),
	    				   myData.getAttendanceUserTwoPositionOneClassOneTardies(),
	    				   myData.getAttendanceUserTwoPositionOneClassOneAbsence(),
	    				   myData.getAttendanceUserTwoPositionOneClassOneDays()));
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoPositionOneClassTwoIndex(), 
	    				   myData.getAttendanceUserTwoPositionOneClassTwoName(),
	    				   myData.getAttendanceUserTwoPositionOneClassTwoTardies(),
	    				   myData.getAttendanceUserTwoPositionOneClassTwoAbsence(),
	    				   myData.getAttendanceUserTwoPositionOneClassTwoDays()));
	    	   }
	    	   else if(index == 1)  
	    	   {
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoClassPositionTwoClassOneIndex(), 
	    				   myData.getAttendanceUserTwoPositionTwoClassOneName(),
	    				   myData.getAttendanceUserTwoPositionTwoClassOneTardies(),
	    				   myData.getAttendanceUserTwoPositionTwoClassOneAbsence(),
	    				   myData.getAttendanceUserTwoPositionTwoClassOneDays()));
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoPositionTwoClassTwoIndex(), 
	    				   myData.getAttendanceUserTwoPositionTwoClassTwoName(),
	    				   myData.getAttendanceUserTwoPositionTwoClassTwoTardies(),
	    				   myData.getAttendanceUserTwoPositionTwoClassTwoAbsence(),
	    				   myData.getAttendanceUserTwoPositionTwoClassTwoDays()));
	    	   }
	    	   else
	    	   {
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoClassPositionThreeClassOneIndex(), 
	    				   myData.getAttendanceUserTwoPositionThreeClassOneName(),
	    				   myData.getAttendanceUserTwoPositionThreeClassOneTardies(),
	    				   myData.getAttendanceUserTwoPositionThreeClassOneAbsence(),
	    				   myData.getAttendanceUserTwoPositionThreeClassOneDays()));
	    		   listOfAttendance.add(new Attendance(myData.getAttendanceUserTwoPositionThreeClassTwoIndex(), 
	    				   myData.getAttendanceUserTwoPositionThreeClassTwoName(),
	    				   myData.getAttendanceUserTwoPositionThreeClassTwoTardies(),
	    				   myData.getAttendanceUserTwoPositionThreeClassTwoAbsence(),
	    				   myData.getAttendanceUserTwoPositionThreeClassTwoDays()));
	    	   }
	    	   
	       }
	       adapter = new AttendanceAdapter(this, listOfAttendance);
	       list.setAdapter(adapter);
	}
}
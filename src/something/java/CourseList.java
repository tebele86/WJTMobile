package something.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Course List
 * Stores list of course(s)
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class CourseList extends Activity
{
	Intent intent;
	int id;
	String savePos;
	DataPhp myData;
	int index =0;
	String student;
	List<Course> listOfCourses;
	ListView list;
	/**
	 * Finds what information to request
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);
        
        Tabs.globalStudent = (GlobalState) getApplication();
        student = Tabs.globalStudent.getGlobalStudent();
        
        list = (ListView) findViewById(R.id.lvCourseList);
        list.setClickable(true);
        
        //listOfCourses = new ArrayList<Course>();
        index = Integer.parseInt(student);
        
        
        try {
			if(Tabs.username.equalsIgnoreCase("Joe"))
			{			
				myData = new DataPhp("3");
			}
			else if(Tabs.username.equalsIgnoreCase("Tyrel"))
			{				
				myData = new DataPhp("4");
			}
			else
			{				
				myData = new DataPhp("-1");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		createLists();
		
		
     
        
	}
	/**
	 * finish
	 */
	@Override
	public void finish() 
    {
		Intent data = new Intent();
		//data.putExtra("student", id);
		setResult(RESULT_OK, data);
		super.finish();
	}
	/**
	 * Calls CourseTabs intent sends student and position to new intent
	 * @param view
	 */
	public void callIntent(View view) 
	{
		intent = new Intent(this, CourseTabs.class);
		intent.putExtra("stud", student);
		intent.putExtra("savePos", savePos);
		// Set the request code to any code you like, you can identify the
		// callback via this code
		startActivityForResult(intent, 6);
	}
/**
 * On resume gets student and creates list
 */
    protected void onResume()
    {
    	super.onResume();
		// Get values
        Tabs.globalStudent = (GlobalState) getApplication();
        student = Tabs.globalStudent.getGlobalStudent();
        index = Integer.parseInt(student);
        //System.out.println("If this works I'll be blown away!  " + student);
        createLists();
    }
	/**
	 * Creates list of courses from website and calls to adapter to edit the view
	 */
    private void createLists()
    {
    	listOfCourses = new ArrayList<Course>();
    	   if(Tabs.username.equalsIgnoreCase("Joe"))
           {
           	listOfCourses.add(new Course(myData.getCoursesUserOneIndex(),
           			myData.getCoursesUserOneName(), 
           			myData.getCoursesUserOneProfessor(),
           			myData.getCoursesUserOneGrade()));
           	listOfCourses.add(new Course(myData.getCoursesUserOneClassTwoIndex(),
           			myData.getCoursesUserOneClassTwoName(), 
           			myData.getCoursesUserOneClassTwoProfessor(),
           			myData.getCoursesUserOneClassTwoGrade()));
           }
           else
           {
           	//int index = 2;  // 0 for mike, 1 for sally, 2 for john
           	if(index == 0)
           	{
           		listOfCourses.add(new Course(myData.getCoursesUserTwoPositionOneClassOneIndex(),
               			myData.getCoursesUserTwoPositionOneClassOneName(),
               			myData.getCoursesUserTwoPositionOneClassOneProfessor(),
               			myData.getCoursesUserTwoPositionOneClassOneGrade()));
               	listOfCourses.add(new Course(myData.getCoursesUserTwoPositionOneClassTwoIndex(),
               			myData.getCoursesUserTwoPositionOneClassTwoName(),
               			myData.getCoursesUserTwoPositionOneClassTwoProfessor(),
               			myData.getCoursesUserTwoPositionOneClassTwoGrade()));
           	}
           	else if(index == 1)
           	{
           		listOfCourses.add(new Course(myData.getCoursesUserTwoPositionTwoClassOneIndex(),
               			myData.getCoursesUserTwoPositionTwoClassOneName(),
               			myData.getCoursesUserTwoPositionTwoClassOneProfessor(),
               			myData.getCoursesUserTwoPositionTwoClassOneGrade()));
               	listOfCourses.add(new Course(myData.getCoursesUserTwoPositionTwoClassTwoIndex(),
               			myData.getCoursesUserTwoPositionTwoClassTwoName(),
               			myData.getCoursesUserTwoPositionTwoClassTwoProfessor(),
               			myData.getCoursesUserTwoPositionTwoClassTwoGrade()));
           	}
           	else
           	{
           		listOfCourses.add(new Course(myData.getCoursesUserTwoPositionThreeClassOneIndex(),
               			myData.getCoursesUserTwoPositionThreeClassOneName(),
               			myData.getCoursesUserTwoPositionThreeClassOneProfessor(),
               			myData.getCoursesUserTwoPositionThreeClassOneGrade()));
               	listOfCourses.add(new Course(myData.getCoursesUserTwoPositionThreeClassTwoIndex(),
               			myData.getCoursesUserTwoPositionThreeClassTwoName(),
               			myData.getCoursesUserTwoPositionThreeClassTwoProfessor(),
               			myData.getCoursesUserTwoPositionThreeClassTwoGrade()));
           	}
           }
          
           CourseAdapter adapter = new CourseAdapter(this, listOfCourses);
           
           list.setOnItemClickListener(new OnItemClickListener() 
           {
               //@Override
               public void onItemClick(AdapterView<?> arg0, View view, int position, long index) 
               {
               	//System.out.println("position is: "+ position);
               	savePos = position+"";
               	id = position;
               	callIntent(view);
               
               }
           });
           
           list.setAdapter(adapter);
           
    }
}
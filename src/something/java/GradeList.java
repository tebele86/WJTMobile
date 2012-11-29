package something.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
/**
 * GradeList
 * Creates list of grades
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class GradeList extends Activity
{
	Intent intent;
	int id;
	List<Grade> listOfGrade;
	TextView course;
	DataPhp myData;
	int index=0; 
	/**
	 * requests data to construct lists
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_list);        
        ListView list = (ListView) findViewById(R.id.lvGrades);
        course = (TextView) findViewById(R.id.tvCourse);
        list.setClickable(true);
        
        
       listOfGrade = new ArrayList<Grade>();
       index = Integer.parseInt(CourseTabs.student);
       
			
       //System.out.println("Index clicked is: " + CourseTabs.pos);
       try {
			if(Tabs.username.equalsIgnoreCase("Joe"))
			{	
				if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
				{
					myData = new DataPhp("11");	
					course.setText("Math");
				}
				else
				{
					myData = new DataPhp("12");
					course.setText("English");
				}
					
							
			}
			else if(Tabs.username.equalsIgnoreCase("Tyrel"))
			{	
				
				if(index == 0)  // 0 mike, 1 sally, 2 John
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("13");
						course.setText("History");
						
					}
					else
					{
						myData = new DataPhp("14");
						course.setText("Calculus");
					}
				}
				else if(index == 1)
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("15");
						course.setText("Math");
					}
					else
					{
						myData = new DataPhp("16");
						course.setText("Cooking");
					}
				}
				else
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("17");
						course.setText("English");
					}
					else
					{
						myData = new DataPhp("18");
						course.setText("Literature");
					}
				}
				
				
			}
			else
			{				
				myData = new DataPhp("-1");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Adds information to grade
		 */
       //listOfGrade.add(newGrade(int id, String Course, String assignmentName, String Description, String dueDate))
       if(Tabs.username.equalsIgnoreCase("Joe"))
       {
    	   if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
    	   {
    		   listOfGrade.add(new Grade(myData.getGradesUserOneAssignmentOneIndexOne(), 
        			   myData.getGradesUserOneAssignmentOneName(),
        			   myData.getGradesUserOneAssignmentOneGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneAssignmentTwoIndexOne(), 
        			   myData.getGradesUserOneAssignmentTwoName(),
        			   myData.getGradesUserOneAssignmentTwoGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneAssignmentThreeIndexOne(), 
        			   myData.getGradesUserOneAssignmentThreeName(),
        			   myData.getGradesUserOneAssignmentThreeGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneAssignmentFourIndexOne(), 
        			   myData.getGradesUserOneAssignmentFourName(),
        			   myData.getGradesUserOneAssignmentFourGrade()));
    	   }
    	   else
    	   {
    		   
    		   listOfGrade.add(new Grade(myData.getGradesUserOneClassTwoAssignmentOneIndexOne(), 
        			   myData.getGradesUserOneClassTwoAssignmentOneName(),
        			   myData.getGradesUserOneClassTwoAssignmentOneGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneClassTwoAssignmentTwoIndexOne(), 
        			   myData.getGradesUserOneClassTwoAssignmentTwoName(),
        			   myData.getGradesUserOneClassTwoAssignmentTwoGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneClassTwoAssignmentThreeIndexOne(), 
        			   myData.getGradesUserOneClassTwoAssignmentThreeName(),
        			   myData.getGradesUserOneClassTwoAssignmentThreeGrade()));
        	   listOfGrade.add(new Grade(myData.getGradesUserOneClassTwoAssignmentFourIndexOne(), 
        			   myData.getGradesUserOneClassTwoAssignmentFourName(),
        			   myData.getGradesUserOneClassTwoAssignmentFourGrade())); 
        	   listOfGrade.add(new Grade(myData.getGradesUserOneClassTwoAssignmentFiveIndexOne(), 
        			   myData.getGradesUserOneClassTwoAssignmentFiveName(),
        			   myData.getGradesUserOneClassTwoAssignmentFiveGrade()));
    	   }
    	   
    	   
       }
       else
       {
    	   
    	   if(index == 0) // Mike is Clicked
    	   {
    		   if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
        	   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassOneAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentOneName(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassOneAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentTwoGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassOneAssignmentThreeIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentThreeName(),
        				   myData.getGradesUserTwoPositionOneClassOneAssignmentThreeGrade()));
        	   }
    		   else
    		   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassTwoAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentOneName(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassTwoAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentTwoGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassTwoAssignmentThreeIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentThreeName(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentThreeGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassTwoAssignmentFourIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentFourName(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentFourGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionOneClassTwoAssignmentFiveIndexOne(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentFiveName(),
        				   myData.getGradesUserTwoPositionOneClassTwoAssignmentFiveGrade()));
    		   }
    		  
    		   
    	   }
    	   else if(index == 1) // Sally
    	   {
    		   if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
        	   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassOneAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentOneName(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassOneAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentTwoGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassOneAssignmentThreeIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentThreeName(),
        				   myData.getGradesUserTwoPositionTwoClassOneAssignmentThreeGrade()));
        	   }
    		   else
    		   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassTwoAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentOneName(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassTwoAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentTwoGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassTwoAssignmentThreeIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentThreeName(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentThreeGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassTwoAssignmentFourIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentFourName(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentFourGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionTwoClassTwoAssignmentFiveIndexOne(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentFiveName(),
        				   myData.getGradesUserTwoPositionTwoClassTwoAssignmentFiveGrade()));
        		   
    		   }
    	   }
    	   else
    	   {
    		   if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
        	   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionThreeClassOneAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionThreeClassOneAssignmentOneName(),
        				   myData.getGradesUserTwoPositionThreeClassOneAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionThreeClassOneAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionThreeClassOneAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionThreeClassOneAssignmentTwoGrade()));
        		   
        	   }
    		   else
    		   {
    			   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionThreeClassTwoAssignmentOneIndexOne(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentOneName(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentOneGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionThreeClassTwoAssignmentTwoIndexOne(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentTwoName(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentTwoGrade()));
        		   listOfGrade.add(new Grade(myData.getGradesUserTwoPositionThreeClassTwoAssignmentThreeIndexOne(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentThreeName(),
        				   myData.getGradesUserTwoPositionThreeClassTwoAssignmentThreeGrade()));
    		   }
    	   }
       }
       GradeAdapter adapter = new GradeAdapter(this, listOfGrade);
        list.setAdapter(adapter);
	}
	
}
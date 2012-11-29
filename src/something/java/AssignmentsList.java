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
 * Assignment List 
 * stores a list of all assignments
 * Sends list to adapter to fill view
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class AssignmentsList extends Activity
{
	Intent intent;
	int id;
	List<Assignment> listOfAssignments;
	DataPhp myData;
	int index=0;
	/**
	 * Finds which data to retrieve
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_list);        
        ListView list = (ListView) findViewById(R.id.lvAssignments);
        list.setClickable(true);
        
       listOfAssignments = new ArrayList<Assignment>();
       
       index = Integer.parseInt(CourseTabs.student);
       try {
			if(Tabs.username.equalsIgnoreCase("Joe"))
			{	
				//System.out.println("Inside joe in assignlist");
				if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
				{
					myData = new DataPhp("19");	
				}
				else
				{
					myData = new DataPhp("20");
				}
					
							
			}
			else if(Tabs.username.equalsIgnoreCase("Tyrel"))
			{	
				
				if(index == 0)  
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("21");
					}
					else
					{
						myData = new DataPhp("22");
					}
				}
				else if(index == 1)
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("23");
					}
					else
					{
						myData = new DataPhp("24");
					}
				}
				else
				{
					if(CourseTabs.pos.equalsIgnoreCase(0+""))
					{
						myData = new DataPhp("25");
					}
					else
					{
						myData = new DataPhp("26");
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
		//Adds data to assignment list
		if(Tabs.username.equalsIgnoreCase("Joe"))
		{
			if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
			{
				listOfAssignments.add(new Assignment(myData.getAssignmentUserOnePositionOneClassOneAssignmentOneIndex(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentOneCourse(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentOneName(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentOneDescript(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentOneDate()));
				listOfAssignments.add(new Assignment(myData.getAssignmentUserOnePositionOneClassOneAssignmentTwoIndex(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentTwoCourse(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentTwoName(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentTwoDescript(),
						myData.getAssignmentUserOnePositionOneClassOneAssignmentTwoDate()));
			}
			else
			{
				listOfAssignments.add(new Assignment(myData.getAssignmentUserOnePositionOneClassTwoAssignmentOneIndex(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentOneCourse(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentOneName(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentOneDescript(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentOneDate()));
				listOfAssignments.add(new Assignment(myData.getAssignmentUserOnePositionOneClassTwoAssignmentTwoIndex(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentTwoCourse(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentTwoName(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentTwoDescript(),
						myData.getAssignmentUserOnePositionOneClassTwoAssignmentTwoDate()));
			}

		}
		else
		{
			if(index == 0) // Mike is Clicked
			{
				if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionOneClassOneAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentOneName(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentOneDate()));
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionOneClassOneAssignmentTwoIndex(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentTwoCourse(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentTwoName(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentTwoDescript(),
							myData.getAssignmentUserTwoPositionOneClassOneAssignmentTwoDate()));					
				}
				else
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionOneClassTwoAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentOneName(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentOneDate()));
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionOneClassTwoAssignmentTwoIndex(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentTwoCourse(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentTwoName(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentTwoDescript(),
							myData.getAssignmentUserTwoPositionOneClassTwoAssignmentTwoDate()));	
				}
			}
			else if(index == 1) // Sally
			{
				if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneName(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneDate()));
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionTwoClassOneAssignmentTwoIndex(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentTwoCourse(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentTwoName(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentTwoDescript(),
							myData.getAssignmentUserTwoPositionTwoClassOneAssignmentTwoDate()));	
				}
				else
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionTwoClassOneAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentOneName(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentOneDate()));
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoIndex(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoCourse(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoName(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoDescript(),
							myData.getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoDate()));	
				}
			
					

								
			}
			else
			{
				if(CourseTabs.pos.equalsIgnoreCase(0+"")) 
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneName(),
							myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneDate()));
					
				}
				else
				{
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionThreeClassOneAssignmentOneIndex(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentOneCourse(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentOneName(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentOneDescript(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentOneDate()));
					listOfAssignments.add(new Assignment(myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoIndex(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoCourse(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoName(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoDescript(),
							myData.getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoDate()));	
				}


			}
		
	}
       
       AssignmentAdapter adapter = new AssignmentAdapter(this, listOfAssignments);
        
        list.setOnItemClickListener(new OnItemClickListener() 
        {
         //   @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long index) 
            {
            	id = position;
            	callIntent(view);
            
            }
        });
        
        list.setAdapter(adapter);
	}
	/**
	 * Calls assignmentDescription intent on click
	 * @param view
	 */
	public void callIntent(View view) 
	{
		String course = listOfAssignments.get(id).getCourse();
		String assignment = listOfAssignments.get(id).getAssignmentName();
		String dueDate = listOfAssignments.get(id).getDueDate();
		String description = listOfAssignments.get(id).getDescription();
		intent = new Intent(this, AssignmentDescription.class);
		intent.putExtra("course", course);
		intent.putExtra("assignment", assignment);
		intent.putExtra("dueDate", dueDate);
		intent.putExtra("description", description);

		// Set the request code to any code you like, you can identify the
		// callback via this code
		startActivityForResult(intent, 10);
	
	}
}
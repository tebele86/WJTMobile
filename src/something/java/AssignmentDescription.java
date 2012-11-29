package something.java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * AssignmentDescription
 * Sets assignment description view up
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class AssignmentDescription extends Activity 
{
	String course;
	String assignment;
	String dueDate;
	String description;
	TextView tvCourse;
	TextView tvAssignment;
	TextView tvDueDate;
	TextView tvDescription;
	
	/**
	 * Sets assignment description xml views
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_description);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
        
        course = extras.getString("course");
        assignment = extras.getString("assignment");
        dueDate = extras.getString("dueDate");
        description = extras.getString("description");
        
        tvCourse = (TextView) findViewById(R.id.tvCourse);
        tvAssignment = (TextView) findViewById(R.id.tvAssignment);
        tvDueDate = (TextView) findViewById(R.id.tvDueDate);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        
        tvCourse.setText(course);
        tvAssignment.setText(assignment);
        tvDueDate.setText(dueDate);
        tvDescription.setText(description);
        
       
        
       

	}


}
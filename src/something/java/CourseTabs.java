package something.java;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
/**
 * CourseTabs
 * Tabs page for individual course
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class CourseTabs extends TabActivity 
{
	static String username;
	public static TabHost tabHost;
	static String pos;
	static String student;
	
	
    /**
     *  Called when the activity is first created. 
     *  Creates tabs and intents for the selected course
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			Log.w("CourseTabs", "Extras is null, bye bye!");
			return;
		}
        
		pos = extras.getString("savePos");
		student = extras.getString("stud");
		
		//System.out.println("stud is: " + student);
        Resources res = getResources(); // Resource object to get Drawables
        tabHost = getTabHost();  // The activity TabHost
        
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        
      
        //----------------------Grade intent ---------------------------//
        
        intent = new Intent().setClass(this, GradeList.class);
        spec = tabHost.newTabSpec("grade").setIndicator("Grades",
        		res.getDrawable(R.drawable.ic_tab_artists_grey))
                      .setContent(intent);        
        tabHost.addTab(spec);
       
        //----------------------Assignments intent ---------------------------//
        
        intent = new Intent().setClass(this, AssignmentsList.class);
        spec = tabHost.newTabSpec("assignments").setIndicator("Assignments",
        		res.getDrawable(R.drawable.ic_tab_artists_grey))
                      .setContent(intent);        
        tabHost.addTab(spec);
        
      //----------------------Home intent-------------------------------//
        intent = new Intent().setClass(this, ReturnHome.class);
        spec = tabHost.newTabSpec("home").setIndicator("Home",
                          res.getDrawable(R.drawable.house_outline))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        
        
        
        tabHost.setCurrentTab(0);  
    }
    //finish
    @Override
	public void finish() {
		Intent data = new Intent();
		setResult(RESULT_OK, data);
		super.finish();
	}

}

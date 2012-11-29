package something.java;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
/**
 * Tabs
 * Creates tabs for home screen
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class Tabs extends TabActivity 
{
	static String username;
	public static TabHost tabHost;
	int student;
	static GlobalState globalStudent;
	
    /** Called when the activity is first created. 
     * Sets up layout
     * */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
        username = extras.getString("user");
        Resources res = getResources(); // Resource object to get Drawables
        tabHost = getTabHost();  // The activity TabHost
        
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        
        //----------------------Home intent-------------------------------//
        intent = new Intent().setClass(this, Home.class);
        spec = tabHost.newTabSpec("home").setIndicator("Home",
                          res.getDrawable(R.drawable.house_outline))
                      .setContent(intent);
        tabHost.addTab(spec);
        //----------------------Attendance intent-------------------------------//
        intent = new Intent().setClass(this, AttendanceList.class);
        spec = tabHost.newTabSpec("attendance").setIndicator("Attendance",
                          res.getDrawable(R.drawable.ic_tab_artists_grey))
                      .setContent(intent);
        tabHost.addTab(spec);
        //----------------------Courses intent ---------------------------//
        
        intent = new Intent().setClass(this, CourseList.class);
        spec = tabHost.newTabSpec("courses").setIndicator("Courses",
                          res.getDrawable(R.drawable.book_outline))
                      .setContent(intent);        
        tabHost.addTab(spec);
        
        
        tabHost.setCurrentTab(0);  
    }
    // finish
    @Override
	public void finish() 
    {
		Intent data = new Intent();
		data.putExtra("returnUsername", username);
		setResult(RESULT_OK, data);
		super.finish();
	}
}

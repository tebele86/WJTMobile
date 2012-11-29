package something.java;

import android.app.Activity;
import android.os.Bundle;
/**
 * ReturnHome
 * returns user from CourseTabs to Tabs and the home page
 * displays loading screen briefly
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class ReturnHome extends Activity 
{
	/**
	 * Moves app to home page and restores original tabs
	 */
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        if(CourseTabs.tabHost.getCurrentTab() == 2)
		{
	        finish();
			Tabs.tabHost.setCurrentTab(0);
		}
	}
}

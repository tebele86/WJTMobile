package something.java;

//Help with setting up a Dynamic radio button control found at
// http://stackoverflow.com/questions/4669104/dynamic-radio-button-control

/**
 * Home
 * Set up main page after logging in
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Home
 * Creates home view
 * sets up list of students on account
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class Home extends Activity
{
	TextView welcomeView;
	String welcome;
	String intro;
	String user;
	Intent intent;
	int id;
	Tabs ta;
	WJTMobile sd;
	DataPhp myData;
	ListView list;
	Toast toast;
	RadioGroup rgStudent;
	// url to make request
	private static String url = "http://api.androidhive.info/contacts/";
	 
	// JSON Node names
	private static final String TAG_CONTACTS = "contacts";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_EMAIL = "email";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_GENDER = "gender";
	private static final String TAG_PHONE = "phone";
	private static final String TAG_PHONE_MOBILE = "mobile";
	private static final String TAG_PHONE_HOME = "home";
	private static final String TAG_PHONE_OFFICE = "office";
	String temp;
	 
	// contacts JSONArray
	JSONArray contacts = null;
	
	/**
	 * Sets up view
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        
     // Creating JSON Parser instance
        JSONParser jParser = new JSONParser();
         
        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url);
         
        try {
            // Getting Array of Contacts
            contacts = json.getJSONArray(TAG_CONTACTS);
         
            // looping through All Contacts
            for(int i = 0; i < contacts.length(); i++)
            {
                JSONObject c = contacts.getJSONObject(i);
         
                // Storing each json item in variable
                String id = c.getString(TAG_ID);
                String name = c.getString(TAG_NAME);
                String email = c.getString(TAG_EMAIL);
                String address = c.getString(TAG_ADDRESS);
                String gender = c.getString(TAG_GENDER);
         
                // Phone number is agin JSON Object
                JSONObject phone = c.getJSONObject(TAG_PHONE);
                String mobile = phone.getString(TAG_PHONE_MOBILE);
                String home = phone.getString(TAG_PHONE_HOME);
                String office = phone.getString(TAG_PHONE_OFFICE);
                temp = name;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        
        welcomeView = (TextView) findViewById(R.id.welcomeTV);
        
        welcome = "Welcome to WJT.Mobile";
        intro = "Please select which student to view. ";
        
        
        welcomeView.setText(Html.fromHtml("<h5>" + welcome + "  " + Tabs.username + " </h5> " 
       		+ "<h6>" + intro + "</h6>"));
        
         
        List<Student> listOfStudent = new ArrayList<Student>();
        
        listOfStudent.add(new Student(0,temp));
        //listOfStudent.add(new Student(myData.getUserOneIndex(),myData.getUserOneName()));
        //Gets data to fill list
        /*
        try {
			if(Tabs.username.equalsIgnoreCase("Joe"))
			{
				Log.w("SDPHONEAPP", "php sent is 1" );
				myData = new DataPhp("1");
			}
			else if(Tabs.username.equalsIgnoreCase("Tyrel"))
			{
				Log.w("SDPHONEAPP", "php sent is 2");
				myData = new DataPhp("2");
			}
			else
			{
				Log.w("SDPHONEAPP", "php sent is 3");
				myData = new DataPhp("-1");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
       if (myData == null) {
        	System.out.println("Error HME221.  Please contact your system admin.");
        }
        if(Tabs.username.equalsIgnoreCase("Joe"))
        {
        	listOfStudent.add(new Student(myData.getUserOneIndex(),myData.getUserOneName()));
        }
        else
        {
        	listOfStudent.add(new Student(myData.getUserTwoIndexPosOne() ,myData.getUserTwoNamePosOne()));
        	listOfStudent.add(new Student(myData.getUserTwoIndexPosTwo() ,myData.getUserTwoNamePosTwo()));
        	listOfStudent.add(new Student(myData.getUserTwoIndexPosThree() ,myData.getUserTwoNamePosThree()));
        }
        
        */
        
        
        createRadioButton(listOfStudent);
        getChecked();
        Tabs.globalStudent = (GlobalState) getApplication();
    	Tabs.globalStudent.setGlobalStudent(id+"");
        rgStudent.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
            	getChecked();
            	Tabs.globalStudent.setGlobalStudent(id+"");
            }
        });
 	}
	/**
	 * Creates dynamic radio buttons from listOfStudents
	 * sets buttons to position
	 * Sets button texts to student names
	 * @param listOfStudent
	 */
	private void createRadioButton(List<Student> listOfStudent) 
	{
	    RadioButton[] rb = new RadioButton[listOfStudent.size()];
	    rgStudent = new RadioGroup(this); //create the RadioGroup
	    rgStudent = (RadioGroup) findViewById(R.id.rgStudents);
	    rgStudent.setOrientation(RadioGroup.VERTICAL);
	    for(int i=0; i<listOfStudent.size(); i++)
	    {
	        rb[i]  = new RadioButton(this);
	        rgStudent.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout
	        rb[i].setText(listOfStudent.get(i).getStudent());
	        rb[i].setId(i);
	    }
	    rb[0].setChecked(true);
	}
	/**
	 * Gets position of checked radio button
	 * @return id
	 */
	public int getChecked()
	{
		id = rgStudent.getCheckedRadioButtonId();
        //toast = Toast.makeText(getApplicationContext(), "Checked is " + id, Toast.LENGTH_SHORT);
        //toast.show();
         return id;
	}	
 }
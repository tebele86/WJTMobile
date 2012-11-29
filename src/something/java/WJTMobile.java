package something.java;

/**
 * SDPhoneAppActivity
 * Creates and sets up log in page
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */

import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WJTMobile extends Activity
{
	Button submitButton;
	EditText username;
	EditText password;
	Context context;
	Intent intent;
	private Toast inputToast;
	String user;
	String pass;
	DataPhp myData;
	
	/**
	 * Sets up log in page view
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
       submitButton = (Button) findViewById(R.id.submitButton);
       username = (EditText) findViewById(R.id.usernameText);
       password = (EditText) findViewById(R.id.passwordText);
       intent = null;
       submitButton.setOnClickListener(new View.OnClickListener() 
       {
			//@Override
			public void onClick(View view) 
			{
					
				user = username.getText().toString();
				pass = password.getText().toString();
				if(user.equals("") || pass.equals(""))
                {
                	context = getApplicationContext();
                	inputToast = Toast.makeText(context, "Please fill all fields." , Toast.LENGTH_SHORT);
                	inputToast.show();
                	return;
                }
				else if(user.equalsIgnoreCase("Joe") || user.equalsIgnoreCase("Tyrel"))//Validate user
				{
					callIntent(view);
				}
				else
				{
					context = getApplicationContext();
					inputToast = Toast.makeText(context, "Username/Password does not match.", Toast.LENGTH_SHORT);
                	inputToast.show();
                	return;
				}
			}	
       });
	}
	/**
	 * Creates new intent to launch homepage and tabs
	 * @param view
	 */
	public void callIntent(View view) 
	{
		intent = new Intent(this, Tabs.class);
		intent.putExtra("user", user);
		// Set the request code to any code you like, you can identify the
		// callback via this code
		startActivityForResult(intent, 2);	
	}
	
	public void password(String url)
	{
		
	//	Authenticator.setDefault(new Authenticator(){
	//	    protected PasswordAuthentication getPasswordAuthentication() {
	//	        return new PasswordAuthentication("myuser","mypass".toCharArray());
	//	    }});
	//	HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
	//	c.setUseCaches(false);
		//c.connect();	
	
	}
	
	
	
	
	
	
	
	
	
}
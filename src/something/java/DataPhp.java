package something.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.util.Log;
/**
 * DataPhp
 * Requests data from website and allows classes
 * to access data
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
/*
 * DataPhp class sets up the read functionality by connecting to the webpage and then grabbing the approrpiate 
 * data that we need from the php file.  
 */
public class DataPhp 
{
	String reader = "";
	String master;
	//String[] masterArray = new String[27];
	
	
	// Our constructor, takes a string in so we can read the correct part of the php code.
	//DataPhp(String reader) throws IOException
	DataPhp(String reader) throws IOException
	{
		this.reader = (String) reader;
		//masterArray[0] = "Holder";
	
		//for(int i = 1; i <= 26; i++)
		//{
			BufferedReader in = null;
			try {
				HttpClient client = new DefaultHttpClient();
				client.getParams().setParameter("http.useragent","Test Client");

				//HttpPost method = new HttpPost("http://search.yahoo.com/search");
				//HttpPost method = new HttpPost("http://www.cs.uwyo.edu/~seker/");
				HttpPost method = new HttpPost("http://www.cs.uwyo.edu/~jbeckner/login.php");
				try {
					// Add your data
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					//nameValuePairs.add(new BasicNameValuePair("p", "\"java2s\""));
					//nameValuePairs.add(new BasicNameValuePair("user", "1"));
					//Log.w("DataPhp", "reader is "+reader);
					//String iString = i+"";
					nameValuePairs.add(new BasicNameValuePair("user", reader));
					method.setEntity(new UrlEncodedFormEntity(nameValuePairs));

					// Execute HTTP Post Request
					HttpResponse response = client.execute(method);
					//mkmsg("Webpage retreived, processing it.\n");

					//StatusLine status = response.getStatusLine();
					//mkmsg("Status is " + status.getStatusCode() + " " + status.getReasonPhrase()+"\n");

					in = new BufferedReader	(new InputStreamReader(response.getEntity().getContent()));

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}



				StringBuffer sb = new StringBuffer("");
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
				String page = sb.toString();
				master = page;
				//masterArray[i] = page;
				//mkmsg("Processed page:");
				//mkmsg(page);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		//}
		
	}
	
	// Called from constructor, puts our needed msg into the handler so we can set variable back in 
	// our activity. 
	/*public void mkmsg(String str) {
		//handler junk, because thread can't update screen!
		Message msg = new Message();
		Bundle b = new Bundle();
		b.putString("msg", str);
		msg.setData(b);
	    handler.sendMessage(msg);
    }
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			master = (msg.getData().getString("msg"));
		}

	};*/
	public int getIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	// grabs index of User One (Billy)
	public int getUserOneIndex()
	{
		return getIndex();
	}
	// grabs Billy of User One (Billy)
	public String getUserOneName()
	{	//System.out.println("HI!!!!!");	
		String[] tempArray;	
		tempArray = master.split(" ");
		Log.w("DataPhp", "tempArrar[1]" + tempArray[1]);
		return tempArray[1];		
	}
	
	// grabs index of user two, position one
	public int getUserTwoIndexPosOne()
	{
		return getIndex();
	}
	// grabs index of user two, position two
	public int getUserTwoIndexPosTwo()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[2]);	
		return x;
	}
	
	// grabs index of user two, position three
	public int getUserTwoIndexPosThree()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	// grabs user name of user two, position one
	public String getUserTwoNamePosOne()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	// grabs user name of user two, position two
	public String getUserTwoNamePosTwo()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// grabs user name of user two, position three
	public String getUserTwoNamePosThree()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5];
	}
	// Gets user one index for attendance
	public int getAttendanceUserOneIndex()
	{
		return getIndex();
	}
	// Gets user one class name for class one
	public String getAttendanceUserOneClassOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	// Gets user one tardies for class one
	public String getAttendanceUserOneClassOneTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2];
	}
	// Gets user one absences for class one
	public String getAttendanceUserOneClassOneAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	// Gets user one total days for class one
	public String getAttendanceUserOneClassOneDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4];
	}
	// Gets user one class two index
	public int getAttendanceUserOneClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Gets user one class two attendance
	public String getAttendanceUserOneClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	// Gets user one class two tardies
	public String getAttendanceUserOneClassTwoTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	// Gets user one class two absences
	public String getAttendanceUserOneClassTwoAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	// Gets user one class two total days
	public String getAttendanceUserOneClassTwoDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9];
	}
	
	// Grabs user 2, index 1
	public int getAttendanceUserTwoClassPositionOneClassOneIndex()
	{
		return getIndex();
	}
	
	// Grabs user 2, class 1, name (History)   first person
	public String getAttendanceUserTwoPositionOneClassOneName()
	{		
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, class 1, tardies (2)	first person
	public String getAttendanceUserTwoPositionOneClassOneTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2];
	}
	
	// Grabs user 2, class 1, absences	first person
	public String getAttendanceUserTwoPositionOneClassOneAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, class 1, total days	first person
	public String getAttendanceUserTwoPositionOneClassOneDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4];
	}
	
	// Grabs user 2, class 2, index	first person
	public int getAttendanceUserTwoPositionOneClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[5]);	
		return x;
	}
	
	// Grabs user 2, class 2, class name, first person
	public String getAttendanceUserTwoPositionOneClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, class 2, class tardies, first person
	public String getAttendanceUserTwoPositionOneClassTwoTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, class 2, class absences, first person
	public String getAttendanceUserTwoPositionOneClassTwoAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, class 2, tardies, first person
	public String getAttendanceUserTwoPositionOneClassTwoDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9];
	}
	
	// Grabs user 2, class 1, index, second person (start of Sally)
	public int getAttendanceUserTwoClassPositionTwoClassOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[10]);	
		return x;
	}
	
	// Grabs user 2, class 1, name (Math), second person
	public String getAttendanceUserTwoPositionTwoClassOneName()
	{		
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, class 1, tardies (2) , second person
	public String getAttendanceUserTwoPositionTwoClassOneTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// Grabs user 2, class 1, absences, second person
	public String getAttendanceUserTwoPositionTwoClassOneAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13];
	}
	
	// Grabs user 2, class 1, total days, second person
	public String getAttendanceUserTwoPositionTwoClassOneDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[14];
	}
	
	// Grabs user 2, class 2, index, second person
	public int getAttendanceUserTwoPositionTwoClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[15]);	
		return x;
	}
	
	// Grabs user 2, class 2, class name, second person
	public String getAttendanceUserTwoPositionTwoClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[16];
	}
	
	// Grabs user 2, class 2, class tardies,second person
	public String getAttendanceUserTwoPositionTwoClassTwoTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[17];
	}
	
	// Grabs user 2, class 2, class absences, second person
	public String getAttendanceUserTwoPositionTwoClassTwoAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[18];
	}
	
	// Grabs user 2, class 2, tardies, second person
	public String getAttendanceUserTwoPositionTwoClassTwoDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[19];
	}
	
	// -------- Start of John --------
	
	// Grabs user 2, class 1, index, third person
	public int getAttendanceUserTwoClassPositionThreeClassOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[20]);	
		return x;
	}
	
	// Grabs user 2, class 1, name (English), third person
	public String getAttendanceUserTwoPositionThreeClassOneName()
	{		
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[21];
	}
	
	// Grabs user 2, class 1, tardies (0) , third person
	public String getAttendanceUserTwoPositionThreeClassOneTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[22];
	}
	
	// Grabs user 2, class 1, absences, third person
	public String getAttendanceUserTwoPositionThreeClassOneAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[23];
	}
	
	// Grabs user 2, class 1, total days, third person
	public String getAttendanceUserTwoPositionThreeClassOneDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[24];
	}
	
	// Grabs user 2, class 2, index, third person
	public int getAttendanceUserTwoPositionThreeClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[25]);	
		return x;
	}
	
	// Grabs user 2, class 2, class name, third person
	public String getAttendanceUserTwoPositionThreeClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[26];
	}
	
	// Grabs user 2, class 2, class tardies,third person
	public String getAttendanceUserTwoPositionThreeClassTwoTardies()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[27];
	}
	
	// Grabs user 2, class 2, class absences, third person
	public String getAttendanceUserTwoPositionThreeClassTwoAbsence()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[28];
	}
	
	// Grabs user 2, class 2, tardies, third person
	public String getAttendanceUserTwoPositionThreeClassTwoDays()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[29];
	}
	
	//------- Courses --------
	
	// Grabs user 1, class 1, index
	public int getCoursesUserOneIndex()
	{
		return getIndex();
	}
	
	// Grabs user 1, class 1, name
	public String getCoursesUserOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 1, class 1, Professor
	public String getCoursesUserOneProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2];
		
	}
	
	// Grabs user 1, class 1, grade
	public String getCoursesUserOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 1, class 2, index
	public int getCoursesUserOneClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 1, class 2, name
	public String getCoursesUserOneClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5];
	}
	
	// Grabs user 1, class 2, professor
	public String getCoursesUserOneClassTwoProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 1, class 2, grade
	public String getCoursesUserOneClassTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// USER TWO COURSES  ------------------------
	
	// Grabs user 2, class 1, position 1, index    (MIKE)
	public int getCoursesUserTwoPositionOneClassOneIndex()
	{
		return getIndex();
	}
	
	// Grabs user 2, class 1, position one, course name
	public String getCoursesUserTwoPositionOneClassOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, class 1, position one, professor
	public String getCoursesUserTwoPositionOneClassOneProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2];
	}
	
	// Grabs user 2, class 1, position one, grade
	public String getCoursesUserTwoPositionOneClassOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, class 2, position 1, index
	public int getCoursesUserTwoPositionOneClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}

	// Grabs user 2, class 2, position 1, course name
	public String getCoursesUserTwoPositionOneClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5];
	}
	
	// Grabs user 2, class 2, position 1, professor
	public String getCoursesUserTwoPositionOneClassTwoProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, class 2, position 1, grade
	public String getCoursesUserTwoPositionOneClassTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	//  ------ Start Sally ------ 
	
	// Grabs user 2, class 1, position 2, index    (Sally)
	public int getCoursesUserTwoPositionTwoClassOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 2, class 1, position 2, course name
	public String getCoursesUserTwoPositionTwoClassOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9];
	}
	
	// Grabs user 2, class 1, position 2, professor
	public String getCoursesUserTwoPositionTwoClassOneProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[10];
	}
	
	// Grabs user 2, class 1, position 2, grade
	public String getCoursesUserTwoPositionTwoClassOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, class 2, position 2, index
	public int getCoursesUserTwoPositionTwoClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[12]);	
		return x;
	}

	// Grabs user 2, class 2, position 2, course name
	public String getCoursesUserTwoPositionTwoClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13];
	}
	
	// Grabs user 2, class 2, position 2, professor
	public String getCoursesUserTwoPositionTwoClassTwoProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[14];
	}
	
	// Grabs user 2, class 2, position 2, grade
	public String getCoursesUserTwoPositionTwoClassTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[15];
	}
	
//  ------ Start John ------ 
	
	// Grabs user 2, class 1, position 3, index    (John)
	public int getCoursesUserTwoPositionThreeClassOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[16]);	
		return x;
	}
	
	// Grabs user 2, class 1, position 3, course name
	public String getCoursesUserTwoPositionThreeClassOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[17];
	}
	
	// Grabs user 2, class 1, position 3, professor
	public String getCoursesUserTwoPositionThreeClassOneProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[18];
	}
	
	// Grabs user 2, class 1, position 3, grade
	public String getCoursesUserTwoPositionThreeClassOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[19];
	}
	
	// Grabs user 2, class 2, position 3, index
	public int getCoursesUserTwoPositionThreeClassTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[20]);	
		return x;
	}

	// Grabs user 2, class 2, position 3, course name
	public String getCoursesUserTwoPositionThreeClassTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[21];
	}
	
	// Grabs user 2, class 2, position 3, professor
	public String getCoursesUserTwoPositionThreeClassTwoProfessor()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[22];
	}
	
	// Grabs user 2, class 2, position 2, grade
	public String getCoursesUserTwoPositionThreeClassTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[23];
	}
	
	// ---- GRADES ------
	
	// Grabs user 1, class 1, assignment 1, index   (Billy -> Math)
	public int getGradesUserOneAssignmentOneIndexOne()
	{
		return getIndex();
	}
	
	// Grabs user 1, class 1, assignment 1, name 
	public String getGradesUserOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 1, class 1, assignment 1, grade
	public String getGradesUserOneAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 1, class 1, assignment 2, index   (Billy -> Math)
	public int getGradesUserOneAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 1, class 1, assignment 2, name 
	public String getGradesUserOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 1, class 1, assignment 2, grade
	public String getGradesUserOneAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 1, class 1, assignment 3, index   (Billy -> Math)
	public int getGradesUserOneAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 1, class 1, assignment 2, name 
	public String getGradesUserOneAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 1, class 1, assignment 2, grade
	public String getGradesUserOneAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 1, class 1, assignment 4, index   (Billy -> Math)
	public int getGradesUserOneAssignmentFourIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[12]);	
		return x;
	}
	
	// Grabs user 1, class 1, assignment 4, name 
	public String getGradesUserOneAssignmentFourName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13].concat(" ").concat(tempArray[14]);
	}
	
	// Grabs user 1, class 1, assignment 4, grade
	public String getGradesUserOneAssignmentFourGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[15];
	}
	
	
	// --- Billy -> English
	
	// Grabs user 1, class 2, assignment 1, index   (Billy -> English)
	public int getGradesUserOneClassTwoAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 1, class 2, assignment 1, name 
	public String getGradesUserOneClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 1, class 2, assignment 1, grade
	public String getGradesUserOneClassTwoAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 1, class 2, assignment 2, index   (Billy -> English)
	public int getGradesUserOneClassTwoAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 1, class 2, assignment 2, name 
	public String getGradesUserOneClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 1, class 2, assignment 2, grade
	public String getGradesUserOneClassTwoAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 1, class 2, assignment 3, index   (Billy -> English)
	public int getGradesUserOneClassTwoAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 1, class 2, assignment 3, name 
	public String getGradesUserOneClassTwoAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 1, class 2, assignment 3, grade
	public String getGradesUserOneClassTwoAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 1, class 2, assignment 4, index   (Billy -> English)
	public int getGradesUserOneClassTwoAssignmentFourIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[12]);	
		return x;
	}
	
	// Grabs user 1, class 2, assignment 4, name 
	public String getGradesUserOneClassTwoAssignmentFourName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13].concat(" ").concat(tempArray[14]);
	}
	
	// Grabs user 1, class 2, assignment 4, grade
	public String getGradesUserOneClassTwoAssignmentFourGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[15];
	}
	
	// Grabs user 1, class 2, assignment 5, index   (Billy -> English)
	public int getGradesUserOneClassTwoAssignmentFiveIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[16]);	
		return x;
	}
	
	// Grabs user 1, class 2, assignment 5, name 
	public String getGradesUserOneClassTwoAssignmentFiveName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[17].concat(" ").concat(tempArray[18]);
	}
	
	// Grabs user 1, class 2, assignment 5, grade
	public String getGradesUserOneClassTwoAssignmentFiveGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[19];
	}
	
	
	// ----- GRADES USER TWO ----------
	
	// Grabs user 2, position 1, class 1, assignment 1, index (Mike -> History)
	public int getGradesUserTwoPositionOneClassOneAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, name 
	public String getGradesUserTwoPositionOneClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, grade
	public String getGradesUserTwoPositionOneClassOneAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 1, class 1, assignment 2, index (Mike -> History)
	public int getGradesUserTwoPositionOneClassOneAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, name 
	public String getGradesUserTwoPositionOneClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, grade
	public String getGradesUserTwoPositionOneClassOneAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 1, class 1, assignment 3, index (Mike -> History)
	public int getGradesUserTwoPositionOneClassOneAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 1, assignment 3, name 
	public String getGradesUserTwoPositionOneClassOneAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 3, grade
	public String getGradesUserTwoPositionOneClassOneAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Mike -> Calculus
	// Grabs user 2, position 1, class 2, assignment 1, index (Mike -> Calc)
	public int getGradesUserTwoPositionOneClassTwoAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 1, name 
	public String getGradesUserTwoPositionOneClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 1, grade
	public String getGradesUserTwoPositionOneClassTwoAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, index (Mike -> Calc)
	public int getGradesUserTwoPositionOneClassTwoAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, name 
	public String getGradesUserTwoPositionOneClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, grade
	public String getGradesUserTwoPositionOneClassTwoAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 1, class 2, assignment 3, index (Mike -> Calc)
	public int getGradesUserTwoPositionOneClassTwoAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 3, name 
	public String getGradesUserTwoPositionOneClassTwoAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 3, grade
	public String getGradesUserTwoPositionOneClassTwoAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 1, class 2, assignment 4, index (Mike -> Calc)
	public int getGradesUserTwoPositionOneClassTwoAssignmentFourIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[12]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 4, name 
	public String getGradesUserTwoPositionOneClassTwoAssignmentFourName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13].concat(" ").concat(tempArray[14]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 4, grade
	public String getGradesUserTwoPositionOneClassTwoAssignmentFourGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[15];
	}
	
	// Grabs user 2, position 1, class 2, assignment 5, index (Mike -> Calc)
	public int getGradesUserTwoPositionOneClassTwoAssignmentFiveIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[16]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 5, name 
	public String getGradesUserTwoPositionOneClassTwoAssignmentFiveName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[17].concat(" ").concat(tempArray[18]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 5, grade
	public String getGradesUserTwoPositionOneClassTwoAssignmentFiveGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[19];
	}
	
	// Grades -> user 2 -> Sally
	// Grabs user 2, position 2, class 1, assignment 1, index (Sally -> Math)
	public int getGradesUserTwoPositionTwoClassOneAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, name 
	public String getGradesUserTwoPositionTwoClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, grade
	public String getGradesUserTwoPositionTwoClassOneAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, index (Sally -> Math)
	public int getGradesUserTwoPositionTwoClassOneAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, name 
	public String getGradesUserTwoPositionTwoClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, grade
	public String getGradesUserTwoPositionTwoClassOneAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 2, class 1, assignment 3, index (Sally -> Math)
	public int getGradesUserTwoPositionTwoClassOneAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 1, assignment 3, name 
	public String getGradesUserTwoPositionTwoClassOneAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 3, grade
	public String getGradesUserTwoPositionTwoClassOneAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, index (Sally -> Cooking)
	public int getGradesUserTwoPositionTwoClassTwoAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[12]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, name 
	public String getGradesUserTwoPositionTwoClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[13].concat(" ").concat(tempArray[14]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, grade
	public String getGradesUserTwoPositionTwoClassTwoAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[15];
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, index (Sally -> Cooking)
	public int getGradesUserTwoPositionTwoClassTwoAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[16]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, name 
	public String getGradesUserTwoPositionTwoClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[17].concat(" ").concat(tempArray[18]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, grade
	public String getGradesUserTwoPositionTwoClassTwoAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[19];
	}
	
	// Grabs user 2, position 2, class 2, assignment 3, index (Sally -> Cooking)
	public int getGradesUserTwoPositionTwoClassTwoAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 3, name 
	public String getGradesUserTwoPositionTwoClassTwoAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 3, grade
	public String getGradesUserTwoPositionTwoClassTwoAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 2, class 2, assignment 4, index (Sally -> Cooking)
	public int getGradesUserTwoPositionTwoClassTwoAssignmentFourIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 4, name 
	public String getGradesUserTwoPositionTwoClassTwoAssignmentFourName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 4, grade
	public String getGradesUserTwoPositionTwoClassTwoAssignmentFourGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 2, class 2, assignment 5, index (Sally -> Cooking)
	public int getGradesUserTwoPositionTwoClassTwoAssignmentFiveIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 5, name 
	public String getGradesUserTwoPositionTwoClassTwoAssignmentFiveName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 5, grade
	public String getGradesUserTwoPositionTwoClassTwoAssignmentFiveGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// User 2, John
	
	// Grabs user 2, position 3, class 1, assignment 1, index (John -> English)
	public int getGradesUserTwoPositionThreeClassOneAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 5, name 
	public String getGradesUserTwoPositionThreeClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 5, grade
	public String getGradesUserTwoPositionThreeClassOneAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 3, class 1, assignment 2, index (John -> English)
	public int getGradesUserTwoPositionThreeClassOneAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, name 
	public String getGradesUserTwoPositionThreeClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, grade
	public String getGradesUserTwoPositionThreeClassOneAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 3, class 2, assignment 1, index (John -> Literature)
	public int getGradesUserTwoPositionThreeClassTwoAssignmentOneIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, name 
	public String getGradesUserTwoPositionThreeClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1].concat(" ").concat(tempArray[2]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, grade
	public String getGradesUserTwoPositionThreeClassTwoAssignmentOneGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[3];
	}
	
	// Grabs user 2, position 3, class 2, assignment 2, index (John -> Literature)
	public int getGradesUserTwoPositionThreeClassTwoAssignmentTwoIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[4]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, name 
	public String getGradesUserTwoPositionThreeClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[5].concat(" ").concat(tempArray[6]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, grade
	public String getGradesUserTwoPositionThreeClassTwoAssignmentTwoGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[7];
	}
	
	// Grabs user 2, position 3, class 2, assignment 3, index (John -> Literature)
	public int getGradesUserTwoPositionThreeClassTwoAssignmentThreeIndexOne()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[8]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 3, name 
	public String getGradesUserTwoPositionThreeClassTwoAssignmentThreeName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 3, grade
	public String getGradesUserTwoPositionThreeClassTwoAssignmentThreeGrade()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// -----------------  Assignments ----------------
	
	// Grabs user 1, position 1, class 1, assignment 1, index
	public int getAssignmentUserOnePositionOneClassOneAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, course name
	public String getAssignmentUserOnePositionOneClassOneAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, assignment
	public String getAssignmentUserOnePositionOneClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, description
	public String getAssignmentUserOnePositionOneClassOneAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, date
	public String getAssignmentUserOnePositionOneClassOneAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, index  (Billy -> Math)
	public int getAssignmentUserOnePositionOneClassOneAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, course name
	public String getAssignmentUserOnePositionOneClassOneAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, assignment
	public String getAssignmentUserOnePositionOneClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, description
	public String getAssignmentUserOnePositionOneClassOneAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 1, position 1, class 1, assignment 2, date
	public String getAssignmentUserOnePositionOneClassOneAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// Grabs user 1, position 1, class 2, assignment 1, index ( Billy English)
	public int getAssignmentUserOnePositionOneClassTwoAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 1, position 1, class 2, assignment 1, course
	public String getAssignmentUserOnePositionOneClassTwoAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 1, position 1, class 2, assignment 1, assignment
	public String getAssignmentUserOnePositionOneClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, description
	public String getAssignmentUserOnePositionOneClassTwoAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 1, position 1, class 1, assignment 1, date
	public String getAssignmentUserOnePositionOneClassTwoAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 1, position 1, class 2, assignment 2, index
	public int getAssignmentUserOnePositionOneClassTwoAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 1, position 1, class 2, assignment 2, course
	public String getAssignmentUserOnePositionOneClassTwoAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 1, position 1, class 2, assignment 2, assignment
	public String getAssignmentUserOnePositionOneClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 1, position 1, class 2, assignment 2, description
	public String getAssignmentUserOnePositionOneClassTwoAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 1, position 1, class 2, assignment 2, date
	public String getAssignmentUserOnePositionOneClassTwoAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// USer two, mike -> History
	
	// Grabs user 2, position 1, class 1, assignment 1, index ( Mike -> History)
	public int getAssignmentUserTwoPositionOneClassOneAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, course
	public String getAssignmentUserTwoPositionOneClassOneAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, assignment
	public String getAssignmentUserTwoPositionOneClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, description
	public String getAssignmentUserTwoPositionOneClassOneAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, date
	public String getAssignmentUserTwoPositionOneClassOneAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, index
	public int getAssignmentUserTwoPositionOneClassOneAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 2, position 1, class 2, assignment 2, course
	public String getAssignmentUserTwoPositionOneClassOneAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, assignment
	public String getAssignmentUserTwoPositionOneClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, description
	public String getAssignmentUserTwoPositionOneClassOneAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, date
	public String getAssignmentUserTwoPositionOneClassOneAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// Mike class 2
	
	// Grabs user 2, position 1, class 2, assignment 1 index
	public int getAssignmentUserTwoPositionOneClassTwoAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 1, class 2, assignment 1, course
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 1, class 2, assignment 1, assignment
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, description
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 1, class 1, assignment 1, date
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, index
	public int getAssignmentUserTwoPositionOneClassTwoAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 2, position 1, class 2, assignment 2, course
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, assignment
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, description
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 1, class 2, assignment 2, date
	public String getAssignmentUserTwoPositionOneClassTwoAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// Sally class 1
	
	
	// Grabs user 2, position 2, class 1, assignment 1 index
	public int getAssignmentUserTwoPositionTwoClassOneAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, course
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, assignment
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, description
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 1, date
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, index
	public int getAssignmentUserTwoPositionTwoClassOneAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 2, position 2, class 1, assignment 2, course
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, assignment
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, description
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 2, class 1, assignment 2, date
	public String getAssignmentUserTwoPositionTwoClassOneAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// Sally class 2
	// Grabs user 2, position 2, class 2, assignment 1 index
	public int getAssignmentUserTwoPositionTwoClassTwoAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, course
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, assignment
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, description
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 1, date
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, index
	public int getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 2, position 2, class 2, assignment 2, course
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, assignment
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, description
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 2, class 2, assignment 2, date
	public String getAssignmentUserTwoPositionTwoClassTwoAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
	
	// John class 1
	
	// Grabs user 2, position 3, class 1, assignment 1 index
	public int getAssignmentUserTwoPositionThreeClassOneAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 3, class 1, assignment 1, course
	public String getAssignmentUserTwoPositionThreeClassOneAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 3, class 1, assignment 1, assignment
	public String getAssignmentUserTwoPositionThreeClassOneAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 3, class 1, assignment 1, description
	public String getAssignmentUserTwoPositionThreeClassOneAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 3, class 1, assignment 1, date
	public String getAssignmentUserTwoPositionThreeClassOneAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// John class 2
	
	// Grabs user 2, position 3, class 2, assignment 1 index
	public int getAssignmentUserTwoPositionThreeClassTwoAssignmentOneIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[0]);	
		return x;
	}
	
	// Grabs user 2, position 3, class 2, assignment 1, course
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentOneCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[1];
	}
	
	// Grabs user 2, position 3, class 2, assignment 1, assignment
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentOneName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[2].concat(" ").concat(tempArray[3]);
	}
	
	// Grabs user 2, position 3, class 2, assignment 1, description
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentOneDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[4].concat(" ").concat(tempArray[5]);
	}
	
	// Grabs user 2, position 3, class 2, assignment 1, date
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentOneDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[6];
	}
	
	// Grabs user 2, position 3, class 2, assignment 2, index
	public int getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoIndex()
	{
		int x=0;
		String[] tempArray;	
		tempArray = master.split(" ");
		x = Integer.parseInt(tempArray[7]);	
		return x;
	}
	// Grabs user 2, position 3, class 2, assignment 2, course
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoCourse()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[8];
	}
	
	// Grabs user 2, position 3, class 2, assignment 2, assignment
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoName()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[9].concat(" ").concat(tempArray[10]);
	}
	
	// Grabs user 2, position 3, class 2, assignment 2, description
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoDescript()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[11];
	}
	
	// Grabs user 2, position 3, class 2, assignment 2, date
	public String getAssignmentUserTwoPositionThreeClassTwoAssignmentTwoDate()
	{
		String[] tempArray;	
		tempArray = master.split(" ");
		return tempArray[12];
	}
}
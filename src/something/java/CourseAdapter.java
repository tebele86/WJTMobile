package something.java;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/*
 * From http://code.google.com/p/myandroidwidgets/source/browse/trunk/Phonebook/src/com/abeanie/PhonebookAdapter.java
 * description found at http://techdroid.kbeanie.com/2009/07/custom-listview-for-android.html
 */
/**
 * CourseAdapter
 * Adapts courselist to fill view, merges two views
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class CourseAdapter extends BaseAdapter //implements OnClickListener 
{
    private Context context;
    Toast test;
    Integer id;
    List<Course> courseList;
    
//Class constructor
    public CourseAdapter(Context context, List<Course> courseList) 
    {
        this.context = context;
        this.courseList = courseList;

    }
    //Gets count
    public int getCount() {
        return courseList.size();
    }
    //Gets item
    public Object getItem(int position) {
        return courseList.get(position);
    }
    //gets item id
    public long getItemId(int position) {
        return position;
    }
    //Gets view inflates view with items from course list
    public View getView(int position, View convertView, ViewGroup viewGroup) 
    {
        Course course = courseList.get(position);
        if (convertView == null) 
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.course_row, null);
        }
        TextView tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
        tvCourse.setText(course.getCourse());

        TextView tvProfessor = (TextView) convertView.findViewById(R.id.tvProfName);
        tvProfessor.setText(course.getProf());

        TextView tvGrade = (TextView) convertView.findViewById(R.id.tvGrade);
        tvGrade.setText(course.getGrade());

        id = course.getId();
        notifyDataSetChanged();
        return convertView;
    }
   
    //Adds element
    public void addElement(Course course)
    {
    	courseList.add(course);
    	notifyDataSetChanged();
    	
    }
    //Edits element
    public void editElement(Course course)
    {
    	courseList.remove(course);
    	courseList.add(course);
    }

}
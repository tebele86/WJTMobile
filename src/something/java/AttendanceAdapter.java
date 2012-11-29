package something.java;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
/**
 * AttendanceAdapter
 * Fills view with attendance entries from list
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class AttendanceAdapter extends BaseAdapter //implements OnClickListener 
{
    private Context context;
    Toast test;
    Integer id;
    List<Attendance> attendanceList;
    
//Class constructor
    public AttendanceAdapter(Context context, List<Attendance> attendanceList) 
    {
        this.context = context;
        this.attendanceList = attendanceList;

    }
    //Gets count
    public int getCount() {
        return attendanceList.size();
    }
    //Gets item
    public Object getItem(int position) {
        return attendanceList.get(position);
    }
    //gets item id
    public long getItemId(int position) {
        return position;
    }
    //Gets view inflates view to include item list
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Attendance attendance = attendanceList.get(position);
        if (convertView == null) 
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.attendance_row, null);
        }
        TextView tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
        tvCourse.setText(attendance.getCourse());
        
        TextView tvTardy = (TextView) convertView.findViewById(R.id.tvTardy);
        if (tvTardy == null) {
        	Log.w("AttendenceAdapter", "Help me, I've falling and can't get up");
        }
        if (attendance.getTardy() == null) {
        	Log.w("AttendenceAdapter", "Help me, tardy is null");
        }
        tvTardy.setText(attendance.getTardy());

        TextView tvAbsent = (TextView) convertView.findViewById(R.id.tvAbsent);
        tvAbsent.setText(attendance.getAbsent());

        TextView tvTotalDays = (TextView) convertView.findViewById(R.id.tvTotalDays);
        tvTotalDays.setText(attendance.getTotalDays());

        id = attendance.getId();
        notifyDataSetChanged();
        return convertView;
    }
   
    //Adds element
    public void addElement(Attendance attendance)
    {
    	attendanceList.add(attendance);
    	notifyDataSetChanged();
    	
    }
    //Edits element
    public void editElement(Attendance attendance)
    {
    	attendanceList.remove(attendance);
    	attendanceList.add(attendance);
    }

}
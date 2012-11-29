package something.java;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Assignment Adapter
 * Inflates view for assignments, merges two views
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class AssignmentAdapter extends BaseAdapter 
{
private Context context;
Toast test;
Integer id;
List<Assignment> assignmentList;

//Class constructor
public AssignmentAdapter(Context context, List<Assignment> assignmentList) 
{
    this.context = context;
    this.assignmentList = assignmentList;

}
//Gets count
public int getCount() {
    return assignmentList.size();
}
//Gets item
public Object getItem(int position) {
    return assignmentList.get(position);
}
//gets item id
public long getItemId(int position) {
    return position;
}
//Gets view and adds items from list to view
public View getView(int position, View convertView, ViewGroup viewGroup) 
{
    Assignment assignment = assignmentList.get(position);
    
    if (convertView == null) 
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.assignment_row, null);
    }
    TextView tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
    tvCourse.setText(assignment.getCourse());

    TextView tvAssignment = (TextView) convertView.findViewById(R.id.tvAssignment);
    tvAssignment.setText(assignment.getAssignmentName());
    
    TextView tvDueDate = (TextView) convertView.findViewById(R.id.tvDueDate);
    tvDueDate.setText(assignment.getDueDate());

    id = assignment.getId();
    notifyDataSetChanged();
    return convertView;
}

//Adds element
public void addElement(Assignment assignment)
{
	assignmentList.add(assignment);
	notifyDataSetChanged();
	
}
//Edits element
public void editElement(Assignment assignment)
{
	assignmentList.remove(assignment);
	assignmentList.add(assignment);
}

}
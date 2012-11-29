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
 * GradeAdapter
 * inflates view to have an entry per list item
 * @author Joseph Beckner and Tyrel Ebele
 * @date 4/15/2012
 *
 */
public class GradeAdapter extends BaseAdapter //implements OnClickListener 
{
    private Context context;
    Toast test;
    Integer id;
    List<Grade> gradeList;
    
//Class constructor
    public GradeAdapter(Context context, List<Grade> gradeList) 
    {
        this.context = context;
        this.gradeList = gradeList;

    }
    //Gets count
    public int getCount() {
        return gradeList.size();
    }
    //Gets item
    public Object getItem(int position) {
        return gradeList.get(position);
    }
    //gets item id
    public long getItemId(int position) {
        return position;
    }
    //Gets view inflates view for each grade entry
    public View getView(int position, View convertView, ViewGroup viewGroup) 
    {
        Grade grade = gradeList.get(position);
    	
        
        if (convertView == null) 
        {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grade_row, null);
        }
        TextView tvAssignment = (TextView) convertView.findViewById(R.id.tvAssignment);
        tvAssignment.setText(grade.getAssignment());

        TextView tvGrade = (TextView) convertView.findViewById(R.id.tvGrade);
        tvGrade.setText(grade.getGrade());

        id = grade.getId();
        notifyDataSetChanged();
        return convertView;
    }
   
    //Adds element
    public void addElement(Grade grade)
    {
    	gradeList.add(grade);
    	notifyDataSetChanged();
    	
    }
    //Edits element
    public void editElement(Grade grade)
    {
    	gradeList.remove(grade);
    	gradeList.add(grade);
    }

}
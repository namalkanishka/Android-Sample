package lakna.sllit.com.tabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentListAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Student> items; //data source of the list adapter

    //public constructor
    public StudentListAdapter(Context context, ArrayList<Student> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_list_row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student currentItem = (Student) getItem(position);
        viewHolder.itemName.setText(currentItem.getStdName());
        viewHolder.itemDescription.setText(currentItem.getDescription());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView itemName;
        TextView itemDescription;

        public ViewHolder(View view) {
            itemName = (TextView)view.findViewById(R.id.text_view_item_name);
            itemDescription = (TextView) view.findViewById(R.id.text_view_item_description);
        }
    }
}
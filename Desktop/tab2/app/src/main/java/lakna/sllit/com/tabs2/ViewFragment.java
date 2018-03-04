package lakna.sllit.com.tabs2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    @BindView(R.id.list_view_items)
    ListView listViewItems;
    Unbinder unbinder;

    private HashMap<String, Student> sMap = new HashMap<>();
    private ArrayList<Student> sArray = new ArrayList<>();

    public ViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sArray = (ArrayList<Student>) getArguments().getSerializable("students array list");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        unbinder = ButterKnife.bind(this, view);
        ListView itemsListView = (ListView) view.findViewById(R.id.list_view_items);

        //create adapter object
        StudentListAdapter adapter = new StudentListAdapter(getActivity(), sArray);

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package lakna.sllit.com.tabs2;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddFragment.onAddStudentListener {

    private ArrayList<Student> stdArray = new ArrayList<>();
    private int studentCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AddFragment(), "Add");
        adapter.addFragment(new UpdateFragment(), "Update");

        Bundle bundle = new Bundle();
        bundle.putSerializable("students array list", stdArray);

        //set view fragment  Arguments(students hash map object )
        ViewFragment viewStudents = new ViewFragment();
        viewStudents.setArguments(bundle);

        adapter.addFragment(viewStudents, "View");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void onAddStudent(Student student) {
        stdArray.add(studentCount, student);
        studentCount = studentCount + 1;

        //update the tabs when press save button
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AddFragment(), "Add");

        Bundle bundle = new Bundle();
        bundle.putSerializable("students array list", stdArray);

        //set view fragment  Arguments(students hash map object )
        UpdateFragment updateStudents = new UpdateFragment();
        updateStudents.setArguments(bundle);

        adapter.addFragment(updateStudents, "Update");



        //set view fragment  Arguments(students hash map object )
        ViewFragment viewStudents = new ViewFragment();
        viewStudents.setArguments(bundle);

        adapter.addFragment(viewStudents, "View");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

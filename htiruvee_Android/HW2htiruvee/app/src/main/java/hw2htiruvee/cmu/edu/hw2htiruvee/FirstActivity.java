package hw2htiruvee.cmu.edu.hw2htiruvee;

/**
 * Created by haripriya on 6/1/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FirstActivity extends AppCompatActivity
    implements Title1.OnFragmentInteractionListener,
    Title2.OnFragmentInteractionListener ,
    Title3.OnFragmentInteractionListener {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    public void onFragmentInteraction(Uri uri) {
    //currently do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
      
    }

    /**
     * onOptionsItemSelected method
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    /**
     * onOptionsItemSelected method
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id==R.id.addEventItem) {
            Intent listEvent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(listEvent);

            return true;}
        return super.onOptionsItemSelected(item);
    }

    
  

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /*// getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);*/
            switch (position) {
                case 0:
                    return new Title1();
                case 1:
                    return new Title2();
                case 2:
                    return new Title3();
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title1);
                case 1:
                    return getString(R.string.title2);
                case 2:
                    return getString(R.string.title3);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_title1, container, false);

            TextView textView1 = (TextView) rootView.findViewById(R.id.textView);
            textView1.setGravity(Gravity.RIGHT);
            textView1.setText(getString(R.string.andrew_id));

            TextView textView2 = (TextView) rootView.findViewById(R.id.textView2);
            textView2.setText(getString(R.string.andrew_id_value));
            textView2.setGravity(Gravity.RIGHT);

            TextView textView3 = (TextView) rootView.findViewById(R.id.textView3);
            textView3.setText(getString(R.string.current_time));

            TextView textView4 = (TextView) rootView.findViewById(R.id.textView4);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
            sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            String currentDateTimeString = sdf.format(new Date());
            textView4.setText(currentDateTimeString);

            TextView textView5 = (TextView) rootView.findViewById(R.id.textView5);
            textView5.setGravity(Gravity.RIGHT);
            textView5.setText(getString(R.string.your_device));

            TextView textView6 = (TextView) rootView.findViewById(R.id.textView6);
            textView6.setText(" Version"+ Build.VERSION.RELEASE + ":API Level"+Build.VERSION.SDK_INT);
            return rootView;
        }
    }
}

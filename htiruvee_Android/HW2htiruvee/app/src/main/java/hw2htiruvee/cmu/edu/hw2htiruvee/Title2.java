package hw2htiruvee.cmu.edu.hw2htiruvee;

/**
 * Created by haripriya on 6/1/2017.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Title2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Title2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Title2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListView mListView;
    private ArrayAdapter mAdapter;
    private static ArrayList<String> eventList = new ArrayList();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Title2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Title2.
     */
    // TODO: Rename and change types and number of parameters
    public static Title2 newInstance(String param1, String param2) {
        Title2 fragment = new Title2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * event list
     */
    static {
        eventList.add(0, "Kick-Off Rallye \n" +
                "Sunday, July 2" + " at TBD");
        eventList.add(1, "Blacktie & Tailpipes Gala \n" +
                "Friday, July 7" + " at TBD");
        eventList.add(2, "Historics at Pitt Race\n" +
                "Weekend, July 7-9" + " at Pittsburgh International Race Complex");
        eventList.add(3, "Walnut Street Car Show \n" +
                "Monday, July 10" + " at Walnut Street");
        eventList.add(4, "Waterfront Car Cruise \n" +
                "Tuesday, July 11" + " at Waterfront");
        eventList.add(5, "Downtown Parade & Car Display\n" +
                "Wednesday, July 12" + " at Downtown");
        eventList.add(6, "Tune-Up Party @ Atria's\n" +
                "Wednesday, July 12" + " at Downtown");
        eventList.add(7, "Countryside Tour\n" +
                "Thursday, July 13" + " at TBD");
        eventList.add(8, "Forbes Ave of Speed Race Car Parade\n" +
                "Thursday, July 14" + " at Forbes Avenue at Squirell Hill");


    }

    /**
     * On create method
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, eventList);
    }

    /**
     * OnCreate view method
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title2, container, false);
        //set the Adapter
        mListView = (ListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);
        for(String log : eventList)
        {
            Log.v("Tag",log);
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * onAttach method
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * Ondetach method
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

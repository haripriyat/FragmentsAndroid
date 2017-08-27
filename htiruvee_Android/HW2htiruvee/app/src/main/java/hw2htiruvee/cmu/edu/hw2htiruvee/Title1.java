package hw2htiruvee.cmu.edu.hw2htiruvee;

/**
 * Created by haripriya on 6/1/2017.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Title1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Title1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Title1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Title1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Title1.
     */
    // TODO: Rename and change types and number of parameters
    public static Title1 newInstance(String param1, String param2) {
        Title1 fragment = new Title1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        Log.i("["+currentDateTimeString+"]"," Version"+ Build.VERSION.RELEASE + ":API Level"+Build.VERSION.SDK_INT);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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

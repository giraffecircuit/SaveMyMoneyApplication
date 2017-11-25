package com.example.admin.savemymoneyapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabSaving.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabSaving#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabSaving extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Defining android ListView
    ListView mListView;

    //Elements that will be displayed in android ListView
    String[] Countries = new String[]{"India", "Australia", "Newzealand",
            "Indonesia", "China", "Russia", "Japan", "South Korea"};


    public TabSaving() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabSaving.
     */
    // TODO: Rename and change types and number of parameters
    public static TabSaving newInstance(String param1, String param2) {
        TabSaving fragment = new TabSaving();
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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tab_saving, container, false);

        View rootView = inflater.inflate(R.layout.fragment_tab_saving, container, false);
        final ListView listview =(ListView)rootView .findViewById(R.id.lstSavingView);
        String[] items = new String[] {"Banks & FD","Mutual Fund", "Indian Postal Service","Soverign Gold Bond", "Goverment Bonds",""};
        ArrayList myList = new ArrayList();
        /*ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);*/
        for (int i = 0; i < items.length; i++)
        {
            myList.add(items[i].toString());
        }
        CustomAdapter customAdapter=new CustomAdapter(getContext(),myList);
        /*listview.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Toast toast = Toast.makeText(arg0.getContext(),"dfsfsfsdf",Toast.LENGTH_LONG);

            }
        });*/
        listview.setAdapter(customAdapter);

        /*ListView lv = getListView();
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId)
            {
                Intent launchActivity = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(launchActivity);
            }
        });*/

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

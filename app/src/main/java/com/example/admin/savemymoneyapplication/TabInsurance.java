package com.example.admin.savemymoneyapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class TabInsurance extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public TabInsurance() {
    }

    public static TabInsurance newInstance(String param1, String param2) {
        TabInsurance fragment = new TabInsurance();
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
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_tab_insurance, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.listViewExpInsurance);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
        return rootView;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Saving Insurance");
        listDataHeader.add("Term Insurance");
        listDataHeader.add("Health Insurance");
        listDataHeader.add("Travel Insurance");
        listDataHeader.add("General Insurance");
        listDataHeader.add("Vehicle Insurance");

        // Adding child data
        List<String> savingAndInsurance= new ArrayList<String>();
        savingAndInsurance.add("United Link Insurance Plan - ULIP");
        savingAndInsurance.add("Family Protection Plan");
        savingAndInsurance.add("Education Plan");
        savingAndInsurance.add("Retirement Plan");
        savingAndInsurance.add("Future Plan");

        // Adding child data
        List<String> termInsurance= new ArrayList<String>();
        termInsurance.add("Death & Accident Insurance");
        termInsurance.add("Critical Illness Insurance");

        // Adding child data
        List<String> healthInsurance = new ArrayList<String>();
        healthInsurance .add("Medical Insurance");
        healthInsurance .add("OPD");

        // Adding child data
        List<String> travelInsurance = new ArrayList<String>();
        travelInsurance .add("Journey Insurance");
        travelInsurance .add("Luggage Insurance");

        // Adding child data
        List<String> generalInsurance = new ArrayList<String>();
        generalInsurance .add("Property Insurance");

        // Adding child data
        List<String> vehicleInsurance = new ArrayList<String>();
        vehicleInsurance .add("Two-Wheeler Insurance");
        vehicleInsurance .add("Four-Wheeler Insurance");

        listDataChild.put(listDataHeader.get(0), termInsurance); // Header, Child data
        listDataChild.put(listDataHeader.get(1), healthInsurance);
        listDataChild.put(listDataHeader.get(2), travelInsurance);
        listDataChild.put(listDataHeader.get(3), generalInsurance);
        listDataChild.put(listDataHeader.get(4), vehicleInsurance);

    }

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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}

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

public class TabSaving extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private String mParam1;
    private String mParam2;
    private TabSaving.OnFragmentInteractionListener mListener;

    public TabSaving() {
    }

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
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_tab_saving, container, false);
        expListView = (ExpandableListView) rootView.findViewById(R.id.listViewExpSaving);
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
        listDataHeader.add("Banks & Fixed Deposit");
        listDataHeader.add("Mutual Funds");
        listDataHeader.add("Indian Postal Service");
        listDataHeader.add("Retirement");
        listDataHeader.add("Governments Schemes");
        listDataHeader.add("Bonds");
        listDataHeader.add("Senior Citizens");
        //listDataHeader.add("Chit Funds");

        // Adding child data
        List<String> banksAndFD = new ArrayList<String>();
        banksAndFD.add("Saving Accounts");
        banksAndFD.add("Fixed Deposits");
        banksAndFD.add("Recurring Deposit");
        banksAndFD.add("Lockers");

        List<String> mutualFunds = new ArrayList<String>();
        mutualFunds.add("SIP Calculator");
        mutualFunds.add("SWP Calculator");
        mutualFunds.add("Tax Saving Mutual Fund");
        mutualFunds.add("RGESS Mutual Fund");

        List<String> indianPostalService= new ArrayList<String>();
        indianPostalService.add("Recurring Deposit");
        indianPostalService.add("Monthly Income Scheme");
        indianPostalService.add("Public Provident Fund");
        indianPostalService.add("National Saving Certificate");
        indianPostalService.add("Kisan Vikas Patra");

        List<String> retirements= new ArrayList<String>();
        retirements.add("National Pension Scheme - NPS");
        retirements.add("Employee Provident Fund");
        retirements.add("Gratuity");
        retirements.add("Atal Pension Yojana");
        retirements.add("Pension Calculator");

        List<String> seniorCitizens= new ArrayList<String>();
        seniorCitizens.add("Fixed Deposit");

        List<String> govermentSchemes= new ArrayList<String>();
        govermentSchemes.add("Jan Dhan Account");
        govermentSchemes.add("Sukanya Smaruddhi Yojana");
        govermentSchemes.add("Garib Kalyan Yojana");

        List<String> bonds= new ArrayList<String>();
        bonds.add("Infrastructure Bond");
        bonds.add("Sovereign Gold Bond");
        bonds.add("Financial Institution Bond");


        listDataChild.put(listDataHeader.get(0), banksAndFD); // Header, Child data
        listDataChild.put(listDataHeader.get(1), mutualFunds);
        listDataChild.put(listDataHeader.get(2), indianPostalService);
        listDataChild.put(listDataHeader.get(3), retirements);
        listDataChild.put(listDataHeader.get(4), govermentSchemes);
        listDataChild.put(listDataHeader.get(5), seniorCitizens);
        listDataChild.put(listDataHeader.get(5), bonds);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TabSaving.OnFragmentInteractionListener) {
            mListener = (TabSaving.OnFragmentInteractionListener) context;
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

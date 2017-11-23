package com.example.admin.savemymoneyapplication;

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/


import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements TabSaving.OnFragmentInteractionListener,TabInsurance.OnFragmentInteractionListener,TabCreditCard.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Saving"));
        tabLayout.addTab(tabLayout.newTab().setText("Insurance"));
        tabLayout.addTab(tabLayout.newTab().setText("Credit Card"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*mListView = (ListView) findViewById(R.id.list);

        //Declaring Array adapter
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Countries);

        //Setting the android ListView's adapter to the newly created adapter
        mListView.setAdapter(countryAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //The position where the list item is clicked is obtained from the
                //the parameter position of the android listview
                int itemPosition = position;

                //Get the String value of the item where the user clicked
                String itemValue = (String) mListView.getItemAtPosition(position);

                //In order to start displaying new activity we need an intent
                Intent intent = new Intent(getApplicationContext(),CountryActivity.class);

                //Putting the Id of image as an extra in intent
                intent.putExtra("flag",FlagId[position]);

                //Here we will pass the previously created intent as parameter
                startActivity(intent);

            }
        });
*/

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


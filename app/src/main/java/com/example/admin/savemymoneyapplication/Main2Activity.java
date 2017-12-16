package com.example.admin.savemymoneyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import org.w3c.dom.Text;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity {

    private Button btnSavingCalculate;
    private EditText txtLumpsumPurchase;
    private EditText txtInterstRate;
    private EditText txtTenure;
    private TextView localtxtTotalInvested;
    private TextView localtxtTotalInterstEarned;
    private TextView localtxtNetTotal;
    private Button btnEmail;
    private Button btnShare;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//        btnSavingCalculate = (Button) findViewById(R.id.btnSavingCalculate) ;
//        btnSavingCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtLumpsumPurchase = (EditText) findViewById(R.id.idLumpsumPurchase);
//                txtInterstRate= (EditText) findViewById(R.id.idSavingAccountInterstRate);
//                txtTenure= (EditText) findViewById(R.id.idTotalTenure);
//                localtxtTotalInvested=(TextView)findViewById(R.id.txtTotalInvested);
//                localtxtTotalInterstEarned=(TextView)findViewById(R.id.txtTotalInterstEarned);
//                localtxtNetTotal=(TextView)findViewById(R.id.txtNetTotal);
//                btnEmail=(Button) findViewById(R.id.btnEmail);
//                btnShare=(Button) findViewById(R.id.btnShare);
//                int totalInvested=Integer.parseInt(txtLumpsumPurchase.getText().toString());
//                int interstRate=Integer.parseInt(txtInterstRate.getText().toString());
//                int tenureRate=Integer.parseInt(txtTenure.getText().toString());
//                int totalInterstEarned=0;
//                int openBalanceForYear=0;
//                int closeBalanceForYear=0;
//                int totalCalculate=0;
//                openBalanceForYear=totalInvested;
//                for (int i=0;i<tenureRate;i++)
//                {
//                    totalInterstEarned=(openBalanceForYear*interstRate)/100;
//                    closeBalanceForYear=openBalanceForYear+totalInterstEarned;
//                    //totalInvested=closeBalanceForYear;
//                    openBalanceForYear=closeBalanceForYear;
//                }
//                localtxtTotalInvested.setText("Total Invested: "+String.valueOf(totalInvested));
//                localtxtTotalInterstEarned.setText("Total Interst Earned: "+String.valueOf(closeBalanceForYear-totalInvested));
//                localtxtNetTotal.setText("Net Total: "+String.valueOf(closeBalanceForYear));
//                btnEmail.setVisibility(View.VISIBLE);
//                btnShare.setVisibility(View.VISIBLE);
//                InputMethodManager imm = (InputMethodManager)getSystemService(view.getContext().INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

//            }
//        });
    }

}

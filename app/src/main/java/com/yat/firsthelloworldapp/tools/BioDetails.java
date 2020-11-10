package com.yat.firsthelloworldapp.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yat.firsthelloworldapp.R;

import java.util.HashMap;

public class BioDetails extends AppCompatActivity {

    TextView txBioDetails;
    HashMap <String ,String > object1, object2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_details);
        txBioDetails =findViewById(R.id.tx_BioDetails);

        object1 = (HashMap<String, String>)getIntent().getExtras().get("nadalKey");
        object2=(HashMap<String, String>)getIntent().getExtras().get("novakKey");

        if (object1 !=null){
            showBioDetails(object1);
        }
        else{
            showBioDetails(object2);
        }

    }

    public void showBioDetails(HashMap<String ,String> hashMapObject){

        hashMapObject.get("bio");
        txBioDetails.setText(" "+hashMapObject.get("bio"));
    }


}
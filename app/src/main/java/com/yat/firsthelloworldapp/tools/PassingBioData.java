package com.yat.firsthelloworldapp.tools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yat.firsthelloworldapp.R;

import java.util.HashMap;

public class PassingBioData extends Fragment implements View.OnClickListener {

    String nadalBio = "Rafael \"Rafa\" Nadal Parera   Spanish:   born 3 June 1986) is a Spanish professional tennis player " +
            "currently ranked world No. 2 in men's singles tennis by the Association of Tennis Professionals  Nadal has won 20 " +
            "Grand Slam singles titles, tied for the most in history for a male player with Roger Federer, as well as 35 ATP Tour " +
            "Masters 1000 titles, 21 ATP Tour 500 titles and 2 Olympic gold medals (one each for singles and doubles in 2008 and 2016 " +
            "respectively). " + "In addition, Nadal has held the world No. 1 ranking for a total of 209 weeks, including being" +
            " the year-end No. 1 five times.";

    String novakBio = "Novak Djokovic  romanized: Novak Đoković,  (About this soundlisten); " +
            " born 22 May 1987) is a Serbian professional tennis player who is currently ranked world " +
            "No. 1 in men's singles tennis by the Association of Tennis Professionals (ATP)" +
            "Djokovic has won 17 Grand Slam singles titles, the third-most in history for a " +
            "male player, five ATP Finals titles, a record 36 ATP Tour Masters 1000 titles, 14 " +
            "ATP Tour 500 titles, and has held the No. 1 spot in the ATP rankings for a total of " +
            "290 weeks (second of all time). In majors, he has won a record eight Australian Open titles, five";

    HashMap<String ,String  > nadalHashMap, novakHashMap ;

    ImageView nadalImage, novakImage ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_passing_bio_data, container, false);

        nadalImage=v.findViewById(R.id.iv_nadal);
        novakImage=v.findViewById(R.id.iv_novak);
        nadalImage.setOnClickListener(this);
        novakImage.setOnClickListener(this);

        nadalHashMap=new HashMap<>();
        novakHashMap=new HashMap<>();

        nadalHashMap.put("bio",nadalBio);
        novakHashMap.put("bio",novakBio);


        return v;
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_nadal:
                Intent goToBioDetails = new Intent(getContext() ,BioDetails.class);
                goToBioDetails.putExtra("nadalKey",nadalHashMap);
                startActivity(goToBioDetails);
                break;

            case R.id.iv_novak:
                goToBioDetails = new Intent(getContext(), BioDetails.class);
                goToBioDetails.putExtra("novakKey",novakHashMap);
                startActivity(goToBioDetails);
                break;

        }
    }
}
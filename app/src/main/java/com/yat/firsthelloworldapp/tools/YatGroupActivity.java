package com.yat.firsthelloworldapp.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

public class YatGroupActivity extends Fragment {


    ListView lvYatGroup;
    String[] groupNames = {"Muhammed Ezzat", "Amr Adel", "Heba Nabil", "Mahmoud reda", "Mohamed Gamal Negm",
            "Mohamed Samir", "Mohamed Shabaan", "Nermin Sherif", "Nesrin Gamal", "Rahma Mostafa", "Yasmin Khairy", "Eslam Medhat"
            , "ndjkankj", "sdknalk", "dnkanlnm", "8932984789", "ksmdlka"};

    String[] jobDescription = {"Android Developer", "IOS Developer", "PHP Developer", "Node.js Developer", "Flutter Developer",
            "Kotlin Developer", "Swift Developer", "Java Developer", "XML Developer", "IOS Developer", "Android Developer",
            "Ruby Developer", "GO Developer", "Python Developer", "node Developer", "IOS Developer", "Android Developer"};

    Integer[] imageProfile = {R.drawable.profile};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_yat_group, container, false);
        lvYatGroup = v.findViewById(R.id.lv_yatGroup);

        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(getActivity(), groupNames, jobDescription, imageProfile);
        lvYatGroup.setAdapter(myListViewAdapter);

        lvYatGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getContext(), groupNames[position] + "\n" + jobDescription[position], Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}


//        ArrayAdapter yatAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,
//                android.R.id.text1,groupNames);
//        lvYatGroup.setAdapter(yatAdapter);

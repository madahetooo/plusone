package com.yat.firsthelloworldapp.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.yat.firsthelloworldapp.R;

public class PDFActivity extends Fragment {

    PDFView cvPDF;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_p_d_f, container, false);


        cvPDF = v.findViewById(R.id.pdfView);

        cvPDF.fromAsset("mobile_track.pdf").load();

        return v;
    }

}
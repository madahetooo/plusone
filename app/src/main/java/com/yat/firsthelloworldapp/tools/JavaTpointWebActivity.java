package com.yat.firsthelloworldapp.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

public class JavaTpointWebActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_java_tpoint_web, container, false);

        WebView javaTpointWebSite = v.findViewById(R.id.javaTpointWebSite);


        javaTpointWebSite.getSettings().setJavaScriptEnabled(true);  // display content
        javaTpointWebSite.setWebViewClient(new WebViewClient());  // interact as user not google chrome
        javaTpointWebSite.loadUrl("https://www.javatpoint.com/"); //load URL

        return v;
    }
}

package com.yat.firsthelloworldapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.yat.firsthelloworldapp.R;
import com.yat.firsthelloworldapp.entertainment.Chat;
import com.yat.firsthelloworldapp.entertainment.Connect3;
import com.yat.firsthelloworldapp.entertainment.DogOrCatActivity;
import com.yat.firsthelloworldapp.entertainment.MediaActivity;
import com.yat.firsthelloworldapp.entertainment.MusicActivity;
import com.yat.firsthelloworldapp.entertainment.RandomHighestMountains;
import com.yat.firsthelloworldapp.entertainment.ResaurantActivity;
import com.yat.firsthelloworldapp.tools.CalculatorActivity;
import com.yat.firsthelloworldapp.tools.JavaTpointWebActivity;
import com.yat.firsthelloworldapp.tools.MapsActivity;
import com.yat.firsthelloworldapp.tools.PDFActivity;
import com.yat.firsthelloworldapp.tools.PassingBioData;
import com.yat.firsthelloworldapp.tools.TemperatureConverterActivity;
import com.yat.firsthelloworldapp.tools.YatGroupActivity;
import com.yat.firsthelloworldapp.utils.MainActivity;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private GoogleSignInClient mSignInClient;
    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    boolean doubleBackToExitPressedOnce = false;
    DatabaseReference databaseReference;
    TextView userName, email;
    ImageView userProfileImage;
    String googleUserName, userEmail , userPhoto;
    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        View header = navigationView.getHeaderView(0);
        userName = header.findViewById(R.id.txFirstName);
        email =  header.findViewById(R.id.txEmail);
        userProfileImage =  header.findViewById(R.id.iv_userPhoto);

        if (currentUser != null) {
            googleUserName = currentUser.getDisplayName();
            userName.setText(googleUserName);
            userEmail = currentUser.getEmail();
            email.setText(userEmail);
            userPhoto = String.valueOf(currentUser.getPhotoUrl());
            Picasso.with(this).load(userPhoto).into(userProfileImage);

        }


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mSignInClient = GoogleSignIn.getClient(this, gso);

        // Initialize FirebaseAuth
        mFirebaseAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Chat()).commit();
            navigationView.setCheckedItem(R.id.item_chat);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_dog_or_cat:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DogOrCatActivity()).commit();
                break;
            case R.id.item_calculator:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalculatorActivity()).commit();
                break;
            case R.id.item_chat:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Chat()).commit();
                break;
            case R.id.item_connect3:

                Intent intent = new Intent(getApplicationContext(), Connect3.class);
                startActivity(intent);
                break;
            case R.id.item_media_app:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MediaActivity()).commit();
                break;
            case R.id.item_javaTpoint:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new JavaTpointWebActivity()).commit();
                break;
            case R.id.item_google_maps:
                Intent intent3 = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent3);
                break;
            case R.id.item_music_player:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MusicActivity()).commit();
                break;
            case R.id.item_passing_bio_data:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PassingBioData()).commit();
                break;
            case R.id.item_pdf_view:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PDFActivity()).commit();
                break;
            case R.id.item_random_highest_mountains:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RandomHighestMountains()).commit();
                break;
            case R.id.item_restaurant:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ResaurantActivity()).commit();
                break;
            case R.id.item_temperature_converter:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TemperatureConverterActivity()).commit();
                break;
            case R.id.item_yat_group:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new YatGroupActivity()).commit();
                break;
            case R.id.log_out:

                mFirebaseAuth.signOut();
                mSignInClient.signOut();
                //return to login Activity
                finish();
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "You Logged Out", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                finish();
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }
}
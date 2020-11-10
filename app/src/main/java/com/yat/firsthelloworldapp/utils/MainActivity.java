package com.yat.firsthelloworldapp.utils;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.yat.firsthelloworldapp.ui.DrawerActivity;
import com.yat.firsthelloworldapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String email, password;
    TextView tv_goToForgetPassword, tvRegister;
    EditText getEmailAddress, getPassword;
    Button goToHomeActivityButton;
    CheckBox chkRememberMe;
    boolean doubleBackToExitPressedOnce = false;
    AlertDialog.Builder buildAlertDialog;

    private static final int RC_SIGN_IN = 9001;
    private SignInButton mSignInButton;
    private GoogleSignInClient mSignInClient;
    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener stateListener;
    private FirebaseUser currentUser;

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(stateListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignInButton = (SignInButton) findViewById(R.id.sign_in_button);
        mFirebaseAuth = FirebaseAuth.getInstance();

        stateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = mFirebaseAuth.getCurrentUser();

                if (currentUser != null) {
                    startActivity(new Intent(getBaseContext(), DrawerActivity.class));
                    finish();
                } else {

                }
            }
        };


        // Set click listeners
        mSignInButton.setOnClickListener(this);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mSignInClient = GoogleSignIn.getClient(this, gso);

        // Initialize FirebaseAuth
//        getSupportActionBar().hide();

        goToHomeActivityButton = findViewById(R.id.btn_login);  // declare object by id
        getEmailAddress = findViewById(R.id.et_emailAdress);  // declare edit text object by id
        getPassword = findViewById(R.id.et_Password); // declare edit text object by id
        tv_goToForgetPassword = findViewById(R.id.tv_forgetPassword);
        tvRegister = findViewById(R.id.tv_register);
        chkRememberMe = findViewById(R.id.chk_rememberMe);

        buildAlertDialog = new AlertDialog.Builder(this);

        tvRegister.setPaintFlags(tvRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  // underline the text
        tv_goToForgetPassword.setPaintFlags(tv_goToForgetPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // underline the text
        SharedPreferences rememberMeFile = getSharedPreferences("rememberMe", 0);
        if (rememberMeFile.getBoolean("bool", false) == true) {

            String emailAddress = rememberMeFile.getString("email", "");
            getEmailAddress.setText(emailAddress);

            String password = rememberMeFile.getString("password", "");
            getPassword.setText(password);

            chkRememberMe.setChecked(true);
        }


        tv_goToForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForgetPasswordActivity = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(goToForgetPasswordActivity);
            }
        });

        goToHomeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                email = getEmailAddress.getText().toString().trim();
                password = getPassword.getText().toString().trim();


                if (!email.equals("") && !password.equals("")) {

                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent gotoHomeActivity = new Intent(MainActivity.this, DrawerActivity.class);   //navigate to another activity
                                startActivity(gotoHomeActivity);
                                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }

                        }
                    });


                    // start the intent


                } else if (!email.equals("") && password.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();

                } else if (email.equals("") && !password.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Please enter Username and password", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        buildAlertDialog.setMessage("Do you want to Exit ?")
                .setIcon(R.drawable.plusone)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(MainActivity.this, "Good Bye", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();

            }
        });
        //create AlertDialog Box
        AlertDialog alertDialog = buildAlertDialog.create();
        alertDialog.setTitle("Exit");
        alertDialog.show();
//
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce = false;
//            }
//        }, 2000);
    }

    public void goToRegistration(View view) {

        Intent goToRegistration = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(goToRegistration);
    }

    public void rememberMe(View view) {
        SharedPreferences rememberMeFile = getSharedPreferences("rememberMe", 0);

        SharedPreferences.Editor marker = rememberMeFile.edit();

        marker.putString("email", getEmailAddress.getText().toString().trim());
        marker.putString("password", getPassword.getText().toString().trim());
        marker.putBoolean("bool", true);
        marker.apply();
        Toast.makeText(MainActivity.this, "We Saved your data", Toast.LENGTH_SHORT).show();
        chkRememberMe.setChecked(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
        }


    }

    private void signIn() {
        Intent signInIntent = mSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent in signIn()
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                            finish();
                        }
                    }
                });
    }

}


//Build AlertDialog



//
//
//

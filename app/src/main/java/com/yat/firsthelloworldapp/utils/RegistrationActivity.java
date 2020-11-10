package com.yat.firsthelloworldapp.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yat.firsthelloworldapp.R;
import com.yat.firsthelloworldapp.ui.DrawerActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

//    Spinner spinCountry;
//    String[] countries = {"Egypt", "Saudi Arabia", "UAE", "Tunisia", "Morocco", "Algeria", "Others"};

    EditText etFirstName, etLastName, etEmailAddress, etPhoneNumber, etPassword, etConfirmPassword;
    public static String firstName, lastName, emailAddress, phoneNumber, password, confirmPassword;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private DatabaseReference userReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        spinCountry = findViewById(R.id.spinner_country);
        etFirstName = findViewById(R.id.et_FirstName);
        etLastName = findViewById(R.id.et_LastName);
        etEmailAddress = findViewById(R.id.et_emailAddress);
        etPhoneNumber = findViewById(R.id.et_PhoneNumber);
        etPassword = findViewById(R.id.et_Password);
        etConfirmPassword = findViewById(R.id.et_confirmPassword);

        firebaseAuth = FirebaseAuth.getInstance();

        userReference = FirebaseDatabase.getInstance().getReference().child("Users");


//        spinCountry.setOnItemSelectedListener(this);
//
//        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
////        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinCountry.setAdapter(spinnerAdapter);

    }


//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//        Toast.makeText(this, countries[position], Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

    public void registerNow(View view) {

        firstName = etFirstName.getText().toString().trim();
        lastName = etLastName.getText().toString().trim();
        emailAddress = etEmailAddress.getText().toString().trim();
        phoneNumber = etPhoneNumber.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();

        if (firstName.equals("")) {
            etFirstName.setError("Please Enter first name");
        }
        if (lastName.equals("")) {
            etLastName.setError("Please Enter last name");
        }
        if (isValid(emailAddress, password, confirmPassword, phoneNumber) && !firstName.equals("")
                && !lastName.equals("")) {

            firebaseAuth.createUserWithEmailAndPassword(emailAddress, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        user = task.getResult().getUser();
                        UserProfileChangeRequest ProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(etFirstName.getText().toString())
                                .build();
                        user.updateProfile(ProfileChangeRequest);
                        DatabaseReference newUser = userReference.child(user.getUid());
                        newUser.child("firstName").setValue(firstName);
                        newUser.child("lastName").setValue(lastName);
                        newUser.child("emailAddress").setValue(emailAddress);
                        newUser.child("phoneNumber").setValue(phoneNumber);
                        newUser.child("password").setValue(password);

                        Intent goToHomeActivity = new Intent(RegistrationActivity.this, DrawerActivity.class);
                        startActivity(goToHomeActivity);
                        Toast.makeText(getApplicationContext(), "Registration successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }


                }
            });

        } else {
            Toast.makeText(this, "Please fill your data", Toast.LENGTH_SHORT).show();
        }


    }


    //VALIDATION
    //=================================================================

    //validation for phone
    private boolean isValidPhone(String phone) {
        boolean valid = false;
        String PHONE_PATTERN = "^[+]?[0-9]{10,13}$";
        Pattern pattern = Pattern.compile(PHONE_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) valid = true;
        return valid;
    }

    // validation for password
    private boolean isValidPassword(String pass) {
        boolean valid = false;
        String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pass);
        if (matcher.matches()) valid = true;
        return valid;
    }

    // validation for email
    private boolean isValidEmail(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,255}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    //setError
    public boolean isValid(String st_email, String st_password, String st_confirmPassword, String stPhoneNumber) {
        boolean valid = true;
        if (!isValidEmail(st_email)) {
            etEmailAddress.setError("Enter valid Email");
            valid = false;
        }
        if (!st_password.equals(st_confirmPassword)) {
            etConfirmPassword.setError("Password not matched");
            valid = false;
        }
        if (!isValidPassword(st_password)) {
            etPassword.setError("Use Numbers Upper and Lower case");
            valid = false;
        }
        if (!isValidPhone(stPhoneNumber)) {
            etPhoneNumber.setError("Enter valid phone number");
            valid = false;
        }

        return valid;
    }
}
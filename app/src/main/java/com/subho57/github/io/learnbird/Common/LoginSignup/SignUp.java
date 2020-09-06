package com.subho57.github.io.learnbird.Common.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.subho57.github.io.learnbird.R;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    //Get the data variables
    TextInputLayout fullName, email, password, conpass;
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks for getting data
        fullName = findViewById(R.id.signup_fullname);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        conpass = findViewById(R.id.signup_confirm_password);

    }

    public void callNextSignUpScreen(View view) {
        if (!validateConfirmPassword() | !validateEmail() | !validatePassword() | !validateFullName()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);


        //Add Shared Animation
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair<>(findViewById(R.id.signup_back_button1), "transition_back_arrow_btn");
        pairs[1] = new Pair<>(findViewById(R.id.signup_next_button1), "transition_next_btn");
        pairs[2] = new Pair<>(findViewById(R.id.signup_login_button1), "transition_login_btn");
        pairs[3] = new Pair<>(findViewById(R.id.signup_title_text1), "transition_title_text");
        pairs[4] = new Pair<>(findViewById(R.id.signup_slide_text1), "transition_slide_text");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callLoginFromSignUp(View view) {
        finish();
    }

    //validation functions
    private boolean validateFullName() {
        String val = Objects.requireNonNull(fullName.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = Objects.requireNonNull(email.getEditText()).getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = Objects.requireNonNull(password.getEditText()).getText().toString().trim();
//        String checkPassword = "^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                //"(?=S+$)" +           //no white spaces
//                //".{4,}" +               //at least 4 characters
//                "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        }
//        else if (!val.matches(checkPassword)) {
//            password.setError("Password should contain 4 characters!");
//            return false;
//        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String val = Objects.requireNonNull(conpass.getEditText()).getText().toString().trim();
        String val2 = Objects.requireNonNull(password.getEditText()).getText().toString().trim();
//        String checkPassword = "^" +
//                //"(?=.*[0-9])" +         //at least 1 digit
//                //"(?=.*[a-z])" +         //at least 1 lower case letter
//                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
//                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
//                "$";

        if (val.isEmpty()) {
            conpass.setError("Field can not be empty");
            return false;
        }
//        else if (!val.matches(checkPassword)) {
//            conpass.setError("Password should contain 4 characters!");
//            return false;
//        }
        else if (val.compareTo(val2) != 0) {
            conpass.setError("Both Passwords do not match");
            return false;
        } else {
            conpass.setError(null);
            conpass.setErrorEnabled(false);
            return true;
        }
    }
}
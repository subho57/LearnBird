package com.subho57.github.io.learnbird.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.subho57.github.io.learnbird.R;
import com.subho57.github.io.learnbird.User.UserDashboard;

import java.util.Objects;

public class Login extends AppCompatActivity {

    //Get the data variables
    TextInputLayout email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hooks
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.login_password);

    }

    public void callSignUpFromLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.signup_btn), "signup_page1");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void letTheUserLoggedIn(View view) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.letTheUserLogIn), "sign_in_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
        finish();
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
//                "(?=S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
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

    public void callForgetPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.forgot_password_btn), "forgot_password_page");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }
}
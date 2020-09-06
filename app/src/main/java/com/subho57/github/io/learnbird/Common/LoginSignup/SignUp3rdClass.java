package com.subho57.github.io.learnbird.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.subho57.github.io.learnbird.R;

import java.util.Objects;

public class SignUp3rdClass extends AppCompatActivity {
    TextInputLayout phoneNumber, varsity, dept, degree, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);

        /* hook */
        phoneNumber = findViewById(R.id.signup_phone_number);
        varsity = findViewById(R.id.signup_collegename);
        dept = findViewById(R.id.signup_departmentname);
        degree = findViewById(R.id.signup_degreename);
        city = findViewById(R.id.signup_cityname);

    }

    public void register_user(View view) {
        if (!validatePhoneNumber() | !validateCollegeName() | !validateCityName() | !validateDegreeName() | !validateDepartmentName()) {
            return;
        }
        Toast.makeText(this, "Registration Successful!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<>(findViewById(R.id.signup_next_button3), "login_page");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent, options.toBundle());
    }

    public void callLoginFromSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void call2ndSignupScreen(View view) {
        finish();
    }

    //validation functions
    private boolean validateCollegeName() {
        String val = Objects.requireNonNull(varsity.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            varsity.setError("Field can not be empty");
            return false;
        } else {
            varsity.setError(null);
            varsity.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateCityName() {
        String val = Objects.requireNonNull(city.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            city.setError("Field can not be empty");
            return false;
        } else {
            city.setError(null);
            city.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateDegreeName() {
        String val = Objects.requireNonNull(degree.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            degree.setError("Field can not be empty");
            return false;
        } else {
            degree.setError(null);
            degree.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateDepartmentName() {
        String val = Objects.requireNonNull(dept.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            dept.setError("Field can not be empty");
            return false;
        } else {
            dept.setError(null);
            dept.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = Objects.requireNonNull(phoneNumber.getEditText()).getText().toString().trim();
//        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        }
//        else if (!val.matches(checkspaces)) {
//            phoneNumber.setError("No White spaces are allowed!");
//            return false;
//        }
        else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }

    }
}
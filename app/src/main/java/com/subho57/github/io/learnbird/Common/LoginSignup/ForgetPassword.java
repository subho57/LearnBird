package com.subho57.github.io.learnbird.Common.LoginSignup;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.subho57.github.io.learnbird.R;

import java.util.Objects;

public class ForgetPassword extends AppCompatActivity {

    TextInputLayout email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        //hook
        email = findViewById(R.id.forget_email);
    }

    public void callBackScreenFromForgetPassword(View view) {
        finish();
    }

    public void verifyemail(View view) {
        if(!validateEmail())
            return;
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
}
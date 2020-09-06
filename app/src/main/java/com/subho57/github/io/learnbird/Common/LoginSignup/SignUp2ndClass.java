package com.subho57.github.io.learnbird.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.subho57.github.io.learnbird.R;


public class SignUp2ndClass extends AppCompatActivity {


    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up2nd_class);


        //Hooks
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);


    }


    public void call3rdSignupScreen(View view) {
        if (!validateGender()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), SignUp3rdClass.class);


        //Add Transition and call next activity
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair<>(findViewById(R.id.signup_back_button2), "transition_back_arrow_btn");
        pairs[1] = new Pair<>(findViewById(R.id.signup_next_button2), "transition_next_btn");
        pairs[2] = new Pair<>(findViewById(R.id.signup_login_button2), "transition_login_btn");
        pairs[3] = new Pair<>(findViewById(R.id.signup_title_text2), "transition_title_text");
        pairs[4] = new Pair<>(findViewById(R.id.signup_slide_text2), "transition_slide_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callLoginFromSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void call1stSignupScreen(View view) {
        finish();
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


}
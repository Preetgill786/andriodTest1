package com.example.courseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener, CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener {
TextView tvWelcome;
RadioGroup rgChoice;
RadioButton rbUnGrd,rbGrd;
Spinner spCourse;
Button btnAdd,btnlogout;
EditText etFees,etHours,etTotalfees,etTotalhours;
    CheckBox chAcc,chINsu;
int[] cFees= {1300, 1500, 1350, 1400, 1000};
int [] cHours={6,5,5,7,4};
static int i;
    int totalhour=0;
    int totalfees=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvWelcome=findViewById(R.id.welcome);
        tvWelcome.setText("Welcome "+MainActivity.stuName);
        rbGrd=findViewById(R.id.Graduate);
        rbUnGrd=findViewById(R.id.UnderGraduate);
        spCourse=findViewById(R.id.courses);
        etFees=findViewById(R.id.fees);
        etHours=findViewById(R.id.hours);
        etTotalfees=findViewById(R.id.tfees);
        etTotalhours=findViewById(R.id.tHours);
        btnAdd=findViewById(R.id.add);
        btnlogout=findViewById(R.id.logout);
        chAcc=findViewById(R.id.accommodation);
        chINsu=findViewById(R.id.mediInsu);

        chAcc.setOnCheckedChangeListener(this);
        chINsu.setOnCheckedChangeListener(this);
        rgChoice=findViewById(R.id.rgPost);
        rgChoice.setOnCheckedChangeListener(this);



        List<String> course = new ArrayList<String>();
        course.add("JAVA");
        course.add("Swift");
        course.add("IOS");
        course.add("Android");
        course.add("Database");




        //create an adapter and fill it from the list
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, course);
        //make the drop down style
        courseAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        spCourse.setAdapter(courseAdapter);
        spCourse.setOnItemSelectedListener(this);

        btnAdd.setOnClickListener(this);
        btnlogout.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {


        i = position;
        Integer fee = new Integer(cFees[i]);
        etFees.setText(fee.toString());
        Integer hour =  new Integer(cHours[i]);
        etHours.setText(hour.toString());


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add:


                if (rbGrd.isChecked()) {
                    if (totalhour >= 21) {
                        Toast.makeText(getApplicationContext(), "Maximum course hours shouldn't exceed 21", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else if (rbUnGrd.isChecked()) {
                    if (totalhour >= 19) {
                        Toast.makeText(getApplicationContext(), "Maximum course hours shouldn't exceed 19", Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                totalfees = cFees[i] + totalfees;
                etTotalfees.setText(totalfees + "");

                totalhour = cHours[i] + totalhour;
                etTotalhours.setText(totalhour + "");
                break;
            case R.id.logout:
                Intent act1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(act1);
                break;
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.accommodation:
                if(b){
      totalfees = totalfees+1000;

                }
                if(!b){
                    totalfees -=1000;
                }
                break;
            case R.id.mediInsu:
                if (b){
                    totalfees = totalfees+700;
                }
                if(!b){
                    totalfees -=700;
                }
                break;
        }
        etTotalfees.setText(totalfees+"");
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {



    }
}

package com.example.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewMonthlyPayment;
    TextView textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewStatus=(TextView) findViewById(R.id.textViewStatus);
        textViewMonthlyPayment=(TextView) findViewById(R.id.textViewMonthlyPayment);
        //To receive data from another Activity
        Intent intent = getIntent();//Asking "Who call me?"
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT,0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);
        //TODO: Display the outputs
        textViewMonthlyPayment.setText(String.format("Monthly Payment: %.2f",payment));
        textViewStatus.setText("Status: "+status);
    }
    public void closeActivity(View view){
        //Terminate the current activity
        finish();

    }
}

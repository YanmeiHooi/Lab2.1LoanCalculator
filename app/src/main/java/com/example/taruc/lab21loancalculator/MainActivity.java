package com.example.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    EditText editTextVehiclePrice;
    EditText editTextDownpayment;
    EditText editTextRepayment;
    EditText editTextInterestRate;
    EditText editTextSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextVehiclePrice = (EditText) findViewById(R.id.editTextVehiclePrice) ;
        editTextDownpayment = (EditText) findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText) findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
    }
    public void calculateLaon(View view){
        //TODO: calculate monthly payment and determine the loan status

        double vehiclePrice = Double.parseDouble(editTextVehiclePrice.getText().toString());
        double salary = Double.parseDouble(editTextSalary.getText().toString());
        double downPayment = Double.parseDouble(editTextDownpayment.getText().toString());
        double repayment = Double.parseDouble(editTextRepayment.getText().toString());
        double interestRate = Double.parseDouble(editTextInterestRate.getText().toString())/100;
        double totalInterest = (vehiclePrice-downPayment)*interestRate*(repayment/12);
        double totalLoan = (vehiclePrice-downPayment)+ totalInterest;
        double monthlyPayment=totalLoan/repayment;
        String status = "Approved";
        if(monthlyPayment>(salary*0.3)){
            status="Rejected";
        }
        //create Explicit intent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO: passing data using putExtra method
        //format : putExtra( TAG,value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }
    public void reset(View view){
        editTextVehiclePrice.setText("");
        editTextDownpayment.setText("");
        editTextRepayment.setText("");
        editTextInterestRate.setText("");
        editTextSalary.setText("");

    }
}

package com.example.brhodes.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billNoTipTotalEditText;
    EditText tipPercentageEditText;
    Button tipAndTotalButton;
    TextView tipTotalTextView;
    TextView totalBillTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billNoTipTotalEditText = (EditText)findViewById(R.id.BillNoTipEditText);
        tipPercentageEditText = (EditText)findViewById(R.id.TipPercentageEditText);
        tipAndTotalButton = (Button)findViewById(R.id.CalculateTipAndTotalButton);
        tipTotalTextView = (TextView)findViewById(R.id.TipTotalTextView);
        totalBillTextView = (TextView)findViewById(R.id.TotalBillTextView);

        tipAndTotalButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               String tipStr = tipPercentageEditText.getText().toString();
               double tipPct = Double.valueOf(tipStr) / 100;
               calcAndDisplayTheTip(tipPct);
           }
        });

    }

    void calcAndDisplayTheTip(Double tipPercentage) {
        // Get the bill total with no tip
        Double billNoTip;
        billNoTip = Double.valueOf(billNoTipTotalEditText.getText().toString());

        // Determine the tip and display
        Double tip;
        tip = billNoTip * tipPercentage;

        tipTotalTextView.setText("Tip Total - $" + String.format("%.2f", tip));

        // Determine total bill
        Double totalBill = billNoTip + tip;

        // Display total bill
       totalBillTextView.setText("Total Bill - $" + String.format("%.2f", totalBill));

    }
}

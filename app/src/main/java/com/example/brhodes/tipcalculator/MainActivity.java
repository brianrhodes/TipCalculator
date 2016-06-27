package com.example.brhodes.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billNoTipTotalEditText;
    Button tenPercentButton;
    Button fifteenPercentButton;
    Button twentyPercentButton;
    TextView tipTotalTextView;
    TextView totalBillTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billNoTipTotalEditText = (EditText)findViewById(R.id.BillNoTipEditText);
        tenPercentButton = (Button)findViewById(R.id.TenPercentTipButton);
        fifteenPercentButton = (Button)findViewById(R.id.FifteenPercentTipButton);
        twentyPercentButton = (Button)findViewById(R.id.TwentyPercentTipButton);
        tipTotalTextView = (TextView)findViewById(R.id.TipTotalTextView);
        totalBillTextView = (TextView)findViewById(R.id.TotalBillTextView);

        tenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcAndDisplayTheTip(0.10);
            }
        });

        fifteenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcAndDisplayTheTip(0.15);
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcAndDisplayTheTip(0.20);
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
      //  totalBillTextView.setText("Total Bill - $" + String.format("%.2f", totalBill));

    }
}

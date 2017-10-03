package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.checked;

//This app figures out the cost of coffee based on what is ordered

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Step 1 of 3 Define Variables
    int quanity;
    CheckBox whippedCream;
    Button btn_min,btn_add,btn_odr;
    //private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step 2 of 3 Define objects
        whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        btn_min = (Button) findViewById(R.id.decrement);
        btn_add =(Button) findViewById(R.id.increment);
        btn_odr=(Button) findViewById(R.id.button);

        // Step 3 of 3 set on click listener
        btn_min.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_odr.setOnClickListener(this);
    }

    //This method is called when the plus button is clicked.
    public void increment (View view) {
        quanity= quanity + 1 ;
        displayQuality(quanity);
    }
    //This method is called when the minus button is clicked.
    public void decrement (View view) {
         quanity=quanity-1;
        displayQuality(quanity) ;
    }

    // This method is called when the order button is clicked
    public void submitOrder(View view) {
        if(whippedCream.isChecked())
        {
            Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Not Checked",Toast.LENGTH_LONG).show();
        }
    }

    public void onCheckboxClicked(View view)
    {

    }
        //instance for the checkboxes
    /*public void onClick(View view) {
    StringBuilder result = new StringBuilder();
        result.append("Selected Items:");
        if(whippedCream.isChecked()){
        }

        int price = calculatePrice();
        displayMessage(createSummary(price));
    }*/

    //Calculates the price of the order.
    private int calculatePrice() {
        return quanity * 5;
    }

    //This method displays the the summary of what is displayed on the screen
    //@param price & @return summary of order
    private String createSummary(int price){
        String priceMessage ="Name: Shiva T ";
        priceMessage +=  "\n Add whipped cream ? " + true;
        priceMessage += "\n Quantity " + quanity;
        priceMessage += "\n Total $" + price;
        priceMessage += " \n Thank you!";
        return priceMessage ;
    }

     //This method displays the quantity on the screen.
    private void displayQuality(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    // This method is called when the price button is clicked
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
     //This method displays the given text on the screen
    private void displayMessage(String message) {
        //TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        //orderSummaryTextView.setText(message);
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button :
            {
                displayMessage("Örder");
                break;
            }
            case R.id.increment :
            {
                Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_LONG).show();
            }
            case R.id.decrement :
            {
                Toast.makeText(getApplicationContext(),"Not Checked",Toast.LENGTH_LONG).show();
            }

        }
    }
}
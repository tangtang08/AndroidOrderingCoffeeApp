package com.cre8tivedevs.ordercoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment (View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    public void decrement (View view){
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    // this is linked to the ORDER button on the xml activity
    public void submitOrder (View view) {
        int price = calculatePrice();
        displayMessage (createOrderSummary(price));
    }


    private int calculatePrice(){
       return quantity * price;
    }

   private String createOrderSummary(int amount){
        String priceMessage = "Name Tangy";

        priceMessage += "Total: $" + amount;
        return priceMessage;
    }

    private void displayQuantity (int numberofCoffees){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberofCoffees);
    }

    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }


}

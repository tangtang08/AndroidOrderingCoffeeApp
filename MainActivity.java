package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

import static android.R.attr.checked;

//This app figures out the cost of coffee based on what is ordered

public class MainActivity extends AppCompatActivity {
    int quanity;
    //private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox =  (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream" + hasWhippedCream);

        int price = calculatePrice();
        displayMessage(createSummary(price ));
        }

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
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
package com.cre8tivedevs.ordercoffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    private boolean priceMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {

        if (quantity ==100){
            // this is where the toast is
            Toast.makeText(this, "You have to choose less than 100 cups of coffee", Toast.LENGTH_SHORT).show();

            //I am exiting the method
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {

        if(quantity==1) {
            //Show an error using a toast
            Toast.makeText(this, "You have to choose at least 1 cup of coffee", Toast.LENGTH_SHORT).show();

            // I am now exiting the method
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    // this is linked to the ORDER button on the xml activity
    public void submitOrder(View view) {


       CheckBox whippedCreamCheckBox =  findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String message = createOrderSummary(price, hasWhippedCream, hasChocolate);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "This order is for you" );
        intent.putExtra(Intent.EXTRA_TEXT,message );

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(message);


    }

        private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

            //int quanity = quantity * 5;
            //return quanity;

            int basePrice = 5;

            if (addWhippedCream) {
                basePrice = basePrice + 1;
            }

            if (addChocolate) {
                basePrice = basePrice + 2;
            }

            return quantity * basePrice;
        }




    private String createOrderSummary(int amount, boolean addWhippedCream, boolean addChocolate) {

        EditText names = findViewById(R.id.name);
        String priceMessage = names.getText().toString();

        priceMessage += "\nAdd whipped cream " + addWhippedCream;
        priceMessage += "\n Add chocolate " + addChocolate;

        // add the total for whipped and chocolate

        priceMessage += "\n Total: $" + amount;
        return priceMessage;
    }


    private void displayQuantity(int numberofCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberofCoffees);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }


}

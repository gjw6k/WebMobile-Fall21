package com.example.getpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int pizza_price = 6;
    final int pep_price = 1;
    final int ham_price = 1;
    final int chicken_price=1;
    final int onion_price = 1;
    final int corn_price= 1;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method is called when the summary button is clicked
    public void orderSummary(View view){
        // gets the user's input
        EditText inputView = (EditText) findViewById(R.id.userName);
        String userInputName = inputView.getText().toString();
// checks if chicken is selected
        CheckBox chicken = (CheckBox) findViewById(R.id.chickenBox);
        boolean hasChicken = chicken.isChecked();
        // checks if pepperoni is selected
        CheckBox pepperoni = (CheckBox) findViewById(R.id.pepporniBox);
        boolean hasPepperoni = pepperoni.isChecked();

        // checks if ham is selected
        CheckBox ham = (CheckBox) findViewById(R.id.hamBox);
        boolean hasHam = ham.isChecked();

        // checks if peppers is selected
        CheckBox onions = (CheckBox) findViewById(R.id.onionBox);
        boolean hasOnions = onions.isChecked();

        // checks if pineapple is selected
        CheckBox corn = (CheckBox) findViewById(R.id.cornBox);
        boolean hasCorn = corn.isChecked();

        Intent intent = new Intent(MainActivity.this, SumActivity.class);
       intent.putExtra("summary", createOrderSummary(userInputName,hasChicken, hasPepperoni, hasHam, hasOnions, hasCorn ));

        startActivity(intent);
    }

    // calculates price
    private float calculatePrice(boolean hasChicken , boolean hasPepperoni, boolean hasHam, boolean hasOnions,  boolean hasCorn) {
        int basePrice = pizza_price;

        if (hasChicken) {
            basePrice += chicken_price;
        }

        if (hasPepperoni) {
            basePrice += pep_price;

        }
        if (hasHam) {
            basePrice += ham_price;
        }
        if (hasOnions) {
            basePrice += onion_price;
        }
        if (hasCorn) {
            basePrice += corn_price;
        }
        return quantity * basePrice;
    }

    private String boolToString(boolean bool) {
        return bool ? (getString(R.string.yes)) : (getString(R.string.no));
    }

    // displays a list of items user has ordered
    private String createOrderSummary(String userInputName, boolean hasChicken, boolean hasPepperoni, boolean hasHam, boolean hasOnions,  boolean hasCorn) {
        String orderSummaryMessage = getString(R.string.order_summary_name, userInputName) + "\n" +
                getString(R.string.order_summary_chicken, boolToString(hasChicken)) + "\n" +
                getString(R.string.order_summary_pepperoni, boolToString(hasPepperoni)) + "\n" +
                getString(R.string.order_summary_ham, boolToString(hasHam)) + "\n" +
                getString(R.string.order_summary_peppers, boolToString(hasOnions)) + "\n" +
                getString(R.string.order_summary_pineapple, boolToString(hasCorn)) + "\n" +
                getString(R.string.order_summary_quantity, quantity) + "\n" +
                getString(R.string.order_summary_total, calculatePrice(hasChicken,hasPepperoni, hasHam, hasOnions, hasCorn)) + "\n" +
                getString(R.string.thank_you);
        return orderSummaryMessage;
    }



    // update the number of quantity
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantityView);
        quantityTextView.setText("" + number);
    }

    // checks if the quantity is less than 100
    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        } else {
            Log.i("MainActivity", "Please select less than one hundred pizza");
            Context context = getApplicationContext();
            String lowerLimitToast = getString(R.string.too_much_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, lowerLimitToast, duration);
            toast.show();
            return;
        }
    }

    // checks if the quantity is greater than 0
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {
            Log.i("MainActivity", "Please select at least one pizza");
            Context context = getApplicationContext();
            String upperLimitToast = getString(R.string.too_little_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, upperLimitToast, duration);
            toast.show();
            return;
        }


    }


}
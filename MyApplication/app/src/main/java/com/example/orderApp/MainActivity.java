package com.example.orderApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        //int numberOfCoffee = 1;
        sayThanks();

        #String order_summary_email_subject = 'Hello';
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showLatest(int number) {
        display(number);
        displayPrice(number*5);

    }

    public void onPlus(View view) {
        numberOfCoffee += 1;
        showLatest(numberOfCoffee);


    }

    public void onMinus(View view) {
        showLatest(numberOfCoffee);
        if (numberOfCoffee > 0) {
            numberOfCoffee = numberOfCoffee -1;
        }
        showLatest(numberOfCoffee);

    }

    private void display(int number) {
        TextView number_textView = (TextView) findViewById(R.id.number_textView);
        number_textView.setText("" + number);

    }

    private void sayThanks() {
        TextView number_textView = (TextView) findViewById(R.id.thankYou_textView);
        number_textView.setText("Thank you for the Order");

    }


    public void displayPrice(int number){
        TextView price_number = (TextView) findViewById(R.id.price_number);
        price_number.setText("Total " +NumberFormat.getCurrencyInstance().format(number));

    }
}
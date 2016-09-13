package com.example.siuant.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*TextView textView = new TextView(this);
        textView.setText("Hey.");
        textView.setTextColor(Color.RED);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        setContentView(textView);*/
        setContentView(R.layout.activity_java);
        //setContentView(R.layout.activity_cookie);

        displayQuantity(quantity);
    }

    public void eatCookie(View view){
        TextView textView = (TextView) findViewById(R.id.cookieText);
        textView.setText("I'm so full");
        ImageView imageView = (ImageView) findViewById(R.id.cookieImage);
        imageView.setImageResource(R.drawable.after_cookie);

    }

    public void submitOrder(View view){
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(geoLocation);
        intent.setData(Uri.parse("geo:47.6, -122.3"));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }*/
        int price = quantity*5;
        //displayPrice(quantity*5);
        price = calculatePrice();

        EditText nameEditText = (EditText)findViewById(R.id.editNameText);
        String name = nameEditText.getText().toString();

        String orderSummary = createOrderSummary(price, name);
        //displayMessage("Total: $" + price + "\nThank you!");
        //displayMessage(orderSummary);

        emailOrder(orderSummary, name);

        //calculatePrice(quantity);
        //calculatePrice(quantity, 10);
    }
    private String createOrderSummary(int price, String name){

        CheckBox creamCheckBox = (CheckBox)findViewById(R.id.creamCheckBox);
        boolean creamChecked = creamCheckBox.isChecked();
        Log.v("MainActivity", "The price is " + price);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolateCheckBox);
        boolean chocolateChecked = chocolateCheckBox.isChecked();

        if(creamChecked) price += 1*quantity;
        if(chocolateChecked) price += 2*quantity;

        //String strChecked = (creamChecked) ? "true" : "false";
        //String order = "Name: " + name + "\nQuantity: " + quantity + "\n";
        String order = getString(R.string.order_summary_name, name) + "\n";
        order += "Add Whipped Cream? " + creamChecked + "\n";
        order += "Add Chocolate? " + chocolateChecked + "\n";
        order += "Total: $ " + price + "\n" + getString(R.string.thank_you);
        return order;
    }
    private void emailOrder(String order, String name){
        Intent intent = new Intent(Intent.ACTION_SEND );
        /*intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        intent.putExtra(Intent.EXTRA_EMAIL, "");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, order);*/
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL  , "");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT   , order);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        //startActivity(Intent.createChooser(intent, "Send Email"));
    }

    private int calculatePrice(int quantity){
        int price = quantity * 5;
        return price;
    }
    private int calculatePrice(int quantity, int pricePerCup){
        int price = quantity * pricePerCup;
        return price;
    }
    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }
    public void displayQuantity(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void displayPrice(int number){
        //TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        //priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void displayMessage(String message){
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_value);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view){
        quantity++;
        if(quantity > 100) quantity = 100;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity--;
        if(quantity < 0) quantity = 0;
        displayQuantity(quantity);
    }
    int team1Score = 0;
    int team2Score = 0;
    public void resetScores(View view){
        team1Score = 0;
        team2Score = 0;
        displayTeamScores(1);
        displayTeamScores(2);
    }
    public void displayTeamScores(int team){
        switch(team){
            case 1:
                TextView Team1_Score = (TextView)findViewById(R.id.Team1Score);
                Team1_Score.setText("" + team1Score);
                break;
            case 2:
                TextView Team2_Score = (TextView)findViewById(R.id.Team2Score);
                Team2_Score.setText("" + team2Score);
                break;
        }
    }
    public void score3PtsTeam1(View view){
        team1Score += 3;
        displayTeamScores(1);
    }
    public void Team1_2points(View view){
        team1Score += 2;
        displayTeamScores(1);
    }
    public void Team1_1points(View view){
        team1Score += 1;
        displayTeamScores(1);
    }
    public void Team2_3points(View view){
        team2Score += 3;
        displayTeamScores(2);
    }
    public void Team2_2points(View view){
        team2Score += 2;
        displayTeamScores(2);
    }
    public void Team2_1points(View view){
        team2Score += 1;
        displayTeamScores(2);
    }

} // end MainActivity
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/
package com.example.siuant.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        displayQuantity(quantity);
    }
    public void submitOrder(View view){
        int price = quantity*5;
        //displayPrice(quantity*5);
        price = calculatePrice();
        String orderSummary = createOrderSummary(price);
        //displayMessage("Total: $" + price + "\nThank you!");
        displayMessage(orderSummary);

        //calculatePrice(quantity);
        //calculatePrice(quantity, 10);
    }
    private String createOrderSummary(int price){
        return "Name: Kaptain Kunal\nQuantity: " + quantity + "\nTotal: $ " + price + "\nThank you!";
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
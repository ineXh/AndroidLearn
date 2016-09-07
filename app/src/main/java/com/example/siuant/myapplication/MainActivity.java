package com.example.siuant.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView textView = new TextView(this);
        String msg = getResources().getString(R.string.birthday);
        String person = getResources().getString(R.string.person_name);
        String message = msg + person + "!";
        textView.setText(message);

        //layoutParams = new RelativeLayout.LayoutParams(LayoutParams.)


        ViewGroup layout = (ViewGroup) findViewById(R.id.main_layout);

        layout.addView(textView);*/

        /*String[] textArray = {"One", "Two", "Three", "Four"};
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for( int i = 0; i < textArray.length; i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(textArray[i]);
            linearLayout.addView(textView);
        }*/

    }
}

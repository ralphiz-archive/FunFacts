package com.ralphiz.funfactstreehouse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our view variables and assign them the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final Button showReferralButton = (Button) findViewById(R.id.showReferralButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.funFactsRelativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FactBook.getmFactsShown() != 10) {
                    String fact = FactBook.getFact();
                    int color = ColorWheel.getColor();

                    // Update the label with our dynamic fact
                    factLabel.setText(fact);

                    // Update the background color
                    relativeLayout.setBackgroundColor(color);

                    // Update the button color text
                    showFactButton.setTextColor(color);
                }else {
                    String fact = FactBook.getFact();
                    int color = ColorWheel.getColor();
                    factLabel.setText(fact);
                    relativeLayout.setBackgroundColor(color);
                    showFactButton.setVisibility(View.GONE);
                    showReferralButton.setTextColor(color);
                    showReferralButton.setVisibility(View.VISIBLE);
                }
            }
        };
        showReferralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Activity started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}
package com.ralphiz.funfacts;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class FunFactsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);

            final TextView factLabel = (TextView) getView().findViewById(R.id.factTextView);
            final Button showFactButton = (Button) getView().findViewById(R.id.showFactButton);
            final Button showReferralButton = (Button) getView().findViewById(R.id.showReferralButton);
            final RelativeLayout fragment = (RelativeLayout) getView().findViewById(R.id.mainFragment);
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(FactBook.getmFactsShown() != 10) {
                        String fact = FactBook.getFact();
                        int color = ColorWheel.getColor();

                        // Update the label with our dynamic fact
                        factLabel.setText(fact);

                        // Update the background color
                        fragment.setBackgroundColor(color);

                        // Update the button color text
                        showFactButton.setTextColor(color);
                    }else {
                        String fact = FactBook.getFact();
                        int color = ColorWheel.getColor();
                        factLabel.setText(fact);
                        fragment.setBackgroundColor(color);
                        showFactButton.setVisibility(View.GONE);
                        showReferralButton.setTextColor(color);
                        showReferralButton.setVisibility(View.VISIBLE);
                    }
                }
            };
            showReferralButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://referrals.trhou.se/ralphcacho"));
                    startActivity(viewIntent);
                }
            });

            showFactButton.setOnClickListener(listener);
        }
    }

    public static class AdFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_ad, container, false);
        }

        @Override
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);

            AdView mAdView = (AdView) getView().findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }

/*    @Override
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
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://referrals.trhou.se/ralphcacho"));
                startActivity(viewIntent);
            }
        });

        showFactButton.setOnClickListener(listener);
    }*/
}
package com.example.efoeakolly.flightkit;

import android.app.Application;
import android.content.pm.ActivityInfo;
import android.graphics.PointF;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.efoeakolly.flightkit.fragments.CGGraphFragment;
import com.example.efoeakolly.flightkit.fragments.WeightAndBalanceFragment;
import com.example.efoeakolly.flightkit.models.Aircrafts;
import com.example.efoeakolly.flightkit.utils.CompatibilityUtil;
import com.example.efoeakolly.flightkit.utils.XMLDBReader;
import com.squareup.leakcanary.LeakCanary;

public class MainActivity extends FragmentActivity implements WeightAndBalanceFragment.OnCalculateButtonPressedListener/*AppCompatActivity*/ {

    private Aircrafts aircrafts;
    private static final String WB_FRAGMENT_TAG = "W&B_FRAG";


    private WeightAndBalanceFragment wbFragment;
    private CGGraphFragment cgGraphFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button calcButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (CompatibilityUtil.isTablet(getBaseContext())) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        } else {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_main);

        aircrafts = XMLDBReader.getAircrafts();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            wbFragment = new WeightAndBalanceFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            wbFragment.setArguments(getIntent().getExtras());


            // Add the fragment to the 'fragment_container' FrameLayout
            fragmentTransaction.add(R.id.fragment_container, wbFragment, WB_FRAGMENT_TAG);
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();

            WeightAndBalanceFragment fragment = (WeightAndBalanceFragment) fragmentManager.findFragmentByTag(WB_FRAGMENT_TAG);


        }

        /*cgGraphFragment = new CGGraphFragment();


        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CGGraphFragment fragment = (CGGraphFragment) fragmentManager.findFragmentByTag(CG_GRAPH_FRAGMENT_TAG);
                if (fragment == null) {
                    Bundle bundle = new Bundle();
                    //bundle.putString(KEY_MSG_3, "Replace MyFragment3");
                    cgGraphFragment.setArguments(bundle);

                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, cgGraphFragment, CG_GRAPH_FRAGMENT_TAG);
                    fragmentTransaction.commit();

                } else {
                    Log.d("CG_GRAPH_FRAGMENT_TAG", "CG_GRAPH_FRAGMENT_TAG already loaded");
                }
            }
        });*/

    }

    public void onWeightAndBalanceCalculate() {

        CGGraphFragment cgGraphFrag = (CGGraphFragment)
                getSupportFragmentManager().findFragmentById(R.id.graph);

        if (cgGraphFrag != null) {
            // If CG Graph frag is available, we're in two-pane layout...

            // Call a method in the CGGraphFragment to update its content
            cgGraphFrag.plotCGPoint(new PointF());

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            CGGraphFragment newFragment = new CGGraphFragment();
            Bundle args = new Bundle();
            args.putFloat("CG_POINT_X", 0.0f);
            args.putFloat("CG_POINT_Y", 0.0f);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}

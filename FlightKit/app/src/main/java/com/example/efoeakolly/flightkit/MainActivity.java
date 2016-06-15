package com.example.efoeakolly.flightkit;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


import com.example.efoeakolly.flightkit.fragments.CGGraphFragment;
import com.example.efoeakolly.flightkit.fragments.CompatibilityUtil;
import com.example.efoeakolly.flightkit.fragments.WeightAndBalanceFragment;

import java.util.List;

public class MainActivity extends FragmentActivity /*AppCompatActivity*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(CompatibilityUtil.isTablet(getBaseContext())){
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        } else {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        /*if (isLargeDevice(getBaseContext())) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        } else {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }*/
        setContentView(R.layout.activity_main);

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
            WeightAndBalanceFragment wbFragment = new WeightAndBalanceFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            wbFragment.setArguments(getIntent().getExtras());

            CGGraphFragment cgFragment = new CGGraphFragment();



            // Add the fragment to the 'fragment_container' FrameLayout
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_container, wbFragment);
            //ft.add(R.id.fragment_container, cgFragment);
            ft.commit();

            //ft.replace(R.id.fragment_container, cgFragment);
            //ft.addToBackStack(null);
            //ft.commit();

            /*
            //ft.add(R.id.fragment_container, new CGGraphFragment());
            //ft.commit();
            //List<Fragment> fragments = getSupportFragmentManager().getFragments();
            //Log.d("Num Frag ::: ", "" + fragments);

            //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new CGGraphFragment()).commit();
            //onWeightAndBalanceCalculate();*/
        }
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

    /**
     * @param context
     * @return
     */
    private boolean isLargeDevice(Context context) {
        int screenLayout = context.getResources().getConfiguration().screenLayout;
        screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenLayout) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return false;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return true;
            default:
                return true;
        }
    }
}

package com.example.efoeakolly.flightkit.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.efoeakolly.flightkit.NiceSpinner;
import com.example.efoeakolly.flightkit.R;
import com.example.efoeakolly.flightkit.SQLiteHelper;
import com.example.efoeakolly.flightkit.SingleEngineAircraft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by efoeakolly on 6/9/16.
 */

public class WeightAndBalanceFragment extends Fragment {

    OnCalculateButtonPressedListener mCallback;

    private Spinner choice;

    private EditText emptyWeight;
    private EditText emptyArm;
    private EditText emptyMoment;

    private EditText flSeatWeight;
    private EditText flSeatArm;
    private EditText flSeatMoment;

    private EditText rlSeatWeight;
    private EditText rlSeatArm;
    private EditText rlSeatMoment;

    private EditText baggageWeight;
    private EditText baggageArm;
    private EditText baggageMoment;

    private EditText oilQty;
    private EditText oilWeight;
    private EditText oilArm;
    private EditText oilMoment;

    private EditText fuelQty;
    private EditText fuelWeight;
    private EditText fuelArm;
    private EditText fuelMoment;

    private Drawable alertIndicator;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private static final String CG_GRAPH_FRAGMENT_TAG = "CG_G_FRAG";

    public Button getCalculateButton() {
        return calculateButton;
    }

    private Button calculateButton;

    private SingleEngineAircraft sa1;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.weight_bal_form, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        //Setup all the components
        setSpinnerContent(view);
        setInputs(view);


        return view;
    }

    /**
     *
     * @param view
     */
    private void setSpinnerContent( View view ) {

        NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five","Six","Seven"));
        niceSpinner.attachDataSource(dataset);

        /*choice = (Spinner) view.findViewById(R.id.choice);
        List<String> dataset = new LinkedList<>(Arrays.asList("Select Your Plane Model", "172N", "172S", "172P", "172RG", "172R-NAV","Six","Seven"));
        ArrayAdapter adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dataset);
        choice.setAdapter(adapter);*/


    }

    /**
     *
     * @param view
     */
    private void setInputs (View view) {

        SQLiteHelper db = new SQLiteHelper(getActivity());
        sa1 = new SingleEngineAircraft("172N",1489,38.8,57773,11,-14,-147,37,12025,73,13140,48,11520,95,5225);
        db.addAircraft(sa1);


        alertIndicator = ResourcesCompat.getDrawable(getResources(), R.drawable.alert, null);
        emptyWeight = (EditText) view.findViewById(R.id.emptyWeight);
        emptyWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        emptyArm = (EditText) view.findViewById(R.id.emptyArm);
        emptyArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        emptyMoment = (EditText) view.findViewById(R.id.emptyMoment);
        emptyMoment.setRawInputType(Configuration.KEYBOARD_12KEY);



        flSeatWeight = (EditText) view.findViewById(R.id.flSeatWeight);
        flSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        flSeatArm = (EditText) view.findViewById(R.id.flSeatArm);
        flSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        flSeatMoment = (EditText) view.findViewById(R.id.flSeatMoment);
        flSeatMoment.setRawInputType(Configuration.KEYBOARD_12KEY);


        /*EditText frSeatWeight = (EditText) findViewById(R.id.frSeatWeight);
        frSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        EditText frSeatArm = (EditText) findViewById(R.id.frSeatArm);
        frSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        EditText frSeatMoment = (EditText) findViewById(R.id.frSeatMoment);
        frSeatMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        validateEditText(frSeatWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(frSeatArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(frSeatMoment, "This Field cannot be empty!", alertIndicator);*/

        rlSeatWeight = (EditText) view.findViewById(R.id.rlSeatWeight);
        rlSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        rlSeatArm = (EditText) view.findViewById(R.id.rlSeatArm);
        rlSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        rlSeatMoment = (EditText) view.findViewById(R.id.rlSeatMoment);
        rlSeatMoment.setRawInputType(Configuration.KEYBOARD_12KEY);


        /*EditText rrSeatWeight = (EditText) findViewById(R.id.rrSeatWeight);
        rrSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        EditText rrSeatArm = (EditText) findViewById(R.id.rrSeatArm);
        rrSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        EditText rrSeatMoment = (EditText) findViewById(R.id.rrSeatMoment);
        rrSeatMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        validateEditText(rrSeatWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(rrSeatArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(rrSeatMoment, "This Field cannot be empty!", alertIndicator);*/

        baggageWeight = (EditText) view.findViewById(R.id.baggageWeight);
        baggageWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        baggageArm = (EditText) view.findViewById(R.id.baggageArm);
        baggageArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        baggageMoment = (EditText) view.findViewById(R.id.baggageMoment);
        baggageMoment.setRawInputType(Configuration.KEYBOARD_12KEY);



        oilQty = (EditText) view.findViewById(R.id.oilQty);
        oilQty.setRawInputType(Configuration.KEYBOARD_12KEY);
        oilWeight = (EditText) view.findViewById(R.id.oilWeight);
        oilWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        oilArm = (EditText) view.findViewById(R.id.oilArm);
        oilArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        oilMoment = (EditText) view.findViewById(R.id.oilMoment);
        oilMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        //validateEditText(oilQty, "This Field cannot be empty!", alertIndicator);
        if(oilQty.getText() == null){

            // default to 6 qt
            oilQty.setText("6");
        }


        fuelQty = (EditText) view.findViewById(R.id.fuelQty);
        fuelQty.setRawInputType(Configuration.KEYBOARD_12KEY);
        fuelWeight = (EditText) view.findViewById(R.id.fuelWeight);
        fuelWeight.setRawInputType(Configuration.KEYBOARD_12KEY);

        fuelArm = (EditText) view.findViewById(R.id.fuelArm);
        fuelArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        fuelMoment = (EditText) view.findViewById(R.id.fuelMoment);
        fuelMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        //validateEditText(fuelQty, "This Field cannot be empty!", alertIndicator);
        if(fuelQty.getText() == null){

            // default to 40 gallons
            fuelQty.setText("40");
        }


        calculateButton = (Button) view.findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("onClick","HAHAHAHAHAHAHAHAHAHAHAHAHAHAHA");
                CGGraphFragment fragment = (CGGraphFragment) fragmentManager.findFragmentById(R.id.cg_graph_fragment);//.findFragmentByTag(CG_GRAPH_FRAGMENT_TAG);

                if (fragment == null) {
                    Bundle bundle = new Bundle();
                    //bundle.putString(KEY_MSG_3, "Replace MyFragment3");
                    CGGraphFragment cgGraphFragment = new CGGraphFragment();
                    cgGraphFragment.setArguments(bundle);

                    //fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, cgGraphFragment, CG_GRAPH_FRAGMENT_TAG);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else {
                    Log.d("CG_GRAPH_FRAGMENT_TAG", "CG_GRAPH_FRAGMENT_TAG already loaded");
                    // do whatever here
                }
                //calculateCG();
            }
        });
    }

    /**
     * This method calculates the center of gravity of the plane given the specific model
     *
     * @return cgPoint -the center of gravity
     */
    private PointF calculateCG() {

        // validate all inputs first
        //validateAllInputs();

        PointF cgPoint = new PointF();
        double grossWeight = 0.0;
        double grossMoment = 0.0;
        double cg = 0.0;

        grossWeight += Double.parseDouble(emptyWeight.getText().toString());
        grossWeight += Double.parseDouble(flSeatWeight.getText().toString());
        grossWeight += Double.parseDouble(rlSeatWeight.getText().toString());
        grossWeight += Double.parseDouble(baggageWeight.getText().toString());
        grossWeight += Double.parseDouble(oilQty.getText().toString());
        grossWeight += Double.parseDouble(fuelWeight.getText().toString());

        grossMoment += (Double.parseDouble(emptyWeight.getText().toString()) * Double.parseDouble(emptyArm.getText().toString()));
        grossMoment += (Double.parseDouble(flSeatWeight.getText().toString()) * Double.parseDouble(flSeatArm.getText().toString()));
        grossMoment += (Double.parseDouble(rlSeatWeight.getText().toString()) * Double.parseDouble(rlSeatArm.getText().toString()));
        grossMoment += (Double.parseDouble(baggageWeight.getText().toString()) * Double.parseDouble(baggageArm.getText().toString()));
        grossMoment += (Double.parseDouble(oilQty.getText().toString()) * Double.parseDouble(oilArm.getText().toString()));
        grossMoment += (Double.parseDouble(fuelWeight.getText().toString()) * Double.parseDouble(fuelArm.getText().toString()));

        cg = grossWeight / grossMoment;

        cgPoint.set((float) cg, (float)grossWeight);

        return cgPoint;
    }

    /**
     * This method validates all inputs
     */
    private void validateAllInputs() {

        validateEditText(emptyWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(emptyArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(emptyMoment, "This Field cannot be empty!", alertIndicator);

        validateEditText(flSeatWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(flSeatArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(flSeatMoment, "This Field cannot be empty!", alertIndicator);

        validateEditText(rlSeatWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(rlSeatArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(rlSeatMoment, "This Field cannot be empty!", alertIndicator);

        validateEditText(baggageWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(baggageArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(baggageMoment, "This Field cannot be empty!", alertIndicator);

        validateEditText(oilWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(oilArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(oilMoment, "This Field cannot be empty!", alertIndicator);

        validateEditText(fuelWeight, "This Field cannot be empty!", alertIndicator);
        validateEditText(fuelArm, "This Field cannot be empty!", alertIndicator);
        validateEditText(fuelMoment, "This Field cannot be empty!", alertIndicator);

    }

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnCalculateButtonPressedListener {
        /** Called by WeightAndBalanceFragment when the calculate button is pressed */
        public void onWeightAndBalanceCalculate();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnCalculateButtonPressedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnCalculateButtonPressedListener");
        }
    }



    /**
     * @param edit
     * @param message
     * @param icon
     */
    private void validateEditText(EditText edit, String message, Drawable icon) {
        if (edit.getText() != null && edit.getText().toString().length() == 0) {
            edit.setError(message, icon);
        }
    }

}

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
import android.widget.Toast;

import com.example.efoeakolly.flightkit.NiceSpinner;
import com.example.efoeakolly.flightkit.R;
import com.example.efoeakolly.flightkit.SQLiteHelper;
import com.example.efoeakolly.flightkit.SingleEngineAircraft;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by efoeakolly on 6/9/16.
 */

public class WeightAndBalanceFragment extends Fragment implements Validator.ValidationListener {

    OnCalculateButtonPressedListener mCallback;

    private Spinner choice;

    @NotEmpty @BindView(R.id.emptyWeight)   EditText emptyWeight;
    @NotEmpty @BindView(R.id.emptyArm)      EditText emptyArm;
    @NotEmpty @BindView(R.id.emptyMoment)   EditText emptyMoment;
    @NotEmpty @BindView(R.id.flSeatWeight)  EditText flSeatWeight;
    @NotEmpty @BindView(R.id.flSeatArm)     EditText flSeatArm;
    @NotEmpty @BindView(R.id.flSeatMoment)  EditText flSeatMoment;
    @NotEmpty @BindView(R.id.rlSeatWeight)  EditText rlSeatWeight;
    @NotEmpty @BindView(R.id.rlSeatArm)     EditText rlSeatArm;
    @NotEmpty @BindView(R.id.rlSeatMoment)  EditText rlSeatMoment;
    @NotEmpty @BindView(R.id.baggageWeight) EditText baggageWeight;
    @NotEmpty @BindView(R.id.baggageArm)    EditText baggageArm;
    @NotEmpty @BindView(R.id.baggageMoment) EditText baggageMoment;
    @NotEmpty @BindView(R.id.oilQty)        EditText oilQty;
    @NotEmpty @BindView(R.id.oilWeight)     EditText oilWeight;
    @NotEmpty @BindView(R.id.oilArm)        EditText oilArm;
    @NotEmpty @BindView(R.id.oilMoment)     EditText oilMoment;
    @NotEmpty @BindView(R.id.fuelQty)       EditText fuelQty;
    @NotEmpty @BindView(R.id.fuelWeight)    EditText fuelWeight;
    @NotEmpty @BindView(R.id.fuelArm)       EditText fuelArm;
    @NotEmpty @BindView(R.id.fuelMoment)    EditText fuelMoment;

    @BindDrawable(R.drawable.alert) Drawable alertIndicator;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private static final String CG_GRAPH_FRAGMENT_TAG = "CG_G_FRAG";
    private static final String EMPTY_SPACE = "";
    private ClickListener editTextListener;
    private Validator validator;


    private Button calculateButton;
    private Button resetButton;

    private SingleEngineAircraft sa1;

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.weight_bal_form, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        editTextListener = new ClickListener();
        ButterKnife.bind(this, view);

        //Setup all the components
        setSpinnerContent(view);
        setInputs(view);

        /* Create Validator object to -
         * call the setValidationListener method of Validator class.
         */
        validator = new Validator(this);

        // Call the validation listener method.
        validator.setValidationListener(this);

        return view;
    }

    /**
     * @param view
     */
    private void setSpinnerContent(View view) {

        NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven"));
        niceSpinner.attachDataSource(dataset);

        /*choice = (Spinner) view.findViewById(R.id.choice);
        List<String> dataset = new LinkedList<>(Arrays.asList("Select Your Plane Model", "172N", "172S", "172P", "172RG", "172R-NAV","Six","Seven"));
        ArrayAdapter adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dataset);
        choice.setAdapter(adapter);*/


    }

    /**
     * @param view
     */
    private void setInputs(View view) {

        SQLiteHelper db = new SQLiteHelper(getActivity());
        sa1 = new SingleEngineAircraft("172N", 1489, 38.8, 57773, 11, -14, -147, 37, 12025, 73, 13140, 48, 11520, 95, 5225);
        db.addAircraft(sa1);


        //alertIndicator = ResourcesCompat.getDrawable(getResources(), R.drawable.alert, null);
        //emptyWeight = (EditText) view.findViewById(R.id.emptyWeight);
        emptyWeight.setOnClickListener(editTextListener);
        emptyWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        //emptyArm = (EditText) view.findViewById(R.id.emptyArm);
        emptyArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //emptyMoment = (EditText) view.findViewById(R.id.emptyMoment);
        emptyMoment.setRawInputType(Configuration.KEYBOARD_12KEY);


        //flSeatWeight = (EditText) view.findViewById(R.id.flSeatWeight);
        flSeatWeight.setOnClickListener(editTextListener);
        flSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        //flSeatArm = (EditText) view.findViewById(R.id.flSeatArm);
        flSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //flSeatMoment = (EditText) view.findViewById(R.id.flSeatMoment);
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

        //rlSeatWeight = (EditText) view.findViewById(R.id.rlSeatWeight);
        rlSeatWeight.setOnClickListener(editTextListener);
        //rlSeatWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        rlSeatArm = (EditText) view.findViewById(R.id.rlSeatArm);
        rlSeatArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //rlSeatMoment = (EditText) view.findViewById(R.id.rlSeatMoment);
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

        //baggageWeight = (EditText) view.findViewById(R.id.baggageWeight);
        baggageWeight.setOnClickListener(editTextListener);
        baggageWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        //baggageArm = (EditText) view.findViewById(R.id.baggageArm);
        baggageArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //baggageMoment = (EditText) view.findViewById(R.id.baggageMoment);
        baggageMoment.setRawInputType(Configuration.KEYBOARD_12KEY);


        //oilQty = (EditText) view.findViewById(R.id.oilQty);
        oilQty.setOnClickListener(editTextListener);
        oilQty.setRawInputType(Configuration.KEYBOARD_12KEY);
        //oilWeight = (EditText) view.findViewById(R.id.oilWeight);
        oilWeight.setOnClickListener(editTextListener);
        oilWeight.setRawInputType(Configuration.KEYBOARD_12KEY);
        //oilArm = (EditText) view.findViewById(R.id.oilArm);
        oilArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //oilMoment = (EditText) view.findViewById(R.id.oilMoment);
        oilMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        //validateEditText(oilQty, "This Field cannot be empty!", alertIndicator);
        if (oilQty.getText() == null) {

            // default to 6 qt
            oilQty.setText("6");
        }


        //fuelQty = (EditText) view.findViewById(R.id.fuelQty);
        fuelQty.setOnClickListener(editTextListener);
        fuelQty.setRawInputType(Configuration.KEYBOARD_12KEY);
        //fuelWeight = (EditText) view.findViewById(R.id.fuelWeight);
        fuelWeight.setOnClickListener(editTextListener);
        fuelWeight.setRawInputType(Configuration.KEYBOARD_12KEY);

        //fuelArm = (EditText) view.findViewById(R.id.fuelArm);
        fuelArm.setRawInputType(Configuration.KEYBOARD_12KEY);
        //fuelMoment = (EditText) view.findViewById(R.id.fuelMoment);
        fuelMoment.setRawInputType(Configuration.KEYBOARD_12KEY);

        //validateEditText(fuelQty, "This Field cannot be empty!", alertIndicator);
        if (fuelQty.getText() == null) {

            // default to 40 gallons
            fuelQty.setText("40");
        }


        calculateButton = (Button) view.findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();

                CGGraphFragment fragment = (CGGraphFragment) fragmentManager.findFragmentById(R.id.cg_graph_fragment);//.findFragmentByTag(CG_GRAPH_FRAGMENT_TAG);

                if (fragment == null) {
                    Bundle bundle = new Bundle();
                    //bundle.putString(KEY_MSG_3, "Replace MyFragment3");
                    CGGraphFragment cgGraphFragment = new CGGraphFragment();
                    cgGraphFragment.setArguments(bundle);

                    //fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, cgGraphFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else {
                    Log.d("CG_GRAPH_FRAGMENT_TAG", "CG_GRAPH_FRAGMENT_TAG already loaded");
                    // do whatever here
                }
                //calculateCG();
            }
        });

        resetButton = (Button) view.findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view1) {
                clearAllFields();
            }
        });
    }

    private void clearAllFields() {

        if (emptyWeight != null) {
            emptyWeight.setText(emptyWeight.getHint());
        }

        if (flSeatWeight != null) {
            flSeatWeight.setText(EMPTY_SPACE);
        }

        if (rlSeatWeight != null) {
            rlSeatWeight.setText(EMPTY_SPACE);
        }

        if (baggageWeight != null) {
            baggageWeight.setText(EMPTY_SPACE);
        }

        if (oilQty != null) {
            oilQty.setText(oilQty.getHint());
        }

        if (oilWeight != null) {
            oilWeight.setText(EMPTY_SPACE);
        }

        if (fuelQty != null) {
            fuelQty.setText(fuelQty.getHint());
        }

        if (fuelWeight != null) {
            fuelWeight.setText(EMPTY_SPACE);
        }
    }

    /**
     * This method calculates the center of gravity of the plane given the specific model
     *
     * @return cgPoint -the center of gravity
     */
    private PointF calculateCG() {

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

        cgPoint.set((float) cg, (float) grossWeight);

        return cgPoint;
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        }
    }


    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnCalculateButtonPressedListener {
        /**
         * Called by WeightAndBalanceFragment when the calculate button is pressed
         */
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






    private class ClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            if (v instanceof EditText) {
                ((EditText) v).setText("");
            }
        }
    }

}

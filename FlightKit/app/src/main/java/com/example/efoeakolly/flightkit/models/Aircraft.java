package com.example.efoeakolly.flightkit.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by efoeakolly on 6/15/16.
 */


public class Aircraft {

    @Attribute
    private String model;

    @Element
    private EmptyWeight emptyWeight;

    @Element
    private FrontSeat frontSeat;

    @Element
    private RearSeat rearSeat;

    @Element
    private Fuel fuel;

    @Element
    private Baggage baggage;

    @Element
    private Oil oil;

    @Element
    private double maneuvringSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EmptyWeight getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(EmptyWeight emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public FrontSeat getFrontSeat() {
        return frontSeat;
    }

    public void setFrontSeat(FrontSeat frontSeat) {
        this.frontSeat = frontSeat;
    }

    public RearSeat getRearSeat() {
        return rearSeat;
    }

    public void setRearSeat(RearSeat rearSeat) {
        this.rearSeat = rearSeat;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    public Oil getOil() {
        return oil;
    }

    public void setOil(Oil oil) {
        this.oil = oil;
    }

    public double getManeuvringSpeed() {
        return maneuvringSpeed;
    }

    public void setManeuvringSpeed(double maneuvringSpeed) {
        this.maneuvringSpeed = maneuvringSpeed;
    }
}

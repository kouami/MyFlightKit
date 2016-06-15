package com.example.efoeakolly.flightkit.models;

/**
 * Created by efoeakolly on 6/15/16.
 */

public class Aircraft {

    private String model;
    private EmptyWeight emptyWeight;
    private FrontSeat frontSeat;
    private RearSeat rearSeat;
    private Fuel fuel;
    private Oil oil;
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

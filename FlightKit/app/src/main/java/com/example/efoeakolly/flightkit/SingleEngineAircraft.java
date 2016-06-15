package com.example.efoeakolly.flightkit;

/**
 * Created by efoeakolly on 6/8/16.
 */

public class SingleEngineAircraft {

    protected int id;

    protected String aircraftModel;

    protected double emptyWeight;
    protected double weightArm;
    protected double weightMoment;

    protected double oilWeight;
    protected double oilArm;
    protected double oilMoment;

    protected double frontSeatsArm;
    protected double frontSeatsMoment;

    protected double rearSeatsArm;
    protected double rearSeatsMoment;

    protected double fuelArm;
    protected double fuelMoment;

    protected double baggageArm;
    protected double baggageMoment;

    public SingleEngineAircraft(){}

    public SingleEngineAircraft(String aircraftModel, double emptyWeight, double weightArm, double weightMoment, double oilWeight, double oilArm, double oilMoment, double frontSeatsArm, double frontSeatsMoment, double rearSeatsArm, double rearSeatsMoment, double fuelArm, double fuelMoment, double baggageArm, double baggageMoment) {
        this.aircraftModel = aircraftModel;
        this.emptyWeight = emptyWeight;
        this.weightArm = weightArm;
        this.weightMoment = weightMoment;
        this.oilWeight = oilWeight;
        this.oilArm = oilArm;
        this.oilMoment = oilMoment;
        this.frontSeatsArm = frontSeatsArm;
        this.frontSeatsMoment = frontSeatsMoment;
        this.rearSeatsArm = rearSeatsArm;
        this.rearSeatsMoment = rearSeatsMoment;
        this.fuelArm = fuelArm;
        this.fuelMoment = fuelMoment;
        this.baggageArm = baggageArm;
        this.baggageMoment = baggageMoment;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getAircraftModel() {
        return aircraftModel;
    }

    /**
     * @param aircraftModel
     */
    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    /**
     * @return
     */
    public double getEmptyWeight() {
        return emptyWeight;
    }

    /**
     * @param emptyWeight
     */
    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    /**
     * @return
     */
    public double getWeightArm() {
        return weightArm;
    }

    /**
     * @param weightArm
     */
    public void setWeightArm(double weightArm) {
        this.weightArm = weightArm;
    }

    /**
     * @return
     */
    public double getWeightMoment() {
        return weightMoment;
    }

    /**
     * @param weightMoment
     */
    public void setWeightMoment(double weightMoment) {
        this.weightMoment = weightMoment;
    }

    /**
     * @return
     */
    public double getOilWeight() {
        return oilWeight;
    }

    /**
     * @param oilWeight
     */
    public void setOilWeight(double oilWeight) {
        this.oilWeight = oilWeight;
    }

    /**
     * @return
     */
    public double getOilArm() {
        return oilArm;
    }

    /**
     * @param oilArm
     */
    public void setOilArm(double oilArm) {
        this.oilArm = oilArm;
    }

    /**
     * @return
     */
    public double getOilMoment() {
        return oilMoment;
    }

    /**
     * @param oilMoment
     */
    public void setOilMoment(double oilMoment) {
        this.oilMoment = oilMoment;
    }

    /**
     * @return
     */
    public double getFrontSeatsArm() {
        return frontSeatsArm;
    }

    /**
     * @param frontSeatsArm
     */
    public void setFrontSeatsArm(double frontSeatsArm) {
        this.frontSeatsArm = frontSeatsArm;
    }

    /**
     * @return
     */
    public double getFrontSeatsMoment() {
        return frontSeatsMoment;
    }

    /**
     * @param frontSeatsMoment
     */
    public void setFrontSeatsMoment(double frontSeatsMoment) {
        this.frontSeatsMoment = frontSeatsMoment;
    }

    /**
     * @return
     */
    public double getRearSeatsArm() {
        return rearSeatsArm;
    }

    /**
     * @param rearSeatsArm
     */
    public void setRearSeatsArm(double rearSeatsArm) {
        this.rearSeatsArm = rearSeatsArm;
    }

    /**
     * @return
     */
    public double getRearSeatsMoment() {
        return rearSeatsMoment;
    }

    /**
     * @param rearSeatsMoment
     */
    public void setRearSeatsMoment(double rearSeatsMoment) {
        this.rearSeatsMoment = rearSeatsMoment;
    }

    /**
     * @return
     */
    public double getFuelArm() {
        return fuelArm;
    }

    /**
     * @param fuelArm
     */
    public void setFuelArm(double fuelArm) {
        this.fuelArm = fuelArm;
    }

    /**
     * @return
     */
    public double getFuelMoment() {
        return fuelMoment;
    }

    /**
     * @param fuelMoment
     */
    public void setFuelMoment(double fuelMoment) {
        this.fuelMoment = fuelMoment;
    }

    /**
     * @return
     */
    public double getBaggageArm() {
        return baggageArm;
    }

    /**
     * @param baggageArm
     */
    public void setBaggageArm(double baggageArm) {
        this.baggageArm = baggageArm;
    }

    /**
     * @return
     */
    public double getBaggageMoment() {
        return baggageMoment;
    }

    /**
     * @param baggageMoment
     */
    public void setBaggageMoment(double baggageMoment) {
        this.baggageMoment = baggageMoment;
    }
}

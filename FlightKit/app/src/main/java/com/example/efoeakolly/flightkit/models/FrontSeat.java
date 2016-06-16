package com.example.efoeakolly.flightkit.models;

import org.simpleframework.xml.Element;

/**
 * Created by efoeakolly on 6/15/16.
 */

public class FrontSeat {

    @Element
    private double arm;

    @Element
    private double moment;

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getMoment() {
        return moment;
    }

    public void setMoment(double moment) {
        this.moment = moment;
    }
}

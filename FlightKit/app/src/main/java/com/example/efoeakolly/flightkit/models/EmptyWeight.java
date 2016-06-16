package com.example.efoeakolly.flightkit.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by efoeakolly on 6/15/16.
 */

public class EmptyWeight {

    @Element
    private double arm;

    @Element
    private double moment;

    @Attribute
    private double weight;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

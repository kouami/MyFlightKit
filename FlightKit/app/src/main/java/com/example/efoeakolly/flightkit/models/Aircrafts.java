package com.example.efoeakolly.flightkit.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by efoeakolly on 6/15/16.
 */
@Root
public class Aircrafts {

    @ElementList
    private List<Aircraft> list;

    public List<Aircraft> getList() {
        return list;
    }

    public void setList(List<Aircraft> list) {
        this.list = list;
    }
}

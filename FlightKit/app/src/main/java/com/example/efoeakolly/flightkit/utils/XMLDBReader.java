package com.example.efoeakolly.flightkit.utils;

import android.content.Context;
import android.util.Log;

import com.example.efoeakolly.flightkit.R;
import com.example.efoeakolly.flightkit.models.Aircrafts;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.InputStream;

/**
 * Created by efoeakolly on 6/15/16.
 */

public class XMLDBReader {

    private static Serializer serializer;
    private static File xmlDBFile;
    private static final String DB_FILE_LOCATION = "raw/aircrafts.xml";
    private static Aircrafts aircrafts;

    /**
     *
     * @param c
     */
    private XMLDBReader(Context c){
        InputStream xmlDBFile = c.getResources().openRawResource(R.raw.aircrafts);
        serializer = new Persister();
        try {
            aircrafts = serializer.read(Aircrafts.class, xmlDBFile);
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }

    /**
     *
     * @return
     */
    public static Aircrafts getAircrafts(){
        return aircrafts;
    }
}

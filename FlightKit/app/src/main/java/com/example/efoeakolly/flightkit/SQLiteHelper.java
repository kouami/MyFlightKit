package com.example.efoeakolly.flightkit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by efoeakolly on 6/8/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AircraftDB";
    private static final String TABLE_AIRCRAFT = "aircraft";

    private static final String ID = "id";
    private static final String MODEL = "model";
    private static final String EMPTY_WEIGHT = "emptyWeight";
    private static final String WEIGHT_ARM = "weightArm";
    private static final String WEIGHT_MOMENT = "weightMoment";
    private static final String OIL_WEIGHT = "oilWeight";
    private static final String OIL_ARM = "oilArm";
    private static final String OIL_MOMENT = "oilMoment";
    private static final String F_SEATS_ARM = "frontSeatsArm";
    private static final String F_SEATS_MOMENT = "frontSeatsMoment";
    private static final String R_SEATS_ARM = "rearSeatsArm";
    private static final String R_SEATS_MOMENT = "rearSeatsMoment";
    private static final String FUEL_ARM = "fuelArm";
    private static final String FUEL_MOMENT = "fuelMoment";
    private static final String BAGGAGE_ARM = "baggageArm";
    private static final String BAGGAGE_MOMENT = "baggageMoment";


    private static final String[] COLUMNS = {ID, MODEL, EMPTY_WEIGHT, WEIGHT_ARM, WEIGHT_MOMENT, OIL_WEIGHT, OIL_ARM, OIL_MOMENT,
            F_SEATS_ARM, F_SEATS_MOMENT, R_SEATS_ARM, R_SEATS_MOMENT, FUEL_ARM, FUEL_MOMENT, BAGGAGE_ARM, BAGGAGE_MOMENT};

    private static void init(){

    }

    /**
     * @param context
     */
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * @param aircraft
     */
    public void addAircraft(SingleEngineAircraft aircraft) {
        Log.d("addAircraft", aircraft.toString());

        // 1. Get a reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Create ContentValues to add key "column" value
        ContentValues values = new ContentValues();
        values.put(MODEL, aircraft.getAircraftModel());
        values.put(EMPTY_WEIGHT, aircraft.getEmptyWeight());
        values.put(WEIGHT_ARM, aircraft.getWeightArm());
        values.put(WEIGHT_MOMENT, aircraft.getWeightMoment());
        values.put(OIL_WEIGHT, aircraft.getOilWeight());
        values.put(OIL_ARM, aircraft.getOilArm());
        values.put(OIL_MOMENT, aircraft.getOilMoment());
        values.put(F_SEATS_ARM, aircraft.getFrontSeatsArm());
        values.put(F_SEATS_MOMENT, aircraft.getFrontSeatsMoment());
        values.put(R_SEATS_ARM, aircraft.getRearSeatsArm());
        values.put(R_SEATS_MOMENT, aircraft.getRearSeatsMoment());
        values.put(FUEL_ARM, aircraft.getFuelArm());
        values.put(FUEL_MOMENT, aircraft.getFuelMoment());
        values.put(BAGGAGE_ARM, aircraft.getBaggageArm());
        values.put(BAGGAGE_MOMENT, aircraft.getBaggageMoment());

        // 3. Insert
        db.insert(TABLE_AIRCRAFT, null, values);

        // 4. close
        db.close();
    }

    /**
     * @param id
     * @return
     */
    public SingleEngineAircraft getAircraft(int id) {

        // 1. get a reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.query(TABLE_AIRCRAFT, COLUMNS, " id = ?", new String[]{String.valueOf(id)},
                null, // group by
                null, // having
                null, // order by
                null); // limit
        // 3. if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();
        }

        // 4. build aircraft object
        SingleEngineAircraft aircraft = new SingleEngineAircraft();
        aircraft.setId(Integer.parseInt(cursor.getString(0)));
        aircraft.setAircraftModel(cursor.getString(1));
        aircraft.setEmptyWeight(cursor.getDouble(2));
        aircraft.setWeightArm(cursor.getDouble(3));
        aircraft.setWeightMoment(cursor.getDouble(4));
        aircraft.setOilWeight(cursor.getDouble(5));
        aircraft.setOilArm(cursor.getDouble(6));
        aircraft.setOilMoment(cursor.getDouble(7));
        aircraft.setFrontSeatsArm(cursor.getDouble(8));
        aircraft.setFrontSeatsMoment(cursor.getDouble(9));
        aircraft.setRearSeatsArm(cursor.getDouble(10));
        aircraft.setRearSeatsMoment(cursor.getDouble(11));
        aircraft.setFuelArm(cursor.getDouble(12));
        aircraft.setFuelMoment(cursor.getDouble(13));
        aircraft.setBaggageArm(cursor.getDouble(14));
        aircraft.setBaggageMoment(cursor.getDouble(15));

        Log.d("getAircraft(" + id + ")", aircraft.toString());

        // 5. return aircraft
        return aircraft;
    }

    /**
     * @return
     */
    public List<SingleEngineAircraft> getAllAircraft() {

        List<SingleEngineAircraft> aircrafts = new LinkedList<>();

        String query = "SELECT * FROM " + TABLE_AIRCRAFT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        SingleEngineAircraft aircraft = null;
        if (cursor.moveToFirst()) {
            do {
                aircraft = new SingleEngineAircraft();
                aircraft.setId(Integer.parseInt(cursor.getString(0)));
                aircraft.setAircraftModel(cursor.getString(1));
                aircraft.setEmptyWeight(cursor.getDouble(2));
                aircraft.setWeightArm(cursor.getDouble(3));
                aircraft.setWeightMoment(cursor.getDouble(4));
                aircraft.setOilWeight(cursor.getDouble(5));
                aircraft.setOilArm(cursor.getDouble(6));
                aircraft.setOilMoment(cursor.getDouble(7));
                aircraft.setFrontSeatsArm(cursor.getDouble(8));
                aircraft.setFrontSeatsMoment(cursor.getDouble(9));
                aircraft.setRearSeatsArm(cursor.getDouble(10));
                aircraft.setRearSeatsMoment(cursor.getDouble(11));
                aircraft.setFuelArm(cursor.getDouble(12));
                aircraft.setFuelMoment(cursor.getDouble(13));
                aircraft.setBaggageArm(cursor.getDouble(14));
                aircraft.setBaggageMoment(cursor.getDouble(15));

            } while (cursor.moveToNext());

        }
        return aircrafts;
    }

    /**
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Aircraft table
        String CREATE_AIRCRAFT_TABLE = "CREATE TABLE aircraft ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "model TEXT, " +
                "emptyWeight REAL, " +
                "weightArm REAL, " +
                "weightMoment REAL, " +
                "oilWeight REAL, " +
                "oilArm REAL, " +
                "oilMoment REAL, " +
                "frontSeatsArm REAL, " +
                "frontSeatsMoment REAL, " +
                "rearSeatsArm REAL, " +
                "rearSeatsMoment REAL, " +
                "fuelArm REAL, " +
                "fuelMoment REAL, " +
                "baggageArm REAL, " +
                "baggageMoment REAL )";

        db.execSQL(CREATE_AIRCRAFT_TABLE);
    }

    /**
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older aircrafts table if existed
        db.execSQL("CREATE TABLE IF NOT EXISTS aircraft");

        // create fresh aircraft table
        this.onCreate(db);
    }
}

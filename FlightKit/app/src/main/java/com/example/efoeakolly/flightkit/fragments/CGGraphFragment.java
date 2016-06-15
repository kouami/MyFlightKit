package com.example.efoeakolly.flightkit.fragments;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.efoeakolly.flightkit.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;


/**
 * Created by efoeakolly on 6/9/16.
 */

public class CGGraphFragment extends Fragment {

    private static String TITLE = "Weight & Balance Graph";
    private static final String[] cgValues = {"34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};
    private static final String[] grossWeightValues = {"1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300","2400"};

    private GraphView graph;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cg_graph, container, false);
        initGraph(v);
        return v;
    }

    /**
     *
     * @param view
     */
    private void initGraph(View view){
        graph = (GraphView) view.findViewById(R.id.graph);
        graph.setTitleTextSize(30f);
        graph.getGridLabelRenderer().setTextSize(20f);
        graph.getGridLabelRenderer().reloadStyles();

        graph.setTitle(TITLE);

        StaticLabelsFormatter labels = new StaticLabelsFormatter(graph);
        labels.setHorizontalLabels(cgValues);
        labels.setVerticalLabels(grossWeightValues);


        graph.getViewport().setBackgroundColor(Color.LTGRAY);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(34);
        graph.getViewport().setMaxX(48);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(1400);
        graph.getViewport().setMaxY(2400);

        graph.getGridLabelRenderer().setLabelsSpace(5);

        LineGraphSeries<DataPoint> cgEnvelop = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(35,1400),
                new DataPoint(35,1950),
                new DataPoint(38.5,2300),
                new DataPoint(47.3, 2300),
                new DataPoint(47.3,1400)
        });

        //cgEnvelop.setBackgroundColor(R.drawable.gradient_green);
        cgEnvelop.setDrawBackground(true);
        graph.addSeries(cgEnvelop);

        LineGraphSeries<DataPoint> utilityCategory = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(35.5, 2000),
                new DataPoint(40.5, 2000),
                new DataPoint(40.5, 1400)

        });

        graph.addSeries(utilityCategory);
        plotCGPoint(new PointF(36.0f, 1500.0f));
    }

    public void plotCGPoint(PointF cgp){
        PointsGraphSeries<DataPoint> cgPoint = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(cgp.x, cgp.y)
        });

        cgPoint.setColor(Color.RED);
        //cgPoint.setShape(PointsGraphSeries.Shape.TRIANGLE);

        cgPoint.setCustomShape(new PointsGraphSeries.CustomShape() {
            @Override
            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setStrokeWidth(5);
                canvas.drawLine(x - 5, y - 5, x + 5, y + 5, paint);
                canvas.drawLine(x + 5, y - 5, x - 5, y + 5, paint);
            }
        });
        graph.addSeries(cgPoint);
    }

}

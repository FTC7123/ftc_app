package org.firstinspires.ftc.teamcode.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thomaslauer on 12/27/17.
 */

public class MovingAverage {

    private List<Double> data;

    public MovingAverage(int nVals) {
        data = new ArrayList<>(Collections.nCopies(nVals, 0d));
    }

    public void addValue(double x) {
        data.add(x);
        data.remove(0);
    }

    public double getAverage() {
        double sum = 0;
        for(double d : data) {
            sum += d;
        }
        return sum / data.size();
    }

    public void clear() {
        data = new ArrayList<>(Collections.nCopies(data.size(), 0d));
    }
}

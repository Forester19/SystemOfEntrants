package phisics;

import java.util.ArrayList;

/**
 * Created by Владислав on 03.09.2017.
 */
public class MyFunction {
    double time;

    double someCoef = 0.1;

    ArrayList<Double> list = new ArrayList<Double>();
    final double T1 = 98;
    final double T2 = 25;

    public MyFunction() {

    }

    public Double calculFunc() {
        double constValue = T1;
        for (double i=0; i<30 ;i++) {
            double gfunc =  someCoef * (constValue - T2);
            constValue = constValue - gfunc * i;
            list.add(constValue);

        }
        return constValue;
    }




}

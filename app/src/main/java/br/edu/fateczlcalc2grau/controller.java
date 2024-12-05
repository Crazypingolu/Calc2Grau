package br.edu.fateczlcalc2grau;

import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
public class controller {


    public float calcDelta(float numA, float numB, float numC) {
        float total = (float)Math.pow(numB, 2) - 4 * numA * numC;
        return total;
    }

    public float calcRaiz(float delta, float nA, float nB, boolean tipo) {
        float total;
        if (!tipo) {
            total = ((-1 * nB) - ((float) Math.sqrt(delta)) / (2 * nA));
        } else {
            total = ((-1 * nB) + ((float) Math.sqrt(delta)) / (2 * nA));
        }
        return total;
    }
}

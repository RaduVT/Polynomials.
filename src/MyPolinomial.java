import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class MyPolinomial {
    private double[] coeffs;
    String filename;
    int Degreen;


    public MyPolinomial(double... coeffs) {
        for (int i = 0; i < coeffs.length; i++){
            this.coeffs = coeffs;
        }
    }

    public MyPolinomial (String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int degree = in.nextInt();
        coeffs = new double[degree + 1];
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = in.nextDouble();
        }
    }

    public int getDegree() {
        int degree;
        return degree = coeffs.length - 1;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < coeffs.length; i++){
            if (i > 0) {
                if (i < coeffs.length - 1 && coeffs[i+1] >= 0) {
                    s = " + " + s;
                }
                if (i == 1) {
                    s = "x" + s;
                } else {
                    s = "x^" + i + s;
                }
            }
            s = Math.abs(coeffs[i]) + s;
            if (coeffs[i] >= 0 && i < coeffs.length - 1) {
                s = " + " + s;
            } else {
                if (coeffs[i] < 0) {
                    s = " - " + s;
                }
            }
        }
        return s;
    }

    public double evaluate(double x) {
        double accum = 0;
        for (int i = 1; i < coeffs.length; i++) {
            accum += coeffs[i] * Math.pow(x, i);
        }
        return accum;
    }

    public MyPolinomial add(MyPolinomial poly) {
        MyPolinomial polyResult;
        double[] result;
        int degree = getDegree();
        if (poly.getDegree() > degree) {
            degree = poly.getDegree();
        }
        result = new double[degree + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < coeffs.length;i++) {
            result[i] = coeffs[i];
        }
        for (int i = 0; i < poly.coeffs.length; i++) {
            result[i] += poly.coeffs[i];
        }
        polyResult = new MyPolinomial(result);

        return polyResult;
    }
}



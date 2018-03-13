import java.io.*;
import java.util.Scanner;

public class Main {

    static double sumX;
    static double sumY;
    static double sumXY;
    static double ssX;
    static double ssXY;
    static double slope_b1;
    static double yIntercept_b0;

    // Ex^2 - ((Ex)^2) / n =
    static void findSSx(int x[]) {

        int summation1 = 0,summation2 = 0;

        for (int i = 0; i < x.length; i++) {
            summation1 += Math.pow(x[i],2);
        }

        for (int i = 0; i < x.length; i++) {
            summation2 += x[i];
        }
        summation2 = (int)Math.pow(summation2,2);

        ssX = summation1 - (summation2 / x.length);
    }

    // Exy - Ex*Ey / n =
    static void findSSxy(int x[], int y[]) {

        for (int i = 0; i < x.length; i++) {
            sumXY += (x[i] * y[i]);
            sumX += x[i];
            sumY += y[i];
        }
        ssXY = sumXY - ((sumX * sumY) / x.length);
    }

    static void find_slope_b1(double ssXY, double ssX) {
        slope_b1 = ssXY / ssX;
    }

    static void find_yIntercept_b0() {
        yIntercept_b0 = (sumY - (slope_b1 * sumX)) / 10;
    }

    void whatIsTheEquation() {
        System.out.printf("y = %.2f + %.2fx",yIntercept_b0,slope_b1);
    }

    public static void main(String [] args) throws FileNotFoundException {

        // Calculate the Line of Best Fit (Linear Regression)

        int heightX[] = {65,65,62,67,69,65,61,67,68,63};
        int weightY[] = {105,125,110,120,140,135,95,130,133,112};

        Main obj = new Main();

        findSSx(heightX);
        findSSxy(heightX,weightY);
        find_slope_b1(ssXY,ssX);
        find_yIntercept_b0();

        obj.whatIsTheEquation();

    }
}

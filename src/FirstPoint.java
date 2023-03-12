import java.util.ArrayList;

public class FirstPoint {

    public static double average(ArrayList<Double> arr){
        double res = 0;
        for(double elem : arr) res += elem;
        return res / arr.size();
    }

    public static double dispersion(double average, ArrayList<Double> arr){
        double res = 0;
        for(double elem : arr) res += Math.pow(elem - average,2);
        return res / arr.size();
    }
}

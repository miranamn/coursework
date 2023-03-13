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

    public static double correlationF(int m, ArrayList<Double> arr){
        if (m < 0) m *= -1;
        ArrayList<Double> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        double res = 0;
        for(int i = 0; i < arr.size() - m; i++){
            arr1.add(arr.get(i));
            arr2.add(arr.get(i + m));
        }
        double arr1Av = average(arr1);
        double arr2Av = average(arr2);
        for(int i = 0; i < arr.size() - m; i++) res += (arr1.get(i) - arr1Av) * (arr2.get(i) - arr2Av);
        return res / (arr.size() - m);
    }

    public static double NCF(int m, ArrayList<Double> arr){
        if (m < 0) m *= -1;
        ArrayList<Double> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        for(int i = 0; i < arr.size() - m; i++){
            arr1.add(arr.get(i));
            arr2.add(arr.get(i + m));
        }
        double arr1D = dispersion(average(arr1), arr1);
        double arr2D = dispersion(average(arr2), arr2);
        double corr = correlationF(m, arr);
        return corr / Math.sqrt(arr1D * arr2D);
    }
}

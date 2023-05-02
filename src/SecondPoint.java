import java.util.ArrayList;

import static java.lang.Math.pow;

public class SecondPoint {
    public static ArrayList<Double> solveAR (ArrayList<Double> CF, int order){
        ArrayList<Double> params = new ArrayList<>();
        double b1, a0, b2, b3;
        switch (order){
            case 0:
                params.add(Math.sqrt(CF.get(order)));
                break;
            case 1:
                b1 = CF.get(order)/CF.get(order - 1);
                a0 = Math.sqrt(CF.get(order - 1) - b1 * CF.get(order));
                params.add(a0);
                params.add(b1);
                break;
            case 2:
                b2 = (pow(CF.get(order - 1), 2) - CF.get(order - 2) * CF.get(order)) /
                        (pow(CF.get(order - 1), 2) - pow(CF.get(order - 2), 2));
                b1 = (CF.get(order - 1) - b2 * CF.get(order - 1)) / CF.get(order - 2);
                a0 = Math.sqrt(CF.get(order - 2) - b2 * CF.get(order) - b1 * CF.get(order - 1));
                params.add(a0);
                params.add(b1);
                params.add(b2);
                break;
        }
        return params;
    }
    public static double[] theoryNCF(ArrayList<Double> NCF, int M, int N){
        double[] beta = {0.78209, 0, 0, 0.49272, 0.37, 0, 0.48347, 0.35767, 0.02501};
        double[] theoryNCF = new double[11];
        double sum;
        for (int i = 0; i <= M; i++) theoryNCF[i] = NCF.get(i);
        for(int i = M + 1; i < 11; i++){
            sum = 0.0;
            for(int j = 0; j < M; j++){
                sum += beta[j] * theoryNCF[i-j-1];
            }
            theoryNCF[i] = sum;
        }
        return theoryNCF;
    }

    public static  double epsAR(ArrayList<Double> NCF, double[] theoryNCF){
        double eps = 0;
        for(int i = 1; i <= 10; i++) {
            eps += pow(theoryNCF[i] - NCF.get(i), 2);
        }
        return eps;
    }
}

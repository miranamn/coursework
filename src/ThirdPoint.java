import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.pow;

public  class ThirdPoint {

    public static void ARMA(ArrayList<Double> NCF){
        double[][] beta = {{0, 0, 0, 0 },
                {0, 0.9658, 0, 0},
                {0, 0.8869, 0, 0},
                {0, 0.8050, 0, 0},

                {0, 0.5511,	0.32437, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},

                {0, 0, 0, 0},
                {0, 0.3640,	-0.0939, 0.4684},
                {0, -0.0384, 0.6336, 0.1105}};
        System.out.println("_____________________МОДЕЛИ АРСС_____________________");
        int count = 1;
        double[] ncf;
        for(int m = 1; m < 4; m++){
            for(int n = 1; n < 4; n++){
                System.out.print("M = " + m + " N = " + n + " tncf = ");
                ncf =  theoryNCF(NCF, beta[count], m, n);
                for (int i = 0; i < 11; i++){
                    System.out.print(ncf[i] + " ");

                }
                System.out.println("");
                count++;
            }
            System.out.println("______________________");
        }
    }
    public static double[] theoryNCF(ArrayList<Double> NCF, double[] beta, int M, int N){
        double[] theoryNCF = new double[11];
        for (int i = 0; i < 11; i++){
            if (i <= M + N) theoryNCF[i] = NCF.get(i);
            else{
                for(int j = 1; j <= M; j++){
                    theoryNCF[i] += beta[j] * theoryNCF[i-j];
                }
            }
        }
        return theoryNCF;
    }
    public static  double epsARMA(ArrayList<Double> NCF, double[] theoryNCF){
        double eps = 0;
        for(int i = 1; i < 11; i++) {
            eps += pow(theoryNCF[i] - NCF.get(i), 2);
        }
        return eps;
    }
}

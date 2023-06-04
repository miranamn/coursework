import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.sqrt;

public class BestModels {
    public static void AR3(double M){
        System.out.println("_____________________МОДЕЛИРОВАНИЕ АР(3)_____________________");
        double[] arr0 = new double[6000];
        ArrayList<Double> arr = new ArrayList<>();
        double[] beta = {0.0, 0.48347,	0.35767,	0.02501};
        double[] a = {10.97842, 0.0, 0.0, 0.0};
        double[] E = new double[6000];;
        Random r = new Random();
        for (int i = 3; i < arr0.length; i++){
            E[i] = r.nextGaussian();
            arr0[i] = beta[1] * arr0[i - 1] + beta[2] * arr0[i - 2] + beta[3] * arr0[i - 3] + a[0] * E[i] +
                    (1 - (beta[1] + beta[2] + beta[3])) * M;
        }
        try {
            FileWriter fileWriter = new FileWriter("AR3_MODEL.TXT", false);
            for (int i = 1000; i < arr0.length; i++){
                arr.add(arr0[i]);
                fileWriter.write(Double.toString(arr0[i]));
                fileWriter.append('\n');
            }
            double avg = FirstPoint.average(arr);
            System.out.println("_average_ " + avg);
            double dispersion = FirstPoint.dispersion(avg, arr);
            System.out.println("_dispersion_ " + dispersion);
            System.out.println("_ско_ " + sqrt(dispersion));
            ArrayList<Double> NCF = new ArrayList<>();

            for(int i = 0; i < 11; i ++){
                NCF.add(FirstPoint.NCF(i, arr));
            }
            System.out.println( "____TCF___- ");
            double[] TCF = ThirdPoint.theoryNCF(NCF, beta, 2,0);
            for(int i = 0; i < TCF.length; i ++){
                System.out.println(TCF[i] + " ");
            }
            System.out.println( "____NCF___- ");
            for (double elem : NCF) System.out.println(elem + " ");
            System.out.println( "___eps_____ " + SecondPoint.epsAR(NCF, TCF));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void CC0(double M){
        System.out.println("_____________________МОДЕЛИРОВАНИЕ CC(0)_____________________");
        double[] arr0 = new double[6000];
        ArrayList<Double> arr = new ArrayList<>();
        double[] beta = {0.0, 0.0, 0.0, 0.0};
        double[] a = {18.9706, 0.0, 0.0, 0.0};
        double[] E = new double[6000];
        Random r = new Random();
        for (int i = 0; i < arr0.length; i++){
            E[i] = r.nextGaussian();
            arr0[i] = a[0] * E[i] + M;
        }
        try {
            FileWriter fileWriter = new FileWriter("CC0_MODEL.TXT", false);
            for (int i = 1000; i < arr0.length; i++){
                arr.add(arr0[i]);
                fileWriter.write(Double.toString(arr0[i]));
                fileWriter.append('\n');
            }
            double avg = FirstPoint.average(arr);
            System.out.println("_average_ " + avg);
            double dispersion = FirstPoint.dispersion(avg, arr);
            System.out.println("_dispersion_ " + dispersion);
            System.out.println("_ско_ " + sqrt(dispersion));
            ArrayList<Double> NCF = new ArrayList<>();

            for(int i = 0; i < 11; i ++){
                NCF.add(FirstPoint.NCF(i, arr));
            }
            System.out.println( "_____TCF_____- ");
            double[] TCF = ThirdPoint.theoryNCF(NCF, beta, 0,0);
            for(int i = 0; i < TCF.length; i ++){
                System.out.println(TCF[i] + " ");
            }
            System.out.println( "_____NCF_____- ");
            for (double elem : NCF) System.out.println(elem + " ");
            System.out.println( "___eps_____ " + ThirdPoint.epsARMA(NCF, TCF));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void ARCC33(double M){
        System.out.println("_____________________МОДЕЛИРОВАНИЕ ARCC(33)_____________________");
        double[] arr0 = new double[6000];
        ArrayList<Double> arr = new ArrayList<>();
        double[] beta = {0.0, -0.0384,	0.6336,	0.1105};
        double[] a = {10.6611,	5.7129,	0.6462,	3.1364};
        double[] E = new double[6000];
        Random r = new Random();
        for (int i = 3; i < arr0.length; i++){
            E[i] = r.nextGaussian();
            arr0[i] = beta[1] * arr0[i - 1] + beta[2] * arr0[i - 2]+ beta[3] * arr0[i - 3]
                    + a[0] * E[i] + a[1] * E[i - 1] + a[2] * E[i - 2] + a[3] * E[i - 3]
                    + (1 - (beta[1] + beta[2]+ beta[3])) * M;
        }
        try {
            FileWriter fileWriter = new FileWriter("ARCC_MODEL.TXT", false);
            for (int i = 1000; i < arr0.length; i++){
                arr.add(arr0[i]);
                fileWriter.write(Double.toString(arr0[i]));
                fileWriter.append('\n');
            }
            double avg = FirstPoint.average(arr);
            System.out.println("_average_ " + avg);
            double dispersion = FirstPoint.dispersion(avg, arr);
            System.out.println("_dispersion_ " + dispersion);
            System.out.println("_ско_ " + sqrt(dispersion));
            ArrayList<Double> NCF = new ArrayList<>();

            for(int i = 0; i < 11; i ++){
                NCF.add(FirstPoint.NCF(i, arr));
            }
            double[] TCF = ThirdPoint.theoryNCF(NCF, beta, 3,3);
            System.out.println( "___NCF_____- ");
            for (double elem : NCF) System.out.println(elem + " ");
            System.out.println( "___eps_____ " + ThirdPoint.epsARMA(NCF, TCF));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

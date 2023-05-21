import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Double> list = new ArrayList<>();
        list = readFile(list);
        System.out.println(FirstPoint.average(list));
        ArrayList<Double> CF = new ArrayList<>();
        ArrayList<Double> NCF = new ArrayList<>();
        int T = -1;
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
        ArrayList<Double> AR_CF = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            CF.add(FirstPoint.correlationF(i, list));
            NCF.add(FirstPoint.NCF(i, list)); //нкф исходного процесса
            //  if(i < 4){
               // AR_CF.add(CF.get(i));
           // }
        }
       // ArrayList<Double> solveAR;
        //solveAR = SecondPoint.solveAR(AR_CF, 2);
      //  System.out.println(df.format(solveAR.get(0)) + " " + df.format(solveAR.get(1))+ " " + df.format(solveAR.get(2)));

      /*  double[] theoryNCF;
        for(int i = 0; i <= 3; i++) {
            theoryNCF = SecondPoint.theoryNCF(NCF, i, 0);
            //System.out.println(SecondPoint.epsAR(NCF, theoryNCF));
            for(int j = 0; j < 11; j++) {
                System.out.print(theoryNCF[j] + " ");
            }
            System.out.println();
            System.out.println(SecondPoint.epsAR(NCF, theoryNCF));
        }
        */
       // ThirdPoint.ARMA(NCF);
        BestModels.AR2(98.55264);
      //  BestModels.CC0(98.55264);
       // BestModels.ARCC33(98.55264);
    }

    public static ArrayList<Double> readFile(ArrayList<Double> list) throws IOException{
        File file = new File("C:\\Users\\Anna\\IdeaProjects\\tcpLab\\src\\45.txt");
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(reader);
        while (sc.hasNextLine()){
            for (int i = 0; i < 5000; i++)
                list.add(Double.parseDouble(sc.nextLine()));
        }
        return list;
    }
}
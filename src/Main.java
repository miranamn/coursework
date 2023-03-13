import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Double> list = new ArrayList<>();
        list = readFile(list);
        double CF, NCF;
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
        for(int i = 0; i < 15; i++){
            CF = FirstPoint.correlationF(i, list);
            NCF = FirstPoint.NCF(i, list);
            System.out.println(i + ": CF " + df.format(CF) + " : NCF " + df.format(NCF));
        }
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
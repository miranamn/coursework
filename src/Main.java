import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Double> list = new ArrayList<>();
        list = readFile(list);
        double average = FirstPoint.average(list);
        double dispersion = FirstPoint.dispersion(average, list);
        System.out.print(average + " " + dispersion);
    }

    public static ArrayList<Double> readFile(ArrayList<Double> list) throws IOException, ClassNotFoundException {
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
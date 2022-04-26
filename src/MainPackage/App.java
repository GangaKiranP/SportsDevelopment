package MainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {

    static Exersice[] saturdayExercises = new Exersice[3];
    static Exersice[] sundayExercises = new Exersice[3];
    static ArrayList<Student> students = new ArrayList<>();
    static int averageScore = 1;
    static int count = 1;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        readFiles();

        new MainGui().show();
    }

    public static void finish() {
        for (Exersice e : saturdayExercises) {
            if (e == null) {
                continue;
            }
            e.students.clear();
            e.capacity = 4;
            e.totalRevenue = 0;
        }
        for (Exersice e : sundayExercises) {
            if (e == null) {
                continue;
            }
            e.students.clear();
            e.capacity = 4;
            e.totalRevenue = 0;

        }
        for (Student s : students) {
            s.selectedOnSaturday = new int[3];
            s.selectedOnSunday = new int[3];
        }
    }

    public static int convert(String time) {
        int timeInteger = -1;
        switch (time) {
            case "Morning" -> {
                timeInteger = 0;
                break;
            }

            case "AfterNoon" -> {
                timeInteger = 1;
                break;
            }
            case "Evening" -> {
                timeInteger = 2;
                break;
            }
            default ->
                throw new AssertionError();
        }
        return timeInteger;
    }

    private static void readFiles() {
        File stfile = new File("stud.txt");
        File exfile = new File("ex.txt");
        ObjectInputStream ip;

        try {
            if (!stfile.exists()) {
                stfile.createNewFile();
            }
            if (!exfile.exists()) {
                exfile.createNewFile();
            }
            ip = new ObjectInputStream(new FileInputStream(stfile));
            while (true) {
                try {
                    Student cStudent = (Student) ip.readObject();
                    if (cStudent == null) {
                        break;
                    }
                    students.add(cStudent);
                } catch (EOFException e) {
                    break;
                }
            }
            ip = new ObjectInputStream(new FileInputStream(exfile));
            while (true) {
                Exersice c = null;
                try {
                    c = (Exersice) ip.readObject();
                } catch (EOFException e) {
                    break;
                }
                if (c == null) {
                    break;
                }
                if (c.getDay().equals("Saturday")) {
                    saturdayExercises[convert(c.getTime())] = c;
                }
                if (c.getDay().equals("Sunday")) {
                    sundayExercises[convert(c.getTime())] = c;
                }

            }
//            for (int i = 0; i < 3; i++) {
//                Exersice c = (Exersice) ip.readObject();
//                int place = convert(c.getTime());
//                saturdayExercises[place] = c;
//            }
//            for (int i = 0; i < 3; i++) {
//
//                Exersice c = (Exersice) ip.readObject();
//                int place = convert(c.getTime());
//                System.out.println("read" + c.getName());
//
//                sundayExercises[place] = c;
//            }

        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void writeOnFiles() {
        File stfile = new File("stud.txt");
        File exfile = new File("ex.txt");

        ObjectOutputStream op;

        try {
            if (!stfile.exists()) {
                stfile.createNewFile();
            }
            if (!exfile.exists()) {
                exfile.createNewFile();
            }
            op = new ObjectOutputStream(new FileOutputStream(stfile));
            for (Student s : students) {
                op.writeObject(s);
            }
            op = new ObjectOutputStream(new FileOutputStream(exfile));
            for (Exersice e : saturdayExercises) {
                if (e == null) {
                    continue;
                }
                op.writeObject(e);
            }
            for (Exersice e : sundayExercises) {
                if (e == null) {
                    continue;
                }
                op.writeObject(e);
            }
            System.out.println(System.getProperty("user.dir") + " " + stfile.getAbsolutePath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public static void saveScores(String name, int size, double tc,int as) {
        try {
            File file = new File("reviewHistory.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                String s = br.readLine();

                if (s == null) {
                    break;
                }
                str += s + "\n";

            }
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            bf.append(str);
//            bf.append(ex.getName() + "," + averageScore + "," + ex.students.size() + ',' + ex.getTotalCost());
            bf.append(name + "," + as + "," + size + ',' + tc);

            bf.close();
            count = 1;
            averageScore = 1;

        } catch (IOException exc) {
            System.out.println("2" + exc.getMessage());
        }
    }
}

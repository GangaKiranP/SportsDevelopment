package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exersice implements Serializable {

    String name;
    // M for Morning , E for evening , A for afternoon
    String time;
    int capacity;
    ArrayList<Student> students = new ArrayList<>();
    double cost, totalRevenue;
    int id;
    String day;
    int rating = 0, amount = 1;
    double dum;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exersice(String name, String time, double cost, int id, String day) {
        this.name = name;
        this.time = time;
        capacity = 4;
        this.cost = cost;
        this.id = id;
        this.day = day;
        this.rating = 1;
        this.amount = 1;
        this.totalRevenue = 0;
        dum = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void addStudent(Student s) {
        
        if (capacity == 0) {
            JOptionPane.showMessageDialog(null, "No more place in this program");
            return;
        }
        totalRevenue += cost;
        dum = totalRevenue;
        System.out.println("total reven= "+ totalRevenue);
        students.add(s);
        if(students.size()==1){
            rating = 1;
            amount = 1;
            dum = cost;
        }
        capacity--;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void removeStudent(Student s) {
        if (capacity == 4) {
            JOptionPane.showMessageDialog(null, "No students are in this program");
            return;
        }
        s.selectedOnSaturday[App.convert(time)] = 0;
        s.selectedOnSunday[App.convert(time)] = 0;

        students.remove(s);
        capacity++;
        totalRevenue = totalRevenue-cost;
    }

    public double getTotalCost() {
        return totalRevenue;
    }

    public double getCost() {
        return cost;
    }

    public void addRating(int a) {
                System.out.println("totalre1 = " + dum);

        System.out.println(amount);
        rating += a;
        System.out.println("rating1 = " + rating);
        System.out.println(rating + " / " + amount + "=" + rating / amount);
        rating = rating / amount;

        System.out.println("rating2 = " + rating);

        amount++;
        System.out.println("totalre2 = " + dum);
    }
}

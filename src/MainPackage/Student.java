package MainPackage;

import java.io.Serializable;

public class Student implements Serializable{

    String name;
    // Array to see if a given time slot is available
    int[] selectedOnSunday = {0, 0, 0};
    int[] selectedOnSaturday = {0, 0, 0};

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

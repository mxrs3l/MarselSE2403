package Models;

import java.util.ArrayList;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade < 100) {
            grades.add(grade);
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Integer grade: grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "I am student with ID" + studentID;
    }
}

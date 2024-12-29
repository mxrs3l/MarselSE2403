import Models.Person;
import Models.School;
import Models.Student;
import Models.Teacher;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File studentFile = new File("src/student.txt");
        Scanner studentScanner = new Scanner(studentFile);

        while(studentScanner.hasNextLine()){
            String name = studentScanner.nextLine();
            String surname = studentScanner.nextLine();
            int age = studentScanner.nextInt();
            boolean gender = studentScanner.nextBoolean();

            Student student = new Student(name, surname, age, gender);

            while(studentScanner.hasNextInt()){
                student.addGrade(studentScanner.nextInt());
            }

            School.addMember(student);
        }
        studentScanner.close();

        File teacherFile = new File("src/teacher.txt");
        Scanner teacherScanner = new Scanner(teacherFile);
        while(teacherScanner.hasNext()){
            String name = teacherScanner.next();
            String surname = teacherScanner.next();
            int age = teacherScanner.nextInt();
            boolean gender = teacherScanner.next().equalsIgnoreCase("male");
            String subject = teacherScanner.next();
            int yearsOfExperience = teacherScanner.nextInt();
            int salary = teacherScanner.nextInt();

            Teacher  teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            School.addMember(Teacher);
        }
        teacherScanner.close();

        System.out.println("All members of the school:");
        System.out.println(school);

        for(Person member : School.getMembers()){
            if(member instanceof Teacher teacher){
                if(teacher.getYearsOfExperience() > 10){
                    teacher.giveRaise(10);
                }
            }
        }

        System.out.println("After the salary increase:");
        for(Person member : School.getMembers()) {
            if(member instanceof Teacher teacher){
                System.out.println(teacher);
            }
        }

        System.out.println();

        for (Person member : School.getMembers()){
            if(member instanceof Student student){
                double grade = student.calculateGPA();
                System.out.println(student.getName() + "'s GPA: " + grade);
            }
        }
    }
}
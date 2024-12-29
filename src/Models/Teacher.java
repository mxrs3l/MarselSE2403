package Models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        setSubject(subject);
        setYearsOfExperience(yearsOfExperience);
        setSalary(salary);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void giveRaise(double percentage){
        if(percentage > 0) {
            salary += salary * percentage / 100;
        }
    }

    public void checkForExperience(){
        if(yearsOfExperience > 10){
            giveRaise(10);
        }
    }

    @Override
    public String toString() {
        return "I teach " + subject;
    }

}

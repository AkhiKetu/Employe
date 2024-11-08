package employee.employee;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String  designation;
    private int Salary;
    private LocalDate doj;
    private String Gender;

    //Constructor

    public Employee(int id, String name, String designation, int salary, LocalDate doj, String gender) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        Salary = salary;
        this.doj = doj;
        Gender = gender;
    }
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    //toString method

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}

package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double salary;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public String getClub() {
        return club;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void show(){
        System.out.println("Player name  : "+ getName());
        System.out.println("Country name : "+ getCountry());
        System.out.println("Age          : "+ getAge()+" years");
        System.out.println("Height       : "+ getHeight()+" meters");
        System.out.println("Club name    : "+ getClub());
        System.out.println("Position     : "+ getPosition());
        System.out.println("Number       : "+ getNumber());
        System.out.println("Weekly Salary: "+ getSalary());
        System.out.println();
    }
}





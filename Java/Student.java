package com.blit;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    String name;
    ArrayList<String> courses;
    int noOfSubjects;

    public Student(String name) {
        this.name = name;
        this.noOfSubjects = 0;
        courses = new ArrayList<String>();
    }

    public void addCourse(String course){

        courses.add(course);
        this.noOfSubjects++;
    }

    public void dropCourse(String course){

        courses.remove(course);
        this.noOfSubjects--;
    }

    public String getCourses(){

        return courses.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String choice = "";

        System.out.println("Enter your name: ");
        String n = scan.nextLine();

        Student mike = new Student(n);

        while(choice.equalsIgnoreCase("Exit") == false){

            System.out.println("---------------------------------------");
            System.out.println("Hi " + n + "! Enter an option: \nAdd: Add a course \nDrop: Drop a course \nDrop All: Drops all courses \nShow: Display courses \nExit: Terminates program");
            System.out.println("---------------------------------------");

            choice = scan.nextLine();

            if(choice.equalsIgnoreCase("Add")){

                System.out.println("Enter a course name to add: ");
                String course = scan.nextLine();
                mike.addCourse(course);
                System.out.println("Added course: " + course);
            }

            else if(choice.equalsIgnoreCase("Drop")){

                System.out.println("Enter a course name to drop: ");
                String course = scan.nextLine();
                mike.dropCourse(course);
                System.out.println("Dropped course: " + course);

            }

            else if(choice.equalsIgnoreCase("Drop All")){

                mike.courses = new ArrayList<String>();

                System.out.println("Dropped all courses: " + mike.getCourses());
            }

            else if(choice.equalsIgnoreCase("Show")){

                System.out.println("Courses: " + mike.getCourses());
            }


        }

        System.out.println("Goodbye!");

    }
}

package com.jdbclearning.controllers;

import com.jdbclearning.daos.Dao;
import com.jdbclearning.entities.Patient;
import com.jdbclearning.entities.Student;
import com.jdbclearning.util.SQLConnector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {

        SQLConnector sqlObj = new SQLConnector();
        SQLConnector.createConnection();

        Dao hospital = new Dao();

        Scanner scan = new Scanner(System.in);
        String choice = "";

        while(choice.equalsIgnoreCase("Exit") == false){

            System.out.println("---------------------------------------");
            System.out.println("Hospital DB | Enter an option: \nCreate: Create a patient \nRemove: Remove a patient \nUpdate: Update a patient \nDisplay: Displays patients \nExit: Terminates program");
            System.out.println("---------------------------------------");

            choice = scan.nextLine();

            if(choice.equalsIgnoreCase("Create")){

                System.out.println("Enter the patient name: ");
                String name = scan.nextLine();

                System.out.println("Enter the concern/injury: ");
                String concern = scan.nextLine();

                System.out.println("Enter the patient address: ");
                String address = scan.nextLine();

                System.out.println("Enter the patient bloodtype: ");
                String blood = scan.nextLine();

                Patient createPatient = new Patient(name, concern, address, blood);

                //Insert patient Into DB -     "C"
                hospital.insertPatient(createPatient);
                System.out.println(createPatient);
            }

            else if(choice.equalsIgnoreCase("Remove")){

                System.out.println("Enter the patient id: ");
                String id = scan.nextLine();

                //Delete student -          "R"
                hospital.deleteStudent(Integer.parseInt(id));
            }

            else if(choice.equalsIgnoreCase("Update")){

                System.out.println("Enter the patient id: ");
                String id = scan.nextLine();

                System.out.println("Enter the new patient name: ");
                String name = scan.nextLine();

                System.out.println("Enter the new concern/injury: ");
                String concern = scan.nextLine();

                System.out.println("Enter the new patient address: ");
                String address = scan.nextLine();

                System.out.println("Enter the new patient bloodtype: ");
                String blood = scan.nextLine();

                Patient updatePatient = new Patient(name, concern, address, blood);

                //Update student -          "U"
                hospital.updateStudent(Integer.parseInt(id), updatePatient);
            }

            else if(choice.equalsIgnoreCase("Display")){

                //SELECT * FROM patients -  "D"
                for(Patient p : hospital.getAllPatients()){

                    System.out.println(p);
                }

            }


        }

        System.out.println("Goodbye!");




    }
}

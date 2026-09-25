package com.learnJDBC;

import java.sql.*;
import java.util.Scanner;

public class Patient {

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    // Collecting information of patients
    public void addPatient() {

        System.out.println("Enter Patient's Name");
        String name = scanner.next();

        System.out.println("Enter Patient's Age");
        int age = scanner.nextInt();

        System.out.println("Enter Patient's Gender");
        String gender = scanner.next();

        try {

            String query =
                    "INSERT INTO patients(name, age, gender) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Patient Added Successfully");
            } else {
                System.out.println("Failed to add Patient!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Patients
    public void viewPatients() {

        String query = "SELECT * FROM patients";

        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultset =
                    preparedStatement.executeQuery();

            System.out.println("Patients: ");

            System.out.println(
                    "+-------------+---------------------+------+----------+");
            System.out.println(
                    "| Patient ID  | Name                | Age  | Gender   |");
            System.out.println(
                    "+-------------+---------------------+------+----------+");

            while (resultset.next()) {

                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String gender = resultset.getString("gender");

                System.out.printf(
                        "|%-13s|%-21s|%-6s|%-10s|%n",
                        id, name, age, gender);

                System.out.println(
                        "+-------------+---------------------+------+----------+");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getPatientById(int id) {

        String query =
                "SELECT * FROM patients WHERE id = ?";

        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultset =
                    preparedStatement.executeQuery();

            if (resultset.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
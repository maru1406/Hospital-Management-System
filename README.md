# Hospital Management System

A console-based Hospital Management System developed using Java, JDBC, and MySQL. The application provides basic functionality for managing patients, doctors, and appointments through a menu-driven interface.

## Features

- Add new patients
- View registered patients
- View available doctors and their specializations
- Book appointments
- Check doctor availability before booking
- Store and retrieve data using MySQL

## Technologies Used

- Java
- JDBC
- MySQL
- Eclipse IDE
- MySQL Connector/J

## Project Structure

```text
Hospital-Management-System/
│
├── src/
│   └── com/
│       └── learnJDBC/
│           ├── HospitalManagementSystem.java
│           ├── Patient.java
│           └── Doctor.java
│
├── database/
│   └── hospital.sql
│
└── .gitignore

## Database

The application uses a MySQL database named `Hospital` with three tables:

- `patients` – stores patient information
- `doctors` – stores doctor information and specializations
- `appointments` – stores appointment details and relationships between patients and doctors

The database setup script is available in `database/hospital.sql`.

## How to Run

1. Install Java JDK 21 or later.
2. Install MySQL Server and MySQL Workbench.
3. Execute `database/hospital.sql` in MySQL Workbench to create the database and tables.
4. Add MySQL Connector/J to the Java project's classpath.
5. Set the `HMS_DB_PASSWORD` environment variable to your MySQL password.
6. Open the project in Eclipse.
7. Run `HospitalManagementSystem.java` as a Java Application.

## Application Flow

```text
Start Application
        ↓
Hospital Management System
        ↓
┌───────────────────────────┐
│ 1. Add Patient            │
│ 2. View Patients          │
│ 3. View Doctors           │
│ 4. Book Appointment       │
│ 5. Exit                   │
└───────────────────────────┘
        ↓
JDBC
        ↓
MySQL Database
        ↓
Patients | Doctors | Appointments
## Demo

[🎥 Watch the Project Demo](https://drive.google.com/file/d/13XYoDFFBYoxYNqIMB2BBHFa7PO62zmDX/view?usp=sharing)

CREATE DATABASE IF NOT EXISTS Hospital;
USE Hospital;

-- Patients table
CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(20) NOT NULL
);

-- Doctors table
CREATE TABLE IF NOT EXISTS doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

-- Appointments table
CREATE TABLE IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Patients_id INT NOT NULL,
    Doctor_id INT NOT NULL,
    appointment DATE NOT NULL,
    FOREIGN KEY (Patients_id) REFERENCES patients(id),
    FOREIGN KEY (Doctor_id) REFERENCES doctors(id)
);

-- Sample doctors
INSERT INTO doctors (name, specialization)
VALUES
('Sangeetha', 'Physician'),
('Vansh', 'NeuroSurgeon');
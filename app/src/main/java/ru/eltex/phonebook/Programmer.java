package ru.eltex.phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ru.eltex.phonebook.serialization.toCSV;

public class Programmer extends User implements toCSV {

    private String specialization;
    private static String FILE_NAME = "programmer.csv";

    public Programmer(String name, String surname, String patronymic,
                      String phoneNumber, String address, String specialization) {
        super(name, surname, patronymic, phoneNumber, address);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Programmer: " +
                this.getSurname() + " " +
                this.getName() + " " +
                this.getPatronymic() + ", " +
                this.getPhoneNumber() + ", " +
                this.getSpecialization();
    }

    @Override
    public String toJSONString() {
        return "{" +
                "\"surname\": " + this.getSurname() +
                " \"name\": " + this.getName() +
                " \"patronymic\": " + this.getName() +
                ", \"phone\":" + this.getPhoneNumber() +
                ", \"specialization\":" + this.getSpecialization() +
                "}";
    }

    @Override
    public void CSVFileWriter() throws IOException {
        final BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_NAME));
        final StringBuilder s = new StringBuilder();
        s.append(this.getSurname());
        s.append(",");
        s.append(this.getName());
        s.append(",");
        s.append(this.getPatronymic());
        s.append(",");
        s.append(this.getPhoneNumber());
        s.append(",");
        s.append(this.getSpecialization());
        final String line = s.toString();
        writer.write(line);
        writer.close();
    }
}

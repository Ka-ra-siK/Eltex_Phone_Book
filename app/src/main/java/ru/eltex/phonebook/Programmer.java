package ru.eltex.phonebook;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import ru.eltex.phonebook.serialization.toCSV;

public class Programmer extends User implements toCSV {

    private String specialization;
    private static final String CSV_SEPARATOR = ",";
    private static String FILE_NAME = "programmer.csv";

    public Programmer(String name, String surname, String patronymic,
                      String phoneNumber, String specialization) {
        super(name, surname, patronymic, phoneNumber);
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
    public void CSVFileWriter(List<User> users) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"));
        for (User user : users) {
            StringBuffer oneLine = new StringBuffer();
            oneLine.append(this.getSurname().trim().length() == 0 ? "" : this.getSurname());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(this.getName().trim().length() == 0 ? "" : this.getName());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(this.getPatronymic().trim().length() == 0 ? "" : this.getPatronymic());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(this.getPhoneNumber().trim().length() == 0 ? "" : this.getPhoneNumber());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(this.getSpecialization().trim().length() == 0 ? "" : this.getSpecialization());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

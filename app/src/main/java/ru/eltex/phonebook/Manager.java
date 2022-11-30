package ru.eltex.phonebook;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import ru.eltex.phonebook.serialization.toCSV;

public class Manager extends User implements toCSV {
    private String eMail;
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_NAME = "manager.csv";

    public Manager(String surname, String name, String patronymic,
                   String phoneNumber, String eMail) {
        super(surname, name, patronymic, phoneNumber);
        this.eMail = eMail;
    }


    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Manager: " +
                this.getSurname() + " " +
                this.getName() + " " +
                this.getPatronymic() + ", " +
                this.getPhoneNumber() + ", " +
                this.getMail();
    }

    @Override
    public String toJSONString() {
        return "{" +
                "\"surname\": " + this.getSurname() +
                " \"name\": " + this.getName() +
                " \"patronymic\": " + this.getName() +
                ", \"phone\":" + this.getPhoneNumber() +
                ", \"mail\":" + this.getMail() +
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
            oneLine.append(this.getMail().trim().length() == 0 ? "" : this.getMail());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

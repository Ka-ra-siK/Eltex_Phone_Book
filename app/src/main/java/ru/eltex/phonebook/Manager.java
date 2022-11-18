package ru.eltex.phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ru.eltex.phonebook.serialization.toCSV;

public class Manager extends User implements toCSV{
    private String eMail;
    private static String FILE_NAME = "manager.csv";

    public Manager(String name, String surname, String patronymic,
                   String phoneNumber, String address, String eMail) {
        super(name, surname, patronymic, phoneNumber, address);
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
        s.append(this.getMail());
        final String line = s.toString();
        writer.write(line);
        writer.close();
    }
}

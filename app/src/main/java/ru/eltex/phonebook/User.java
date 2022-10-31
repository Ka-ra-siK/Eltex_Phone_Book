package ru.eltex.phonebook;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private String address;

    public User(String name, String surname, String patronymic,
                String phoneNumber, String address){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void save(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(getName()+"\n");
        writer.write(getSurname()+"\n");
        writer.write(getPatronymic()+"\n");
        writer.write(getAddress()+"\n");
        writer.write(getPhoneNumber()+"\n");
        writer.close();

    }

    public void load(String fileName) throws IOException {
        FileReader reader= new FileReader(fileName);
        Scanner scan = new Scanner(reader);
        while (scan.hasNextLine()) {
           setName(scan.nextLine());
           setSurname(scan.nextLine());
           setPatronymic(scan.nextLine());
           setAddress(scan.nextLine());
           setPhoneNumber(scan.nextLine());
        }
        reader.close();
    }
}

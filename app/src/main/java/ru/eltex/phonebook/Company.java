package ru.eltex.phonebook;

import java.util.Stack;

public class Company extends User{
    private String companyName;
    private String eMail;
    private String INN;
    private String OGRN;


    public Company(String name, String surname, String patronymic,
                   String phoneNumber, String address,
                   String companyName, String eMail,
                   String INN, String OGRN) {
        super(name, surname, patronymic, phoneNumber, address);
        this.companyName = companyName;
        this.eMail = eMail;
        this.OGRN = OGRN;
        this.INN = INN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }
}

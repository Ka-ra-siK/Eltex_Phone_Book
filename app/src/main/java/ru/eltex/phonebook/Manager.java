package ru.eltex.phonebook;

public class Manager extends User{
    private String eMail;

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
        return null;
    }

    @Override
    public String toJSONString() {
        return null;
    }
}

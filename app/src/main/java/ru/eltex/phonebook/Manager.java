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
}

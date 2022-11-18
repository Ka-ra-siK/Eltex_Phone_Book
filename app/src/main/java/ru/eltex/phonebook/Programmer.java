package ru.eltex.phonebook;

public class Programmer extends User {

    private String specialization;

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
}

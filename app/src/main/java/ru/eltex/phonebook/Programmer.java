package ru.eltex.phonebook;

public class Programmer extends User{

    private String position;
    private String specialization;

    public Programmer(String name, String surname, String patronymic,
                      String phoneNumber, String address, String position, String specialization) {
        super(name, surname, patronymic, phoneNumber, address);
        this.position = position;
        this.specialization = specialization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

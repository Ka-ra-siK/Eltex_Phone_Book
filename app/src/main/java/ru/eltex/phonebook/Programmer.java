package ru.eltex.phonebook;

public class Programmer extends User{

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
        return null;
    }

    @Override
    public String toJSONString() {
        return null;
    }
}

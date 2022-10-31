package ru.eltex.phonebook;

public class Individual extends User{

    private String birthday;


    public Individual(String name, String surname, String patronymic,
                      String phoneNumber, String birthday, String address) {
        super(name, surname, patronymic, phoneNumber, address);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

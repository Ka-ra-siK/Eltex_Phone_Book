package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import ru.eltex.phonebook.Manager;
import ru.eltex.phonebook.Programmer;
import ru.eltex.phonebook.R;
import ru.eltex.phonebook.User;

public class MainActivity extends AppCompatActivity {
    private static String FILE_NAME = "saveUser.dat";
    static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mainList = (ListView) findViewById(R.id.main_list);

        users = new LinkedList<>();

        users.add(new Programmer("Vadim", "Chernyavsky", "Vasilyevich", "8800553535",
                        "Gagarina 1", "Junior Android Developer"));
        users.add(new Programmer("Konstantin", "Konovalov", "Olegovich", "89129003468",
                        "Lenina 10", "Student"));
        users.add( new Programmer("Egor", "Fokin", "Konstantinovich", "89139993456",
                        "Bluhera 32/1", "Senior C++ Backend Developer"));
        users.add(new Programmer("Maxim", "Vasilchenko", "Aleksandrovich", "89135436712",
                        "Bluhera 32/1","Junior Embedded C Developer"));
        users.add(new Programmer("Roman", "Shevlyakov", "Valerievich", "89132563245",
                        "Titova 13", "Senior Embedded C Developer"));
        users.add(new Manager("Vladislav", "Sizov", "Aleksandrovich", "89140983245",
                        "Koroleva 4", "v.sizov123@mail.ru"));
        users.add(new Manager("Ivan", "Ivanov", "Ivanovich", "89003456789",
                        "Lenina 3", "i.ivanov123@gmail.com"));
        users.add(new Manager("Anatoly", "Buravov", "Sergeevich", "89140072258",
                        "Nemirovich-Danchenko 124", "a.buravov@yandex.ru"));

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

    }
}
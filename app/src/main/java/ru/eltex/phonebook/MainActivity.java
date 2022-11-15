package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static String FILE_NAME = "saveUser.dat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        User[] users = {
                new Programmer("Vadim", "Chernyavsky", "Vasilyevich", "8800553535",
                        "Gagarina 1", "Junior Android Developer"),
                new Programmer("Konstantin", "Konovalov", "Olegovich", "89129003468",
                        "Lenina 10", "Student"),
                new Programmer("Egor", "Fokin", "Konstantinovich", "89139993456",
                        "Bluhera 32/1", "Senior C++ Backend Developer"),
                new Programmer("Maxim", "Vasilchenko", "Aleksandrovich", "89135436712",
                        "Bluhera 32/1","Junior Embedded C Developer"),
                new Programmer("Roman", "Shevlyakov", "Valerievich", "89132563245",
                        "Titova 13", "Senior Embedded C Developer"),
                new Manager("Vladislav", "Sizov", "Aleksandrovich", "89140983245",
                        "Koroleva 4", "v.sizov123@mail.ru"),
                new Manager("Ivan", "Ivanov", "Ivanovich", "89003456789",
                        "Lenina 3", "i.ivanov123@gmail.com"),
                new Manager("Anatoly", "Buravov", "Sergeevich", "89140072258",
                        "Nemirovich-Danchenko 124", "a.buravov@yandex.ru")
        };

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

    }
}
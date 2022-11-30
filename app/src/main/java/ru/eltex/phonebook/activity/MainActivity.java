package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import ru.eltex.phonebook.Manager;
import ru.eltex.phonebook.Programmer;
import ru.eltex.phonebook.R;
import ru.eltex.phonebook.User;
import ru.eltex.phonebook.db.DBHelper;

public class MainActivity extends AppCompatActivity {
    private static String FILE_NAME = "saveUser.dat";
    static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mainList = (ListView) findViewById(R.id.main_list);
        users = new LinkedList<>();

        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(7).equals("Programmer")) {
                users.add(new Programmer(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5)
                        )
                );
            }
            if (cursor.getString(7).equals("Manager")) {
                users.add(new Manager(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(6)
                        )
                );
            }
            cursor.moveToNext();
        }
        cursor.close();


//        users.add(new Programmer("Vadim", "Chernyavsky", "Vasilyevich", "8800553535",
//                "Junior Android Developer"));
//        users.add(new Programmer("Konstantin", "Konovalov", "Olegovich", "89129003468",
//                         "Student"));
//        users.add( new Programmer("Egor", "Fokin", "Konstantinovich", "89139993456",
//                         "Senior C++ Backend Developer"));
//        users.add(new Programmer("Maxim", "Vasilchenko", "Aleksandrovich", "89135436712",
//                        "Junior Embedded C Developer"));
//        users.add(new Programmer("Roman", "Shevlyakov", "Valerievich", "89132563245",
//                         "Senior Embedded C Developer"));
//        users.add(new Manager("Vladislav", "Sizov", "Aleksandrovich", "89140983245",
//                         "v.sizov123@mail.ru"));
//        users.add(new Manager("Ivan", "Ivanov", "Ivanovich", "89003456789",
//                         "i.ivanov123@gmail.com"));
//        users.add(new Manager("Anatoly", "Buravov", "Sergeevich", "89140072258",
//                         "a.buravov@yandex.ru"));


        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        ((Button) findViewById(R.id.add_btn)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });

    }
}
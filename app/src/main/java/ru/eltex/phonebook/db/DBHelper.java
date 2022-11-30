package ru.eltex.phonebook.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "PHONES", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (\n" +
                "    id             INTEGER UNIQUE\n" +
                "                           PRIMARY KEY,\n" +
                "    surname        TEXT,\n" +
                "    name           TEXT,\n" +
                "    patronymic     TEXT    UNIQUE,\n" +
                "    phone          TEXT,\n" +
                "    specialization TEXT,\n" +
                "    mail           TEXT,\n" +
                "    user_type      TEXT\n" +
                ");");

        db.execSQL("INSERT INTO users (id, surname, name, patronymic, phone, specialization, mail, user_type) VALUES\n" +
                "                (0, \"Konovalov\", \"Konstantin\", \"Olegovich\", \"89129743468\", \"Student\", \"\", \"Programmer\"),\n" +
                "                (1, \"Chernyavsky\", \"Vadim\", \"Vasilyevich\", \"8800553535\", \"Junior Android Developer\", \"\", \"Programmer\"),\n" +
                "                (2, \"Ivanov\", \"Ivan\", \"Ivanovich\", \"89003456789\", \"\", \"i.ivanov123@gmail.com\", \"Manager\");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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

        //Запрос у пользователя на разрешения
        ActivityCompat.requestPermissions(
                this,
                new String[]{
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_CONTACTS,
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.READ_PHONE_STATE
                },
                451
        );

//        ContentResolver contentResolver = getContentResolver();
//        Cursor cursorContacts = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//        if (cursorContacts != null) {
//            cursorContacts.moveToFirst();
//            while (!cursorContacts.isAfterLast()) {
//                int index = cursorContacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//                if (index >= 0) {
//                    String name = cursorContacts.getString(index);
//                }
//                cursorContacts.moveToNext();
//
//            }
//        }

        ListView mainList = (ListView) findViewById(R.id.main_list);
        users = new LinkedList<>();

        //Подключение к БД
        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users;", null);
        cursor.moveToFirst();
        //Проверка на тип контактов
        while (!cursor.isAfterLast()) {
            //Прогер
            if (cursor.getString(7).equals("Programmer")) {
                users.add(new Programmer(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5)
                        )
                );
                Uri rawContsctUri = this.getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, new ContentValues());
                System.out.println(rawContsctUri);
                long id = ContentUris.parseId(rawContsctUri);

                ContentValues value = new ContentValues();
                value.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, id);
                value.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                value.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, cursor.getString(1) + " "
                        + cursor.getString(2) + " "
                        + cursor.getString(3));
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,value);

                value.clear();
                value.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, id);
                value.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                value.put(ContactsContract.CommonDataKinds.Phone.NUMBER,cursor.getString(4));
                value.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,value);
            }
            //Менеджер
            if (cursor.getString(7).equals("Manager")) {
                users.add(new Manager(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(6)
                        )
                );
                Uri rawContsctUri = this.getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, new ContentValues());
                System.out.println(rawContsctUri);
                long id = ContentUris.parseId(rawContsctUri);

                ContentValues value = new ContentValues();
                value.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, id);
                value.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                value.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, cursor.getString(1) + " "
                        + cursor.getString(2) + " "
                        + cursor.getString(3));
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,value);

                value.clear();
                value.put(ContactsContract.RawContacts.Data.RAW_CONTACT_ID, id);
                value.put(ContactsContract.RawContacts.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                value.put(ContactsContract.CommonDataKinds.Phone.NUMBER,cursor.getString(4));
                value.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI,value);
            }
            cursor.moveToNext();
        }
        cursor.close();


        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        ((Button) findViewById(R.id.add_btn)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });

    }
}
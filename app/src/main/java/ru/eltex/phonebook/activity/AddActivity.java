package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import ru.eltex.phonebook.Manager;
import ru.eltex.phonebook.Programmer;
import ru.eltex.phonebook.R;
import ru.eltex.phonebook.User;
import ru.eltex.phonebook.db.DBHelper;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ((Button) findViewById(R.id.add_btn)).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String surname = ((EditText) findViewById(R.id.surname)).getText().toString();
                String patronymic = ((EditText) findViewById(R.id.patronymic)).getText().toString();
                String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                String mail = ((EditText) findViewById(R.id.mail)).getText().toString();
                String specialization = ((EditText) findViewById(R.id.specialization)).getText().toString();
                SQLiteDatabase database = new DBHelper(getApplicationContext()).getReadableDatabase();

                RadioButton programmerRadioButton, managerRadioButton;

                programmerRadioButton = (RadioButton) findViewById(R.id.radio_programmer);
                managerRadioButton = (RadioButton) findViewById(R.id.radio_manager);

                if (programmerRadioButton.isChecked()) {
                    Log.d("INSERT_TO_DB", "Programmer");
                    database.execSQL("INSERT INTO users (surname, name, patronymic, phone, specialization, mail, user_type) VALUES" +
                            "('" + surname + "','"
                            + name + "', '"
                            + patronymic + "', '"
                            + phone + "', '"
                            + specialization + "', '"
                            + mail + "', '"
                            + "Programmer" + "')");
                    Programmer programmer = new Programmer(surname, name, patronymic, phone, specialization);
                    MainActivity.users.add(programmer);
                }

                if (managerRadioButton.isChecked()) {
                    Log.d("INSERT_TO_DB", "Manager!");
                    database.execSQL("INSERT INTO users (surname, name, patronymic, phone, specialization, mail, user_type) VALUES" +
                            "('" + surname + "','"
                            + name + "', '"
                            + patronymic + "', '"
                            + phone + "', '"
                            + specialization + "', '"
                            + mail + "', '"
                            + "Manager" + "')");
                    Manager manager = new Manager(surname, name, patronymic, phone, mail);
                    MainActivity.users.add(manager);

                }
                database.close();


                Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMain);
            }
        });

    }
}
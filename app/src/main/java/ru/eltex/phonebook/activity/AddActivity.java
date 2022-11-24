package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import ru.eltex.phonebook.Programmer;
import ru.eltex.phonebook.R;
import ru.eltex.phonebook.User;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        for (User user : MainActivity.users) {
            System.out.println(user.toString());
        }

        ((Button) findViewById(R.id.add_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String surname = ((EditText) findViewById(R.id.surname)).getText().toString();
                String  patronymic = ((EditText) findViewById(R.id.patronymic)).getText().toString();
                String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
                String other = ((EditText) findViewById(R.id.other)).getText().toString();
                System.out.println(name + " " + phone);

                Programmer programmer = new Programmer(name,surname, patronymic, phone, other);
                MainActivity.users.add(programmer);


                for (User user : MainActivity.users) {
                    System.out.println(user.toString());
                    try {
                        programmer.CSVFileWriter(MainActivity.users);
                        Log.d("CSVFileWriter", "Good!");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("CSVFileWriter", "Bad!");
                    }
                }
                Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMain);
            }
        });

    }
}
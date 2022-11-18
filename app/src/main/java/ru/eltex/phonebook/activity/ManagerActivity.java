package ru.eltex.phonebook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ru.eltex.phonebook.R;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Intent info = getIntent();
        String surname = info.getStringExtra("surname");
        String name_patronymic = info.getStringExtra("name_patronymic");
        String phone = info.getStringExtra("phone");
        String mail = info.getStringExtra("mail");


        ((TextView)findViewById(R.id.surname)).setText(surname);
        ((TextView)findViewById(R.id.name_patronymic)).setText(name_patronymic);
        ((TextView)findViewById(R.id.phone)).setText(phone);
        ((TextView)findViewById(R.id.mail)).setText(mail);
    }
}
package ru.eltex.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static String FILE_NAME = "saveUser.dat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("Иван", "Иванов", "Иванович",
                "8800553535","ул. Гагарина, д. 1, кв. 19");
        try {
            user.save(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            user.load(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User nextUser = null;

        try {
            nextUser.load(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
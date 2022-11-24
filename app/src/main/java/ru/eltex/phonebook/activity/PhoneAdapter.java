package ru.eltex.phonebook.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.List;

import ru.eltex.phonebook.Manager;
import ru.eltex.phonebook.Programmer;
import ru.eltex.phonebook.R;
import ru.eltex.phonebook.User;
import ru.eltex.phonebook.activity.ManagerActivity;
import ru.eltex.phonebook.activity.ProgrammerActivity;

public class PhoneAdapter extends ArrayAdapter<User> {
    private final Context context;
    private final List<User> users;

    public PhoneAdapter(Context context, List<User> users) {
        super(context, R.layout.list_item, users);
        this.context = context;
        this.users = users;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.list_item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText((this.users.get(position)).getSurname() + " " +
                (this.users.get(position)).getName() + " " +
                (this.users.get(position)).getPatronymic());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText((this.users.get(position)).getPhoneNumber());

        TextView otherInformation = (TextView) view.findViewById(R.id.other_info);
        if ((this.users.get(position) instanceof Programmer)) {
            otherInformation.setText(((Programmer) this.users.get(position)).getSpecialization());
        } else {
            otherInformation.setText(((Manager) this.users.get(position)).getMail());
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        if ((this.users.get(position) instanceof Programmer)) {
            imageView.setImageResource(R.drawable.programmer_avatar);
        } else {
            imageView.setImageResource(R.drawable.manager_avatar);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (users.get(position) instanceof Programmer) {
                    Intent toInfo = new Intent(context, ProgrammerActivity.class);
                    toInfo.putExtra("surname", users.get(position).getSurname());
                    toInfo.putExtra("name_patronymic", users.get(position).getName() +
                            " " + users.get(position).getPatronymic());
                    toInfo.putExtra("phone", users.get(position).getPhoneNumber());
                    toInfo.putExtra("specialization", ((Programmer) users.get(position)).getSpecialization());
                    context.startActivity(toInfo);

                }
                if (users.get(position) instanceof Manager) {
                    Intent toInfo = new Intent(context, ManagerActivity.class);
                    toInfo.putExtra("surname", users.get(position).getSurname());
                    toInfo.putExtra("name_patronymic", users.get(position).getName() +
                            " " + users.get(position).getPatronymic());
                    toInfo.putExtra("phone", users.get(position).getPhoneNumber());
                    toInfo.putExtra("mail", ((Manager) users.get(position)).getMail());
                    context.startActivity(toInfo);
                }
            }
        });


        return view;
    }
}

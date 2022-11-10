package ru.eltex.phonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PhoneAdapter extends ArrayAdapter<User> {
    private User[] users;
    private Context context;

    public PhoneAdapter(Context context, User[] users) {
        super(context, R.layout.list_item, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText((this.users[position]).getSurname() + " " +
                (this.users[position]).getName() + " " +
                (this.users[position]).getPatronymic());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText((this.users[position]).getPhoneNumber());

        TextView otherInformation = (TextView) view.findViewById(R.id.other_info);
        if ((this.users[position] instanceof Programmer)){
            otherInformation.setText(((Programmer)this.users[position]).getSpecialization());
        }
        else{
            otherInformation.setText(((Manager)this.users[position]).getMail());
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        if ((this.users[position] instanceof Programmer)) {
            imageView.setImageResource(R.drawable.programmer_avatar);
        }
        else {
            imageView.setImageResource(R.drawable.manager_avatar);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ((User)users[position]).getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}

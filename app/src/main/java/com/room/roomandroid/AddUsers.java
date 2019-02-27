package com.room.roomandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUsers extends Fragment {
    private EditText username;
    private EditText email;
    private Button save;



    public AddUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_users, container, false);

        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        save = view.findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EnteredUsername = username.getText().toString();
                String EnteredEmail = email.getText().toString();

                Users user = new Users();
                user.setName(EnteredUsername);
                user.setEmail(EnteredEmail);

                MainActivity.myDatabase.myDao().addUser(user);

                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                username.setText("");
                email.setText("");
            }
        });

        return view;

    }

}



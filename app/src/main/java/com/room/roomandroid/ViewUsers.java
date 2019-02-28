package com.room.roomandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUsers extends Fragment {
    private static TextView data;


    public ViewUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view_users, container, false);

        data = view.findViewById(R.id.data);


        List<Users> user =  MainActivity.myDatabase.myDao().getUsers();

        String info = "";

        for(Users usr : user){
            String name = usr.getName();
            String email = usr.getEmail();

            info = info+"\n\n\n\n\n"+"username: "+name+"\n"+"Email: "+email;
        }

        data.setText(info);

        return view;
    }

}

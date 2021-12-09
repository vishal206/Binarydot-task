package com.example.binarydottask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.binarydottask.adaptor.userAdaptor;
import com.example.binarydottask.model.users;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<users> usersArrayList;
    private RecyclerView userRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        usersArrayList=new ArrayList<>();
        userRecyclerView=findViewById(R.id.recyclerView_users);

        setUserInfo();
        setAdaptor();
    }

    private void setAdaptor() {
        userAdaptor adaptor=new userAdaptor(usersArrayList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        userRecyclerView.setLayoutManager(layoutManager);
        userRecyclerView.setItemAnimator(new DefaultItemAnimator());
        userRecyclerView.setAdapter(adaptor);
    }

    private void setUserInfo() {
        usersArrayList.add(new users("vishal","ravi","vishalravi123@gmail.com","1",""));
        usersArrayList.add(new users("vishwesh","ravi","vishalrav345@gmail.com","2",""));
    }
}
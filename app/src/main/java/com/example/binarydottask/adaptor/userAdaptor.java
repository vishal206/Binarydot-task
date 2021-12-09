/**
 Adapter class for recycling view on home page.
 **/

package com.example.binarydottask.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binarydottask.R;
import com.example.binarydottask.model.users;

import java.util.ArrayList;

public class userAdaptor extends RecyclerView.Adapter<userAdaptor.MyViewHolder> {

    private ArrayList<users> usersArrayList;

    public userAdaptor(ArrayList<users> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_users_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String uName=usersArrayList.get(position).getFirstName()+" "+usersArrayList.get(position).getSecondName();
        String uEmail=usersArrayList.get(position).getEmail();
        String uId="ID: "+usersArrayList.get(position).getId();
        holder.uName.setText(uName);
        holder.uEmail.setText(uEmail);
        holder.uId.setText(uId);
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView uName,uEmail,uId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            uName=itemView.findViewById(R.id.text_userName);
            uEmail=itemView.findViewById(R.id.text_userEmail);
            uId=itemView.findViewById(R.id.text_userId);
        }
    }
}

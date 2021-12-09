package com.example.binarydottask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.binarydottask.adaptor.userAdaptor;
import com.example.binarydottask.model.users;

import org.json.JSONException;
import org.json.JSONObject;

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
//        usersArrayList.add(new users("vishal","ravi","vishalravi123@gmail.com","1",""));
//        usersArrayList.add(new users("vishwesh","ravi","vishalrav345@gmail.com","2",""));

        String url = "https://reqres.in/api/users?page=2";


        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(
                            String response)
                    {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            int n=jsonObject.getJSONArray("data").length();
                            System.out.println("--"+n);
                            for (int i = 0; i<n; i++) {
                                System.out.println("+");
                                String firstName=jsonObject.getJSONArray("data").getJSONObject(i).getString("first_name").toString();
                                String secondName=jsonObject.getJSONArray("data").getJSONObject(i).getString("last_name").toString();
                                String email=jsonObject.getJSONArray("data").getJSONObject(i).getString("email").toString();
                                String id=jsonObject.getJSONArray("data").getJSONObject(i).getString("id").toString();
                                String image=jsonObject.getJSONArray("data").getJSONObject(i).getString("avatar").toString();
                                usersArrayList.add(new users(firstName,secondName,email,id,image));
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(
                            VolleyError error)
                    {
                        Toast.makeText(HomeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
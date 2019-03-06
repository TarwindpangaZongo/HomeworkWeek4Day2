package com.example.homeworkweek4day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homeworkweek4day2.Model.Users.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyRecyclerVewAdapter myRecyclerViewAdapter;
    User userToBeAdded;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind RecyclerView
        recyclerView = findViewById(R.id.rvRecyclerView);

        //Recycler View needs 2 items
        //  1. Layout Manager (Can be customized, but we generally us a default
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //  2.RecyclerView adapter (We write this)
        myRecyclerViewAdapter = new MyRecyclerVewAdapter(genetateListOfUsers());
        recyclerView.setAdapter(myRecyclerViewAdapter);

    }

    protected void startRetorfit(){


        RetrofitHelper retrofitHelper = new RetrofitHelper();
        //Start Retrofit in a async way to get our pojo response
        retrofitHelper.getRandomUsers("3").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                String firstName = response.body().getResults().get(0).getName().getFirst();
                String LastName = response.body().getResults().get(0).getName().getLast();
                String Street = response.body().getResults().get(0).getLocation().getStreet();
                String city = response.body().getResults().get(0).getLocation().getCity();
                String state = response.body().getResults().get(0).getLocation().getState();
                String phone = response.body().getResults().get(0).getPhone();
                String email = response.body().getResults().get(0).getEmail();
                String age = response.body().getResults().get(0).getDob().getAge().toString();
                String imageUrl = response.body().getResults().get(0).getPicture().getMedium();

               // Log.d("TAG_RETROFIT", "onResponse: " + email);
                userToBeAdded = ( new User(firstName,LastName,Street,city,state,phone,email,age,imageUrl));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }
    private ArrayList<User> genetateListOfUsers() {
        ArrayList<User> usersArrayList = new ArrayList<>();
        //add ten users
        for (int i = 0; i < 10; i++){
            startRetorfit();
            usersArrayList.add(userToBeAdded);
        }
        return usersArrayList;
    }


}

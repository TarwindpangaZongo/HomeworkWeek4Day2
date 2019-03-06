package com.example.homeworkweek4day2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRecyclerVewAdapter extends RecyclerView.Adapter<MyRecyclerVewAdapter.ViewHolder> {
    //List of user that will be populated into the recycler view
    ArrayList<User> userArrayList;

    //Constructor for the Adapter
    public MyRecyclerVewAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    //Inflate the xml into active memory (renders)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        //return new instance of the viewholder( We need to inflate(render) the view to passing
        //                                           by telling the context of where this is going
        //                                           to be rendered, the layout to inflate, the viewgroup
        //                                            to  assign it to, and if we need a root level attachment)
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false));
    }

    // Once we have the viewholder, we then populated the data when we bind to the created viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        //Get the item's information which we wish to populate for that viewholder
        User currentUserBeingPopulated = userArrayList.get(position);
        //use the passed viewholder to access the items view and populate
        viewHolder.tvFirstName.setText(currentUserBeingPopulated.getFirst());
        viewHolder.tvLastName.setText(currentUserBeingPopulated.getLast());
        viewHolder.tvUserPhone.setText(currentUserBeingPopulated.getPhone());
        viewHolder.tvUserCity.setText(currentUserBeingPopulated.getCity());
        Glide.with(viewHolder.itemView.getContext())
                .load(currentUserBeingPopulated.getImageUrl())
                .into(viewHolder.imaUserImage);
        Log.d("TAG", "onBindViewHolder: item being rendered = " + position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), userArrayList.get(position).getName() + "clicked", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", userArrayList.get(position));
                Intent intentToStartDetails = new Intent(v.getContext(), DetailActivity.class);
                intentToStartDetails.putExtras(bundle);
                v.getContext().startActivity(intentToStartDetails);
            }
        });
    }

    //Add to list, notify the adapter that the info in the list has changed
    public void addBeverageToList(User user) {
        userArrayList.add(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }


    //Inner class view container.  This container holds the views that we will use for each item.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;
        TextView tvUserPhone;
        TextView tvUserCity;
        ImageView imaUserImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstDisplay);
            tvLastName = itemView.findViewById(R.id.tvLastDisplay);
            tvUserPhone = itemView.findViewById(R.id.tvPhoneDisplay);
            tvUserCity = itemView.findViewById(R.id.tvCityDisplay);
            imaUserImage = itemView.findViewById(R.id.imgUser);
        }
    }
}

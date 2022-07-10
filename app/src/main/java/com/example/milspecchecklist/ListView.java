package com.example.milspecchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.milspecchecklist.databinding.ActivityListViewBinding;
import com.example.milspecchecklist.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    ActivityListViewBinding binding; //activity_list_view.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater()); //activity_list_view.xml
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c};
        String[] name = {"Disney Vacation","Winterise Sprinkler System","Get A in Class"};
        String[] lastMessage = {"Disney World vacation planning","Steps to Winterise Sprinkler","Test Checklist"};
        String[] lastmsgTime = {"27 June 2022","27 June 2022","TBD"};
        String[] phoneNo =  {"Details about vacation","Details about Sprinkler","Put some details here"};
        String[] country = {"Lots of details should fit here","Lots of details should fit here","Lots of details should fit here"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(ListView.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListView.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("coutnry",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}
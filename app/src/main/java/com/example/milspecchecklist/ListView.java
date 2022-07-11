package com.example.milspecchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.milspecchecklist.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    ActivityListViewBinding binding; //activity_list_view.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater()); //activity_list_view.xml
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.disney_logo,R.drawable.sprinkler,R.drawable.aplus_color_thumb};
        String[] name = {"Disney Vacation","Winterise Sprinkler System","Get A in Class"};
        String[] cListSubTitle = {"Disney World vacation planning","Steps to Winterise Sprinkler","Test Checklist"};
        String[] cListDate = {"27 June","27 June","TBD"};
        String[] cListInfo =  {"Details about vacation","Details about Sprinkler","Put some details here"};
        String[] cListDetails = {"Lots of disney details fit here","Lots of sprinkler details should fit here","93 Average or bust!"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],cListSubTitle[i],cListDate[i],cListInfo[i],cListDetails[i],imageId[i]);
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
                i.putExtra("phone",cListInfo[position]);
                i.putExtra("country",cListDetails[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);

            }
        });

    }
}
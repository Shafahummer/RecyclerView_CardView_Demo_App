package com.example.recyclerview_cardview_demo_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList=new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.act,"Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Clicked at Qatar"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at Germany"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at India"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Clicked at US"));


        //Config for RecyclerView
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        adapter=new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

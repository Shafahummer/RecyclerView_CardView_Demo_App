package com.example.recyclerview_cardview_demo_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList=new ArrayList<>();

    Button buttonAdd,buttonDelete;
    EditText editTextAdd,editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        generateFakeData();
        recyclerViewConfig();

        buttonAdd=findViewById(R.id.buttonadd);
        buttonDelete=findViewById(R.id.buttondelete);
        editTextAdd=findViewById(R.id.edittextadd);
        editTextDelete=findViewById(R.id.edittextdelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editTextAdd.getText().toString();
                if (TextUtils.isEmpty(s))
                    editTextAdd.setError("Enter any value!");
                else {
                    int position = Integer.parseInt(editTextAdd.getText().toString());
                    addCard(position);
                }
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editTextDelete.getText().toString();
                if (TextUtils.isEmpty(s))
                    editTextDelete.setError("Enter any value!");
                else {
                    int position = Integer.parseInt(editTextDelete.getText().toString());
                    deleteCard(position);
                }

            }
        });

        }


    public void generateFakeData(){

        exampleList.add(new ExampleItem(R.drawable.act,"Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Clicked at Qatar"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at Germany"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at India"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Clicked at US"));


    }
    public void recyclerViewConfig(){

        //Config for RecyclerView
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        adapter=new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void addCard(int position){
        exampleList.add(position,new ExampleItem(R.drawable.act,"New Card Added!"));
        adapter.notifyItemInserted(position);
    }
    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}


package com.example.teamas.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        List<Model> modelList = new ArrayList<>();
        modelList.add(new Model("Schindler's List", "Biography, Drama, History", 1993));
        modelList.add(new Model("Pulp Fiction", "Crime, Drama", 1994));
        modelList.add(new Model("No Country for Old Men", "Crime, Drama, Thriller", 2007));
        modelList.add(new Model("Léon: The Professional", "Crime, Drama, Thriller", 1994));
        modelList.add(new Model("Fight Club", "Drama", 1999));
        modelList.add(new Model("Forrest Gump", "Drama, Romance", 1994));
        modelList.add(new Model("The Shawshank Redemption", "Crime, Drama", 1994));
        modelList.add(new Model("The Godfather", "Crime, Drama", 1972));
        modelList.add(new Model("A Beautiful Mind", "Biography, Drama", 2001));
        modelList.add(new Model("Good Will Hunting", "Drama", 1997));

        ModelAdapter modelAdapter = new ModelAdapter(this, modelList);
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setHasFixedSize(true);

    }
}

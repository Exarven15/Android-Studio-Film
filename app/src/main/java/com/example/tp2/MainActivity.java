package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.Hashtable;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private Button btnAdd;
    private ListView listViewTitles;
    private ArrayList<String> movieTitles;
    private ArrayAdapter<String> adapter;
    private Intent intent;
    private Hashtable<String, String> summaryHashtable = new Hashtable<>();
    private Hashtable<String, Integer> imageHashtable = new Hashtable<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        btnAdd = findViewById(R.id.btnAdd);
        listViewTitles = findViewById(R.id.listViewTitles);

        movieTitles = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movieTitles);
        listViewTitles.setAdapter(adapter);

        intent = new Intent (this, filmClicked.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titre = editTextTitle.getText().toString().trim();
                if (!titre.isEmpty()) {
                    movieTitles.add(titre);
                    adapter.notifyDataSetChanged();
                    editTextTitle.getText().clear();
                    summaryHashtable.put("fight club","A depressed man (Edward Norton) " +
                            "suffering from insomnia meets a strange soap salesman named Tyler " +
                            "Durden (Brad Pitt) and soon finds himself living in his squalid house " +
                            "after his perfect apartment is destroyed. The two bored men form an underground " +
                            "club with strict rules and fight other men who are fed up with their mundane lives. " +
                            "Their perfect partnership frays when Marla (Helena Bonham Carter), a fellow support group crasher, " +
                            "attracts Tyler's attention.");
                    imageHashtable.put("fight club",R.drawable.fightcub);
                }
            }
        });

        listViewTitles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTitle = movieTitles.get(position);
                String summary = summaryHashtable.get(selectedTitle);
                int imageResourceId = imageHashtable.get(selectedTitle); // Récupérez l'identifiant de l'image à partir de la Hashtable

                intent.putExtra("title", selectedTitle); // Transmettez le titre sélectionné à l'activité cible
                intent.putExtra("summary", summary);
                intent.putExtra("imageResourceId", imageResourceId);
                startActivity(intent);

            }
        });
    }
}
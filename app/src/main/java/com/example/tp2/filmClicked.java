package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tp2.databinding.ActivityFilmClickedBinding;

public class filmClicked extends AppCompatActivity {
    private ActivityFilmClickedBinding binding;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_clicked);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String summary = intent.getStringExtra("summary");
            int imageResourceId = intent.getIntExtra("imageResourceId", 0); // 0 est une valeur par défaut

            // Affichez les données dans les vues de l'activité des détails
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView summaryTextView = findViewById(R.id.summaryTextView);
            ImageView imageView = findViewById(R.id.imageView);

            titleTextView.setText(title);
            summaryTextView.setText(summary);
            imageView.setImageResource(imageResourceId);
        }

    }
}

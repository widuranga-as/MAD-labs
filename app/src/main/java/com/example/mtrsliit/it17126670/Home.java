package com.example.mtrsliit.it17126670;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {

        private Button AddDirector, AddFilm,Delete,view;
        private DBHandler DBHandler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            DBHandler = new DBHandler(this);

            AddDirector = findViewById(R.id.hdirector);
            AddFilm = findViewById(R.id.hfilm);
            Delete = findViewById(R.id.hdelete);
            view = findViewById(R.id.hview);

        }
}
package com.example.mtrsliit.it17126670;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ViewFilmsTest {
    public class MainActivity extends ActionBarActivity {
        public final static String EXTRA_MESSAGE = "MESSAGE";
        private ListView obj;
        DBHandler db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            db = new DBHandler(this);
            ArrayList array_list = db.getAllFilmDetails();
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout., array_list);

            obj = (ListView) obj.findViewById();
            obj.setAdapter(arrayAdapter);
            obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                   
                    int id_To_Search = arg2 + 1;

                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("id", id_To_Search);

                    Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

                    intent.putExtras(dataBundle);
                    startActivity(intent);
                }
            });
        }

        public void setContentView(int contentView) {
            this.contentView = contentView;
        }
    }
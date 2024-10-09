package com.example.handbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.handbook.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView list;
    private String [] array;

    private Toolbar toolbar;



    private ArrayAdapter <String> adapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
 //        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = findViewById(R.id.nav_view);



//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.fish);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        int id = menuitem.getItemId();

        if (id == R.id.id_fish) {

           array = getResources().getStringArray(R.array.fish_array);
           adapter.clear();
           adapter.addAll(array);
           adapter.notifyDataSetChanged();
           toolbar.setTitle(R.string.fish);

        } else if
        (id == R.id.id_na) {
           array = getResources().getStringArray(R.array.na_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            toolbar.setTitle(R.string.na);

        } else if (id == R.id.id_sna) {
            array = getResources().getStringArray(R.array.sna_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            toolbar.setTitle(R.string.sna);

        } else if (id == R.id.id_pri) {
            array = getResources().getStringArray(R.array.pri_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            toolbar.setTitle(R.string.pri);

        } else if (id == R.id.id_history) {
            array = getResources().getStringArray(R.array.history_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            toolbar.setTitle(R.string.history);

        } else if (id == R.id.id_advice) {
            array = getResources().getStringArray(R.array.advice_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            toolbar.setTitle(R.string.advice);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
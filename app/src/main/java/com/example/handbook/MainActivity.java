package com.example.handbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import settings.SettingsActivity;
import utils.CustomArrayAdapter;
import utils.ListItemClass;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView list;
    private String [] array, arraySecName;
//    private ArrayAdapter <String> adapter;
    private CustomArrayAdapter adapter;

    private Toolbar toolbar;
    private int category_index;

    private int [] array_fish_color = new int[] {R.color.green, R.color.yellow,R.color.green,R.color.red,R.color.red };
    private List<ListItemClass> listItemMain;

    private ListItemClass listItem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);
        arraySecName = getResources().getStringArray(R.array.fish_array_2);
        listItemMain = new ArrayList<>();

        for (int i = 0; i< array.length; i++ )
        {
          listItem = new ListItemClass();
          listItem.setNameF(array[i]);
          listItem.setSecond_name(arraySecName[i]);
          listItem.setImage_id(array_fish_color[i]);

           listItemMain.add(listItem);
        }

        adapter = new CustomArrayAdapter(this, R.layout.list_view_item_1, listItemMain, getLayoutInflater());




//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
//        list.setAdapter(adapter);




        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
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

    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        int id = menuitem.getItemId();

        if (id == R.id.id_fish) {

            array = getResources().getStringArray(R.array.fish_array);
            arraySecName = getResources().getStringArray(R.array.fish_array_2);
            listItemMain = new ArrayList<>();

            for (int i = 0; i< array.length; i++ )
            {
                listItem = new ListItemClass();
                listItem.setNameF(array[i]);
                listItem.setSecond_name(arraySecName[i]);
                listItem.setImage_id(array_fish_color[i]);

                listItemMain.add(listItem);
            }

            fillArray(R.array.fish_array, R.string.fish, 0);

        } else if
        (id == R.id.id_na) {
            fillArray(R.array.na_array, R.string.na, 1);


        } else if (id == R.id.id_sna) {

            fillArray(R.array.sna_array, R.string.sna, 2);


        } else if (id == R.id.id_pri) {
            fillArray(R.array.pri_array, R.string.pri, 3);


        } else if (id == R.id.id_history) {
            fillArray(R.array.history_array, R.string.history, 4);


        } else if (id == R.id.id_advice) {
            fillArray(R.array.advice_array, R.string.advice, 5);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void fillArray (int title,int arrayList, int index) {
//        array = getResources().getStringArray(title);
//        adapter.clear();
//        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        toolbar.setTitle(arrayList);
        category_index = index;

    }


}
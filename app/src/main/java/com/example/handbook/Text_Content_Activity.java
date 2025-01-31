package com.example.handbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {

    private ActionBar actionBar;
    private TextView text_content;
    private Typeface face1;
    private ImageView iContent;
    private SharedPreferences def_pref;

    private int category = 0;
    private int position = 0;
    private int [] array_fish = {R.string.fish_karp, R.string.fish_s4uka,R.string.fish_som,R.string.fish_osetr,R.string.fish_nalim};
    private int [] array_na = {R.string.na1, R.string.na2,R.string.na3,R.string.na4};
    private int [] array_image_fish = {R.drawable.karp, R.drawable.s4uka, R.drawable.som, R.drawable.osetr, R.drawable.nalim};
    private String [] array_title_fish = {"Карп", "Щука", "Сом", "Осетр", "Налим"};

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);

        init();
        reciveIntent();

    }
    private void reciveIntent()
    {
        Intent i =getIntent();
        if (i!=null)
        {
        category = i.getIntExtra("category",0);
        position = i.getIntExtra("position",0);
        }

        switch (category){
            case 0:
                text_content.setText(array_fish[position]);
                iContent.setImageResource(array_image_fish[position]);
                actionBar.setTitle(array_title_fish[position]);

                break;
            case 1:
                text_content.setText(array_na[position]);

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

        }

    }
private void init () {

        def_pref = PreferenceManager.getDefaultSharedPreferences(this);


    text_content = findViewById(R.id.text_main_content);
    actionBar = getSupportActionBar();
    iContent = findViewById(R.id.imageContent);
    face1 = Typeface.createFromAsset(this.getAssets(), "fonts/Lobster-Regular.ttf");
    text_content.setTypeface(face1);

    String text = def_pref.getString("main_text_size", "Средний");
    if (text != null){

    switch (text){

        case "Большой" :
            text_content.setTextSize(24);
            break;
            case "Средний" :
            text_content.setTextSize(18);
            break;
            case "Маленький" :
            text_content.setTextSize(14);
            break;


    }
    }

}

}

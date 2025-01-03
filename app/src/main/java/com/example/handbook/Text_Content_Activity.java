package com.example.handbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private ImageView iContent;
    private int category = 0;
    private int position = 0;
    private int [] array_fish = {R.string.fish1, R.string.fish2,R.string.fish3,R.string.fish4,R.string.fish5};
    private int [] array_na = {R.string.na1, R.string.na2,R.string.na3,R.string.na4};
    private int [] array_image_fish = {R.drawable.som, R.drawable.s4uka, R.drawable.karp, R.drawable.osetr, R.drawable.nalim};

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);

        iContent = findViewById(R.id.imageContent);
        recieveIntent();

    }
    private void recieveIntent()
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


}

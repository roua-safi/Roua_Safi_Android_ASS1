package com.example.hellotoast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @SuppressLint("StaticFieldLeak")
    public static ActivityMainBinding mainBinding;


//    public TextView displayCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            int grey = ContextCompat.getColor(this, R.color.grey);
            mainBinding.buttonZero.setBackgroundColor(grey);
            return insets;
        });

//        displayCountText = findViewById(R.id.text_display_count);
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        int red = ContextCompat.getColor(this, R.color.red);
        int blue = ContextCompat.getColor(this, R.color.blue);
        int green = ContextCompat.getColor(this, R.color.green);

        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
        mainBinding.buttonZero.setBackgroundColor(red);

        if(count%2==0){
            mainBinding.buttonCount.setBackgroundColor(blue);


        }else{mainBinding.buttonCount.setBackgroundColor(green);}
//        displayCountText.setText(String.valueOf(count));
    }
    public void click_zero(View view) {
        count=0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
        int grey = ContextCompat.getColor(this, R.color.grey);
        mainBinding.buttonZero.setBackgroundColor(grey);
        int purple = ContextCompat.getColor(this, R.color.purple);
        mainBinding.buttonCount.setBackgroundColor(purple);

//        displayCountText.setText(String.valueOf(count));
    }
}
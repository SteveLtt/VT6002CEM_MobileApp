package com.example.mobileapp_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    EditText EditTextname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();

        final TextView EditTextname = (TextView) findViewById(R.id.detail_name);
        final ImageView detail_image = (ImageView)findViewById(R.id.detail_image);
        EditTextname.setText(name);


        detail_image.setImageResource(R.drawable.umbrella);

    }
    private void back(){
        Intent i=new Intent(this, MapsActivity.class);
        this.startActivity(i);
    }
}
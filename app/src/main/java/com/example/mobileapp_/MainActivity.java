package com.example.mobileapp_;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobileapp_.adapter.RecentsAdapter;
import com.example.mobileapp_.model.RecentsData;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;
    SharedPreferences sp;
    ImageView scann;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);

        scann = findViewById(R.id.scann);

        scann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                MainActivity.this
                );
                intentIntegrator.setPrompt("For flash use volume up key");
                intentIntegrator.setBarcodeImageEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(
          requestCode,resultCode,data
        );

        if(intentResult.getContents() !=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            builder.setTitle("Resu;t");
            builder.setMessage(intentResult.getContents());

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();

        }else{
            Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();
        }
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }

    public void map(View v){
        Intent i=new Intent(this, MapsActivity.class);
        this.startActivity(i);
    }

    public void detail(View v){
        Intent i=new Intent(this, DetailActivity.class);
        this.startActivity(i);
    }
    public void login(View v){
        sp = getApplicationContext().getSharedPreferences("User",MODE_PRIVATE);
        String id = sp.getString("id","");
        if(id != null){
            Toast.makeText(MainActivity.this,"logined",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,ProfileActivity.class));

        }else{
            Intent i=new Intent(this, LoginActivity.class);
            this.startActivity(i);
        }

    }



}
package com.example.mobileapp_;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
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
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;
    SharedPreferences sp;
    ImageView scann;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Automatic umbrellas","Type:Automatic","$200",R.drawable.automatic_umbrellas));
        recentsDataList.add(new RecentsData("Collapsible umbrella","Type:Manual","$300",R.drawable.collapsible_umbrella));
        recentsDataList.add(new RecentsData("Umbrella","Type:Manual","$400",R.drawable.umbrella));
        recentsDataList.add(new RecentsData("Oil paper umbrella","Type:Automatic","$150",R.drawable.oil_paper_umbrella));
        recentsDataList.add(new RecentsData("Parasol","Type:Manual","$400",R.drawable.parasol));
        recentsDataList.add(new RecentsData("Hand-crafted umbrellas","Type:Manual","$500",R.drawable.hand_crafted_umbrellas));

        setRecentRecycler(recentsDataList);

        scann = findViewById(R.id.scann);

        scann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                MainActivity.this
                );
                intentIntegrator.setPrompt("Please scan the QR code");
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
            builder.setTitle("Result");
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
    //direct to map page
    public void map(View v){
        Intent i=new Intent(this, MapsActivity.class);
        this.startActivity(i);
    }
    //direct to detail page
    public void detail(View v){
        Intent i=new Intent(this, DetailActivity.class);
        this.startActivity(i);
    }
    public void login(View v){




        sp = getApplicationContext().getSharedPreferences("User",MODE_PRIVATE);
        String id = sp.getString("id","");

        if(id == ""){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        }else{

            Toast.makeText(MainActivity.this,"Login success",Toast.LENGTH_LONG).show();

            BiometricManager biometricManager = BiometricManager.from(this);
            switch (biometricManager.canAuthenticate()){
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(getApplicationContext(),"Device Doesn't have fingerprint",Toast.LENGTH_LONG).show();
                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(getApplicationContext(),"Not working",Toast.LENGTH_LONG).show();
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(getApplicationContext(),"No FingerPrint Assigned",Toast.LENGTH_LONG).show();
            }

            Executor executor = ContextCompat.getMainExecutor(this);

            biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));

                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    Toast.makeText(MainActivity.this,"Login failed, Please login again",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Login")
                    .setDescription("Use FingerPrint To Login").setDeviceCredentialAllowed(true).build();

            biometricPrompt.authenticate(promptInfo);
        }






    }



}
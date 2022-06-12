package com.example.mobileapp_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    TextView EditTextname,EditTextdesc;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();

         TextView EditTextname = (TextView) findViewById(R.id.detail_name);
         ImageView detail_image = (ImageView)findViewById(R.id.detail_image);
         TextView EditTextdesc = (TextView)findViewById(R.id.deatil_desc);

        mQueue = Volley.newRequestQueue(this);
        String url = "https://api.employeasy.hk/api/get_detail_a.php?id="+name;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            String a = response.getString("name");
//                            Log.d("nameJson",a);
                            JSONArray jsonArray = response.getJSONArray("detail");


                            for(int i =0;i<jsonArray.length();i++){
                                JSONObject detail = jsonArray.getJSONObject(i);
                                String nameq= detail.getString("name");
                                String desc = detail.getString("desc");
                                String photo = detail.getString("photo");
                                Log.d("nameJson",name);
                                Log.d("descJson",desc);
                                Log.d("photo",photo);
                                //
                                EditTextname.setText(nameq);
                                EditTextdesc.setText(desc);

                                switch (photo){
                                    case "automatic_umbrellas":
                                        detail_image.setImageResource(R.drawable.automatic_umbrellas);
                                        break;
                                    case "collapsible_umbrella":
                                        detail_image.setImageResource(R.drawable.collapsible_umbrella);
                                        break;
                                    case "umbrella":
                                        detail_image.setImageResource(R.drawable.umbrella);
                                        break;
                                    case "oil_paper_umbrella":
                                        detail_image.setImageResource(R.drawable.oil_paper_umbrella);
                                        break;
                                    case "parasol":
                                        detail_image.setImageResource(R.drawable.parasol);
                                        break;
                                    case "hand_crafted_umbrellas":
                                        detail_image.setImageResource(R.drawable.hand_crafted_umbrellas);
                                        break;

                                }


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
    private void back(){
        Intent i=new Intent(this, MapsActivity.class);
        this.startActivity(i);
    }

    private  void GetDtail(){

    }

}
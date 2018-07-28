package com.astagenta.rangga.json_parsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private TempatAdapter mTempatAdapter;
    private ArrayList<TempatItem> mTempatList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mTempatList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "http://nearyou.ranggasatria.com/index.php/json/read";

//        String url = "https://pixabay.com/api/?key=9613285-d8653d4b8597a6c4bb2ef932c&q=yellow+flowers&image_type=photo";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    //get data from json
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("tempat");
                            for (int i = 0; i < jsonArray.length() ; i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String imageUrl = hit.getString("kategori_icon");
                                String name = hit.getString("tempat_nama");
//                                String latitude = hit.getString("tempat_latitude");
//                                String longitude = hit.getString("tempat_longitude");
//                                String category = hit.getString("kategori_name");

                                mTempatList.add(new TempatItem(imageUrl, name));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mTempatAdapter = new TempatAdapter(MainActivity.this, mTempatList);
                        mRecycleView.setAdapter(mTempatAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            // error condition
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}
